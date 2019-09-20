/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Narodnost;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class NarodnostFacade extends AbstractFacade<Narodnost> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NarodnostFacade() {
        super(Narodnost.class);
    }
    
    public List findAllOrderPoradi() {
        return em.createNamedQuery("Narodnost.findAll", Narodnost.class).getResultList();
    }
    
}
