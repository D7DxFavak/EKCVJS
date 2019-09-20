/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkceRezimZverejneni;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class AkceRezimZverejneniFacade extends AbstractFacade<AkceRezimZverejneni> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AkceRezimZverejneniFacade() {
        super(AkceRezimZverejneni.class);
    }
    
    public AkceRezimZverejneni findById(int id) {
        return em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", id).getSingleResult();
    }
    
    
    
    
    
    
}
