/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.VazbaAkreditaceUlozisteData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class VazbaAkreditaceUlozisteDataFacade extends AbstractFacade<VazbaAkreditaceUlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaAkreditaceUlozisteDataFacade() {
        super(VazbaAkreditaceUlozisteData.class);
    }
    
    
}
