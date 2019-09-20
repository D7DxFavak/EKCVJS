/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkreditaceHlavni;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class AkreditaceHlavniFacade extends AbstractFacade<AkreditaceHlavni> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AkreditaceHlavniFacade() {
        super(AkreditaceHlavni.class);
    }
    
}
