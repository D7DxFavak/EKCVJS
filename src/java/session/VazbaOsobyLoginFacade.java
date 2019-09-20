/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Osoby;
import entity.VazbaOsobyLogin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaOsobyLoginFacade extends AbstractFacade<VazbaOsobyLogin> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaOsobyLoginFacade() {
        super(VazbaOsobyLogin.class);
    }
    
    public VazbaOsobyLogin findByVazbaOsobaId(Osoby idOsoba) {                
        return em.createNamedQuery("VazbaOsobyLogin.findByVazbaOsobaId", VazbaOsobyLogin.class).setParameter("vazbaOsobaId", idOsoba).getSingleResult();
        
    }
    
}
