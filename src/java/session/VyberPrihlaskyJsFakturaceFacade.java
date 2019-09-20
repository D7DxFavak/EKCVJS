/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PrihlaskyRozpisyJs;
import entity.VyberPrihlaskyJsFakturace;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sprava.PripojeniDB;

/**
 *
 * @author Favak
 */
@Stateless
public class VyberPrihlaskyJsFakturaceFacade extends AbstractFacade<VyberPrihlaskyJsFakturace> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VyberPrihlaskyJsFakturaceFacade() {
        super(VyberPrihlaskyJsFakturace.class);
    }

    public void prihlasit(PrihlaskyRozpisyJs x) {
        if (x.getOsoba().getAdresa().isEmpty() || x.getOsoba().getPsc().isEmpty() || x.getOsoba().getMesto().isEmpty()) {
        } else {
            VyberPrihlaskyJsFakturace p = new VyberPrihlaskyJsFakturace(x.getPolozka(), x.getDruhprihl().getDruhPrihlId(), x.getDruhfakt().getFakturaDruh());
            p.setFakturovat(true);           
            em.persist(p);
        }

    }

    public List fakturujPrihlaskyJSZaloha(PrihlaskyRozpisyJs x) {
        List faktury = new ArrayList();
        try {            
            ResultSet q = PripojeniDB.dotazS("SELECT * FROM fakturuj_prihlasky_js_zaloha((SELECT current_date), (SELECT current_date), " + x.getDruhprihl().getDruhPrihlId() + ")");
            while (q.next()) {
                faktury.add(q.getInt(1));
            }
            PripojeniDB.rs.close();
            PripojeniDB.pstmt.close();
            PripojeniDB.con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faktury;

    }
}
