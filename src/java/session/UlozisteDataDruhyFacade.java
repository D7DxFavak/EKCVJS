/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UlozisteDataDruhy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class UlozisteDataDruhyFacade extends AbstractFacade<UlozisteDataDruhy> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UlozisteDataDruhyFacade() {
        super(UlozisteDataDruhy.class);
    }
    
     public UlozisteDataDruhy findById(int id) {
        return em.createNamedQuery("UlozisteDataDruhy.findByUlozisteDataDruhyId", UlozisteDataDruhy.class).setParameter("ulozisteDataDruhyId", id).getSingleResult();
    }
    
}
