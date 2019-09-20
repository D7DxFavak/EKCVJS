/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebMainPage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class WebMainPageFacade extends AbstractFacade<WebMainPage> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebMainPageFacade() {
        super(WebMainPage.class);
    }
    
     public List findByPoradiVyber() {        
        return em.createNamedQuery("WebMainPage.findAll", WebMainPage.class).getResultList();
    }
    
}
