/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkceAkreditace;
import entity.AkceHlavni;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class AkceAkreditaceFacade extends AbstractFacade<AkceAkreditace> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AkceAkreditaceFacade() {
        super(AkceAkreditace.class);
    }
    
    public AkceAkreditace findByAkceId(int ah) {        
        return em.createNamedQuery("AkceAkreditace.findByAkceId", AkceAkreditace.class)
                .setParameter("akceId", ah).getSingleResult();
    }
    
}
