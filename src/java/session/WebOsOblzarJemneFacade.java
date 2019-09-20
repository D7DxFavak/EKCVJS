/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebOsOblzarHrube;
import entity.WebOsOblzarJemne;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebOsOblzarJemneFacade extends AbstractFacade<WebOsOblzarJemne> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebOsOblzarJemneFacade() {
        super(WebOsOblzarJemne.class);
    }

    public List findByOzHrube(WebOsOblzarHrube osOzHrube) {
        return em.createNamedQuery("WebOsOblzarJemne.findByWebOblzarHrubeId", WebOsOblzarJemne.class).setParameter("webOblzarHrubeId", osOzHrube).getResultList();
    }
    
    
}

