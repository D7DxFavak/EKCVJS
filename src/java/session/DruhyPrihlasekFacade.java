/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DruhyPrihlasek;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class DruhyPrihlasekFacade extends AbstractFacade<DruhyPrihlasek> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DruhyPrihlasekFacade() {
        super(DruhyPrihlasek.class);
    }
    
    public List findProOrganizace() {
        return em.createNamedQuery("DruhyPrihlasek.findByPozadDruhprihl", DruhyPrihlasek.class).setParameter("pozadDruhprihl", 1).getResultList();
    }
    
    public DruhyPrihlasek findById(int id) {
         return em.createNamedQuery("DruhyPrihlasek.findByDruhPrihlId", DruhyPrihlasek.class).setParameter("druhPrihlId", id).getSingleResult();
    }
    
}
