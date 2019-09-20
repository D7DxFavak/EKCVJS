/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.StavyPrihlasek;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class StavyPrihlasekFacade extends AbstractFacade<StavyPrihlasek> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public StavyPrihlasekFacade() {
        super(StavyPrihlasek.class);
    }
    
}
