/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.KatOrgTypy;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class KatOrgTypyFacade extends AbstractFacade<KatOrgTypy> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public KatOrgTypyFacade() {
        super(KatOrgTypy.class);
    }
    
    public List findAll() {        
        return em.createNamedQuery("KatOrgTypy.findAll", KatOrgTypy.class).getResultList();
    }
    
    public KatOrgTypy findById(int id) {
        return em.createNamedQuery("KatOrgTypy.findByKatorgtypId", KatOrgTypy.class).setParameter("katorgtypId", id).getSingleResult();
    }
    
}
