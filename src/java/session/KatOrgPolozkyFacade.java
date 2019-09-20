/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.KatOrgPolozky;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class KatOrgPolozkyFacade extends AbstractFacade<KatOrgPolozky> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public KatOrgPolozkyFacade() {
        super(KatOrgPolozky.class);
    }
    
    public List findByKategorieTyp(int id) {        
        return em.createNamedQuery("KatOrgPolozky.findByKatorgtypId", KatOrgPolozky.class).setParameter("katorgtypId", id).getResultList();
    }
    
    public KatOrgPolozky findById(int idTyp, int idDruh) {
        return em.createNamedQuery("KatOrgPolozky.findById", KatOrgPolozky.class)
                .setParameter("katorgpolId", idDruh).setParameter("katorgtypId", idTyp).getSingleResult();
    }
           
}
