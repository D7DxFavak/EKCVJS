/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UlozisteData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class UlozisteDataFacade extends AbstractFacade<UlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UlozisteDataFacade() {
        super(UlozisteData.class);
    }
    
    public UlozisteData findById(int id) {
        UlozisteData ud = (UlozisteData) em.createNamedQuery("UlozisteData.findByUlozisteDataId").setParameter("ulozisteDataId", id).getSingleResult();
        em.refresh(ud);
        return ud;
    }
    
    public UlozisteData findByNazev(String nazev) {       
            return (UlozisteData) em.createNamedQuery("UlozisteData.findByUlozisteDataNazev").setParameter("ulozisteDataNazev", nazev).getSingleResult();        
    }

    
}
