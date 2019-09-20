/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebVazbaKategorieAkceHlavni;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebVazbaKategorieAkceHlavniFacade extends AbstractFacade<WebVazbaKategorieAkceHlavni> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebVazbaKategorieAkceHlavniFacade() {
        super(WebVazbaKategorieAkceHlavni.class);
    }
    
}
