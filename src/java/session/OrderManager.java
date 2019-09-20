/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import cart.ShoppingCart;
import entity.AkceHlavni;
import entity.DruhyFaktur;
import entity.DruhyPrihlasek;
import entity.Obdobi;
import entity.Osoby;
import entity.PrihlaskyDruhy;
import entity.PrihlaskyRozpisy;
import entity.StavyPrihlasek;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sprava.PripojeniDB;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private PrihlaskyRozpisyFacade prihlaskyRozpisyFacade;
    @EJB
    private AkceHlavniFacade akceHlavniFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public ArrayList<PrihlaskyRozpisy> placeOrder(String name, String surname, String email, String phone, String address, String birthDate, ShoppingCart cart) {

        try {
            Osoby customer = addCustomer(name, surname, email, phone, address, birthDate);
            ArrayList<PrihlaskyRozpisy> objednavky = addOrder(customer, cart);
            return objednavky;

        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
    private Osoby addCustomer(String name, String surname, String email, String phone, String address, String birthDate) {
        java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        Osoby zakaznik = new Osoby();

        try {
            ResultSet q = PripojeniDB.dotazS("SELECT p FROM inc_osobaid() p");
            while (q.next()) {
                zakaznik.setOsobaId(q.getInt(1));
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        zakaznik.setJmeno(name);
        zakaznik.setPrijmeni(surname);
        try {
            zakaznik.setDatumNarozeni(df.parse(birthDate));
        } catch (Exception e) {
            zakaznik.setDatumNarozeni(null);
            e.printStackTrace();
        }
        zakaznik.setEMail(email);
        zakaznik.setTelefon(phone);
        zakaznik.setAdresa(address);
        zakaznik.setMesto("Plzen");
        zakaznik.setPsc("334 09");

        em.persist(zakaznik);
        return zakaznik;
    }

    private ArrayList<PrihlaskyRozpisy> addOrder(Osoby zakaznik, ShoppingCart kosik) {

        em.flush();

        ArrayList<PrihlaskyRozpisy> objednavkaSet = new ArrayList<PrihlaskyRozpisy>();
        int polozka = 0;
        try {
            ResultSet q = PripojeniDB.dotazS("SELECT p FROM inc_rozpisprihlid() p");
            while (q.next()) {
                polozka = (q.getInt(1));
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < kosik.getItems().size(); i++) {

            PrihlaskyRozpisy objednavka = new PrihlaskyRozpisy();
            objednavka.setPolozka(polozka + i);
            objednavka.setOsoba(zakaznik);
            objednavka.setPlatceOs(zakaznik);
            objednavka.setOdberatelOs(zakaznik);
            objednavka.setObjednavatelOs(zakaznik);
            objednavka.setAkce(kosik.getItems().get(i).getProduct());
            objednavka.setPrihlaseniZpusob(null);
            DruhyPrihlasek dp = new DruhyPrihlasek();
            dp.setDruhPrihlId(3);
            Obdobi ob = new Obdobi();
            ob.setObdobiId(25);
            StavyPrihlasek sp = new StavyPrihlasek();
            sp.setStavPrihlId(1);
            PrihlaskyDruhy pd = new PrihlaskyDruhy();
            pd.setPrihlaskyDruhyId(4);
            DruhyFaktur df = new DruhyFaktur();
            df.setDruhFakturyId(3);
            objednavka.setDruhprihl(dp);
            objednavka.setDruhfakt(df);
            objednavka.setObdobi(ob);
            objednavka.setPrihlaseniZpusob(pd);


            em.persist(objednavka);
            objednavkaSet.add(objednavka);
        }

        // create confirmation number

        return objednavkaSet;
    }

    public Map getOrderDetails(int prihlaskyID) {

        Map orderMap = new HashMap();

        // get order
        PrihlaskyRozpisy prihlaska = prihlaskyRozpisyFacade.find(prihlaskyID);
        //  CustomerOrder order = customerOrderFacade.find(orderId);

        BigDecimal total = BigDecimal.ZERO.setScale(2);
        // get customer
        Osoby customer = prihlaska.getOsoba();

        // get all ordered products

        List<PrihlaskyRozpisy> orderedProducts = em.createNamedQuery("PrihlaskyRozpisy.findByOsoba").setParameter("osoba", customer).getResultList();

        // get product details for ordered items
        List<AkceHlavni> products = new ArrayList<AkceHlavni>();

        for (PrihlaskyRozpisy op : orderedProducts) {
            AkceHlavni p = (AkceHlavni) akceHlavniFacade.find(op.getAkce().getAkceId());
            total = total.add(p.getUcastnickyPoplatek());            
            products.add(p);
        }

        // add each item to orderMap       
        orderMap.put("total", total.toString());
        orderMap.put("customer", customer);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", products);

        return orderMap;
    }
}
