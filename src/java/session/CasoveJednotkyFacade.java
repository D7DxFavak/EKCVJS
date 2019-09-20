/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CasoveJednotky;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class CasoveJednotkyFacade extends AbstractFacade<CasoveJednotky> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CasoveJednotkyFacade() {
        super(CasoveJednotky.class);
    }
    
}
