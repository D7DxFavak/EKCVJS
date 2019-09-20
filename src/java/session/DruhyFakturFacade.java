/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DruhyFaktur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class DruhyFakturFacade extends AbstractFacade<DruhyFaktur> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DruhyFakturFacade() {
        super(DruhyFaktur.class);
    }
    
    public DruhyFaktur findById(int id) {
         return em.createNamedQuery("DruhyFaktur.findByDruhFakturyId", DruhyFaktur.class).setParameter("druhFakturyId", id).getSingleResult();
    }
    
}
