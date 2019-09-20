/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.WebKategorieZakladni;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebKategorieZakladniFacade extends AbstractFacade<WebKategorieZakladni> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebKategorieZakladniFacade() {
        super(WebKategorieZakladni.class);
    }
    
    public WebKategorieZakladni findById(int id) {          
        return em.createNamedQuery("WebKategorieZakladni.findByWebKategorieZakladniId", WebKategorieZakladni.class)
                .setParameter("webKategorieZakladniId", id).getSingleResult();
    }
    
}
