/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OboryVazbySkupiny;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class OboryVazbySkupinyFacade extends AbstractFacade<OboryVazbySkupiny> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OboryVazbySkupinyFacade() {
        super(OboryVazbySkupiny.class);
    }
        
    public List findBySkupinyId(int skupinaId) {        
        return em.createNamedQuery("OboryVazbySkupiny.findByOboryVazbySkupinyOborySkupinyId", OboryVazbySkupiny.class).setParameter("oboryVazbySkupinyOborySkupinyId", skupinaId).getResultList();
    }
    
    public List<OboryVazbySkupiny> findBySkupinyIdLimit(int idSkupina) {       
        return em.createNamedQuery("OboryVazbySkupiny.findByOboryVazbySkupinyOborySkupinyId", OboryVazbySkupiny.class).setParameter("oboryVazbySkupinyOborySkupinyId", idSkupina).setMaxResults(1).getResultList();
    }
}
