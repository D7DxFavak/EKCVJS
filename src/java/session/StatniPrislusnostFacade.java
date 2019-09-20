/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.StatniPrislusnost;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class StatniPrislusnostFacade extends AbstractFacade<StatniPrislusnost> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatniPrislusnostFacade() {
        super(StatniPrislusnost.class);
    }
    
    public List findAllOrderPoradi() {
        return em.createNamedQuery("StatniPrislusnost.findAll", StatniPrislusnost.class).getResultList();
    }
    
}
