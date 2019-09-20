/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkceHlavni;
import entity.UlozisteData;
import entity.VazbaAkceUlozisteData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class VazbaAkceUlozisteDataFacade extends AbstractFacade<VazbaAkceUlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaAkceUlozisteDataFacade() {
        super(VazbaAkceUlozisteData.class);
    }
     public VazbaAkceUlozisteData findByAkce(AkceHlavni akce) {
        return (VazbaAkceUlozisteData) em.createNamedQuery("VazbaAkceUlozisteData.findByVazbaOsobyUlozisteDataAkceId")
                .setParameter("vazbaOsobyUlozisteDataAkceId", akce).getSingleResult();
    }
     
      public VazbaAkceUlozisteData findByAkce(int akce) {
        return (VazbaAkceUlozisteData) em.createNamedQuery("VazbaAkceUlozisteData.findByVazbaOsobyUlozisteDataAkceId")
                .setParameter("vazbaOsobyUlozisteDataAkceId", akce).getSingleResult();
    }
    
}
