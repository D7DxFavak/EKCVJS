/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Osoby;
import entity.VazbaOsobyUlozisteData;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class VazbaOsobyUlozisteDataFacade extends AbstractFacade<VazbaOsobyUlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaOsobyUlozisteDataFacade() {
        super(VazbaOsobyUlozisteData.class);
    }
    
    public List findVazbyOsobyUlozisteData(Osoby os, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v "
                + "FROM VazbaOsobyUlozisteData v "
                + "WHERE v.vazbaOsobyUlozisteDataPK.vazbaOsobyUlozisteDataOsobaId = :vazbaOsobyUlozisteDataOsobaId";
        return em.createQuery(dotaz, VazbaOsobyUlozisteData.class).
                setParameter("vazbaOsobyUlozisteDataOsobaId", os.getOsobaId())
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public Long findPocetVazbyOsobyUlozisteData(Osoby os) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaOsobyUlozisteData v "
                + "WHERE v.vazbaOsobyUlozisteDataPK.vazbaOsobyUlozisteDataOsobaId = :vazbaOsobyUlozisteDataOsobaId";
        return em.createQuery(dotaz, Long.class).
                setParameter("vazbaOsobyUlozisteDataOsobaId", os.getOsobaId()).getSingleResult();
    }
    
    public VazbaOsobyUlozisteData findByUloziste(int ulozisteId) {
        return (VazbaOsobyUlozisteData) em.createNamedQuery("VazbaOsobyUlozisteData.findByVazbaOsobyUlozisteDataDataUlozisteId")
                .setParameter("vazbaOsobyUlozisteDataDataUlozisteId", ulozisteId).getSingleResult();
    }
    
}
