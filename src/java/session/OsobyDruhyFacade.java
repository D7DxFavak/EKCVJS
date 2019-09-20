/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OsobyDruhy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class OsobyDruhyFacade extends AbstractFacade<OsobyDruhy> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OsobyDruhyFacade() {
        super(OsobyDruhy.class);
    }
    
}
