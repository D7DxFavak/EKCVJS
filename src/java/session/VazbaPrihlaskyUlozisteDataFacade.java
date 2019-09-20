/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import entity.Osoby;
import entity.PrihlaskyRozpisy;
import entity.VazbaPrihlaskyUlozisteData;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class VazbaPrihlaskyUlozisteDataFacade extends AbstractFacade<VazbaPrihlaskyUlozisteData> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaPrihlaskyUlozisteDataFacade() {
        super(VazbaPrihlaskyUlozisteData.class);
    }

    public VazbaPrihlaskyUlozisteData findByPrihlasky(PrihlaskyRozpisy prihlaska) {
        return (VazbaPrihlaskyUlozisteData) em.createNamedQuery("VazbaPrihlaskyUlozisteData.findByVazbaPrihlaskyUlozisteDataPrihlaskyId").setParameter("vazbaPrihlaskyUlozisteDataPrihlaskyId", prihlaska).getSingleResult();
    }

    public VazbaPrihlaskyUlozisteData findByPrihlasky(int polozka) {
        return (VazbaPrihlaskyUlozisteData) em.createNamedQuery("VazbaPrihlaskyUlozisteData.findByVazbaPrihlaskyUlozisteDataPrihlaskyId").setParameter("vazbaPrihlaskyUlozisteDataPrihlaskyId", polozka).getSingleResult();
    }

    public List findByOrganizace(Organizace org, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v "
                + "FROM VazbaPrihlaskyUlozisteData v, PrihlaskyRozpisy p "
                + "WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = p.polozka "
                + "AND p.objednavatelOrg = :organizace "
                + "ORDER BY v.ulozisteData.ulozisteDataVlozeno DESC";                

        return em.createQuery(dotaz, VazbaPrihlaskyUlozisteData.class).setParameter("organizace", org)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
     public List findByTEST(Organizace org, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v "
                + "FROM VazbaPrihlaskyUlozisteData v, PrihlaskyRozpisy p "
                + "WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = 135757 "                
                + "ORDER BY v.ulozisteData.ulozisteDataVlozeno DESC";                

        return em.createQuery(dotaz, VazbaPrihlaskyUlozisteData.class)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public List findByOsoba(Osoby os, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v "
                + "FROM VazbaPrihlaskyUlozisteData v, PrihlaskyRozpisy p "
                + "WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = p.polozka "
                + "AND p.osoba = :osoba "
                + "ORDER BY v.ulozisteData.ulozisteDataVlozeno DESC";                

        return em.createQuery(dotaz, VazbaPrihlaskyUlozisteData.class).setParameter("osoba", os)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public Long findPocetByFiltr(Osoby os) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaPrihlaskyUlozisteData v, PrihlaskyRozpisy p "
                + "WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = p.polozka "
                + "AND p.osoba = :osoba ";                

        return em.createQuery(dotaz, Long.class).setParameter("osoba", os).getSingleResult();
    }
    
     public Long findPocetByFiltr(Organizace org) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaPrihlaskyUlozisteData v, PrihlaskyRozpisy p "
                + "WHERE v.vazbaPrihlaskyUlozisteDataPK.vazbaPrihlaskyUlozisteDataPrihlaskyId = p.polozka "
                + "AND p.objednavatelOrg = :organizace ";                

        return em.createQuery(dotaz, Long.class).setParameter("organizace", org).getSingleResult();
    }
}
