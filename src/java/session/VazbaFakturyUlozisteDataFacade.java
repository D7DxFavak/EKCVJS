/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AbstractFacade;
import entity.KnihaFaktur;
import entity.VazbaFakturyUlozisteData;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaFakturyUlozisteDataFacade extends AbstractFacade<VazbaFakturyUlozisteData> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaFakturyUlozisteDataFacade() {
        super(VazbaFakturyUlozisteData.class);
    }

    public long findPocetVazbyFakturyUlozisteData(KnihaFaktur kf) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaFakturyUlozisteData v "
                + "WHERE v.vazbaFakturyUlozisteDataPK.vazbaFakturyUlozisteDataFakturyId = :vazbaFakturyUlozisteDataFakturyId";
        return em.createQuery(dotaz, Long.class).
                setParameter("vazbaFakturyUlozisteDataFakturyId", kf.getCisloFaktury()).getSingleResult();
    }
    
     public VazbaFakturyUlozisteData findVazbyFakturyUlozisteData(int kf) {
        String dotaz = "SELECT v "
                + "FROM VazbaFakturyUlozisteData v "
                + "WHERE v.vazbaFakturyUlozisteDataPK.vazbaFakturyUlozisteDataFakturyId = :vazbaFakturyUlozisteDataFakturyId";
        return em.createQuery(dotaz, VazbaFakturyUlozisteData.class).
                setParameter("vazbaFakturyUlozisteDataFakturyId", kf).getSingleResult();
    }
}
