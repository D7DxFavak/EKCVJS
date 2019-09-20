   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebKategorieZakladni;
import entity.WebPanely;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebPanelyFacade extends AbstractFacade<WebPanely> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebPanelyFacade() {
        super(WebPanely.class);
    }
    
    public List findByZalozka(String zalozka) {        
        return em.createNamedQuery("WebPanely.findByWebPanelyZalozka", WebPanely.class).setParameter("webPanelyZalozka", zalozka).getResultList();
    }
    
    public List findById(int id) {        
        return em.createNamedQuery("WebPanely.findByWebPanelyId", WebPanely.class).setParameter("webPanelyId", id).getResultList();
    }
    
    public WebPanely findByOdkazKategorie(String odkaz, WebKategorieZakladni wkz) {
        return em.createNamedQuery("WebPanely.findByOdkazKategorie", WebPanely.class)
                .setParameter("webPanelyOdkaz", odkaz).setParameter("webPanelyKategorie", wkz).getSingleResult();
    }
    
    
    
}
