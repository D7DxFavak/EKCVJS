/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.RegionyOkresy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class RegionyOkresyFacade extends AbstractFacade<RegionyOkresy> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionyOkresyFacade() {
        super(RegionyOkresy.class);
    }
    
    public RegionyOkresy findById(int id) {
        return em.createNamedQuery("RegionyOkresy.findByRoId", RegionyOkresy.class).setParameter("roId", id).getSingleResult();
    }
    
}
