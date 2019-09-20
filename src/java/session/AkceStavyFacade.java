/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkceStavy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class AkceStavyFacade extends AbstractFacade<AkceStavy> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AkceStavyFacade() {
        super(AkceStavy.class);
    }
    
    public AkceStavy findById(int id) {
        return em.createNamedQuery("AkceStavy.findByStavAkceId", AkceStavy.class).setParameter("stavAkceId", id).getSingleResult();
    }
    
}
