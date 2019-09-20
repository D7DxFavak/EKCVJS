/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import entity.VazbaOrganizaceUlozisteData;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaOrganizaceUlozisteDataFacade extends AbstractFacade<VazbaOrganizaceUlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaOrganizaceUlozisteDataFacade() {
        super(VazbaOrganizaceUlozisteData.class);
    }
    
    public List findVazbyOrganizaceUlozisteData(Organizace org, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v "
                + "FROM VazbaOrganizaceUlozisteData v "
                + "WHERE v.vazbaOrganizaceUlozisteDataPK.vazbaOrganizaceUlozisteDataOrganizaceId = :vazbaOrganizaceUlozisteDataOrganizaceId";
        return em.createQuery(dotaz, VazbaOrganizaceUlozisteData.class).
                setParameter("vazbaOrganizaceUlozisteDataOrganizaceId", org.getOrganizaceId())
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public Long findPocetVazbyOrganizaceUlozisteData(Organizace org) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaOrganizaceUlozisteData v "
                + "WHERE v.vazbaOrganizaceUlozisteDataPK.vazbaOrganizaceUlozisteDataOrganizaceId = :vazbaOrganizaceUlozisteDataOrganizaceId";
        return em.createQuery(dotaz, Long.class).
                setParameter("vazbaOrganizaceUlozisteDataOrganizaceId", org.getOrganizaceId()).getSingleResult();
    }
    
    public VazbaOrganizaceUlozisteData findByUloziste(int ulozisteId) {
        return (VazbaOrganizaceUlozisteData) em.createNamedQuery("VazbaOrganizaceUlozisteData.findByVazbaOrganizaceUlozisteDataDataUlozisteId")
                .setParameter("vazbaOrganizaceUlozisteDataDataUlozisteId", ulozisteId).getSingleResult();
    }
    
   
    
}
