/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebKategorieZakladni;
import entity.WebPanely;
import entity.WebPanelyData;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebPanelyDataFacade extends AbstractFacade<WebPanelyData> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebPanelyDataFacade() {
        super(WebPanelyData.class);
    }

    public List findByStranka(WebPanely panel) {       
        
        return em.createNamedQuery("WebPanelyData.findByWebPanelyDataPanel", WebPanelyData.class)
                .setParameter("webPanelyDataPanel", panel).getResultList();
    }
    
    public List<WebPanelyData> findByNazevPopis(String vyraz) {
        List<WebPanelyData> wpdOut = new ArrayList<WebPanelyData>();
        wpdOut.addAll(em.createQuery("SELECT w FROM WebPanelyData w WHERE (lower(w.webPanelyDataPopis) LIKE :vyraz) OR (lower(w.webPanelyDataPopisEn) LIKE :vyraz) "
                + "OR (lower(w.webPanelyDataPopisDe) LIKE :vyraz) OR (lower(w.webPanelyDataNazev) LIKE :vyraz) OR (lower(w.webPanelyDataNazevEn) LIKE :vyraz) "
                + "OR (lower(w.webPanelyDataNazevDe) LIKE :vyraz) ORDER BY w.webPanelyDataPoradiVyber" ).
                setParameter("vyraz", "%" + vyraz + "%").getResultList());
       // wpdOut.get(0).getWebPanelyDataPanel().getWebPanelyZalozka()
        return wpdOut;
    }
}
