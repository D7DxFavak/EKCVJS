/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PrihlaskyRozpisy;
import entity.VyberPrihlaskyFakturace;
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
public class VyberPrihlaskyFakturaceFacade extends AbstractFacade<VyberPrihlaskyFakturace> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VyberPrihlaskyFakturaceFacade() {
        super(VyberPrihlaskyFakturace.class);
    }
    
    public void prihlasit(PrihlaskyRozpisy x) {
        VyberPrihlaskyFakturace p = new VyberPrihlaskyFakturace(x.getPolozka(), x.getDruhprihl().getDruhPrihlId(), x.getDruhfakt().getFakturaDruh());
        p.setFakturovat(true);        
        em.persist(p);

    }

    public List fakturujPrihlaskyJSZaloha(PrihlaskyRozpisy x) {
        List faktury = new ArrayList();
        try {
            ResultSet q = PripojeniDB.dotazS("SELECT * FROM fakturuj_prihlasky_zaloha((SELECT current_date), (SELECT current_date), " + x.getDruhprihl().getDruhPrihlId() + ")");
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
