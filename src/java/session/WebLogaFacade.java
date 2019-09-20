/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebLoga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class WebLogaFacade extends AbstractFacade<WebLoga> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebLogaFacade() {
        super(WebLoga.class);
    }
    
    public List findByWebLogaUlozisteDruh(int druhLoga) {
       return em.createNamedQuery("WebLoga.findByWebLogaUlozisteDruh")
                .setParameter("ulozisteDataDruhyId", druhLoga).getResultList();
    }
    
    public WebLoga findByUlozisteId(int ulozisteId) {
       return em.createNamedQuery("WebLoga.findByWebLogaUlozisteDataId", WebLoga.class)
                .setParameter("ulozisteDataId", ulozisteId).getSingleResult();
    }
    
}
