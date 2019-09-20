/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebKategorieZakladni;
import entity.WebOsOblzarHrube;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebOsOblzarHrubeFacade extends AbstractFacade<WebOsOblzarHrube> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebOsOblzarHrubeFacade() {
        super(WebOsOblzarHrube.class);
    }
    
    public WebOsOblzarHrube findById(int id) {      
        return em.createNamedQuery("WebOsOblzarHrube.findByWebOblzarHrubeId", WebOsOblzarHrube.class).setParameter("webOblzarHrubeId", id).getSingleResult();
    }
    
    public List findByKategorie(WebKategorieZakladni id) {        
        return em.createNamedQuery("WebOsOblzarHrube.findByWebOblzarKategorie", WebOsOblzarHrube.class).setParameter("webOblzarHrubeKategorie", id).getResultList();
    }
    
       
}
