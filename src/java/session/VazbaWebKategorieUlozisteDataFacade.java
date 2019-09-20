/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.UlozisteDataDruhy;
import entity.VazbaWebKategorieUlozisteData;
import entity.WebKategorieZakladni;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sprava.ZobrazeniTabulek;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaWebKategorieUlozisteDataFacade extends AbstractFacade<VazbaWebKategorieUlozisteData> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaWebKategorieUlozisteDataFacade() {
        super(VazbaWebKategorieUlozisteData.class);
    }
    
    public List findVazbyWebKategorieUlozisteData(WebKategorieZakladni wkz, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT v FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId "
                + "ORDER BY v.ulozisteData.ulozisteDataVlozeno DESC";
        return em.createQuery(dotaz, VazbaWebKategorieUlozisteData.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId())
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public List findVazbyWebKategorieUlozisteData(WebKategorieZakladni wkz, ZobrazeniTabulek zt) {
        String raditpodle = "";
        if(zt.getSort() == 0) {
            raditpodle = "v.ulozisteData.ulozisteDataPopis" + zt.getSortTyp();
        } else if (zt.getSort() == 1) {
             raditpodle = "v.ulozisteData.ulozisteDataVlozeno" + zt.getSortTyp();
        } else {
            raditpodle = "v.ulozisteData.ulozisteDataVlozeno DESC";
        }
        String dotaz = "SELECT v FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId "
                + "ORDER BY "+ raditpodle;
        return em.createQuery(dotaz, VazbaWebKategorieUlozisteData.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId())
                .setMaxResults(zt.getPocetStrana()).setFirstResult(zt.getOffset() * zt.getPocetStrana()).getResultList();
    }
    
    public List findVazbyWebKategorieUlozisteData(WebKategorieZakladni wkz, ZobrazeniTabulek zt, UlozisteDataDruhy udd) {
        String raditpodle = "";
        if(zt.getSort() == 0) {
            raditpodle = "v.ulozisteData.ulozisteDataPopis" + zt.getSortTyp();
        } else if (zt.getSort() == 1) {
             raditpodle = "v.ulozisteData.ulozisteDataVlozeno" + zt.getSortTyp();
        } else {
            raditpodle = "v.ulozisteData.ulozisteDataVlozeno DESC";
        }
        String dotaz = "SELECT v FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId "
                + "AND v.ulozisteData.ulozisteDataDruhId = :udd "
                + "ORDER BY "+ raditpodle;
        return em.createQuery(dotaz, VazbaWebKategorieUlozisteData.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId()).
                setParameter("udd", udd)
                .setMaxResults(zt.getPocetStrana()).setFirstResult(zt.getOffset() * zt.getPocetStrana()).getResultList();
    }
    
    public List findVazbyWebKategorieUlozisteDataz(WebKategorieZakladni wkz, ZobrazeniTabulek zt) {
        String raditpodle = "";
        if(zt.getSort() == 0) {
            raditpodle = "v.ulozisteData.ulozisteDataPopis" + zt.getSortTyp();
        } else if (zt.getSort() == 1) {
             raditpodle = "v.ulozisteData.ulozisteDataVlozeno" + zt.getSortTyp();
        } else {
            raditpodle = "v.ulozisteData.ulozisteDataVlozeno DESC";
        }
        String dotaz = "SELECT v FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId "
                + "ORDER BY "+ raditpodle;
        return em.createQuery(dotaz, VazbaWebKategorieUlozisteData.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId())
                .setMaxResults(zt.getPocetStrana()).setFirstResult(zt.getOffset() * zt.getPocetStrana()).getResultList();
    }
    
    
    public long findPocetByWebKategorieUlozisteData(WebKategorieZakladni wkz) {
         String dotaz = "SELECT COUNT (v) FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId ";
          return em.createQuery(dotaz, Long.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId()).getSingleResult();
    }
    //TODO asi zbytecny, prilezitostne smazat
     public long findPocetByWebKategorieUlozisteDataByDruh(WebKategorieZakladni wkz, int idDruhUloziste) {
         String dotaz = "SELECT COUNT (v) FROM VazbaWebKategorieUlozisteData v, "
                 + "UlozisteData u "
                + "WHERE v.ulozisteData.ulozisteDataId = u.ulozisteDataId "
                 + "AND u.ulozisteDataDruhId.ulozisteDataDruhyId =: ulozisteDataDruhyId "
                 + "AND v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId =: vazbaWebKategorieUlozisteDataWebKategorieId ";
          return em.createQuery(dotaz, Long.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId())
                  .setParameter("ulozisteDataDruhyId", idDruhUloziste).getSingleResult();
    }
     
     public long findPocetByWebKategorieUlozisteDataByDruh(int idKategorieZakladni, UlozisteDataDruhy druhUloziste) {         
         String dotaz = "SELECT COUNT (u) FROM UlozisteData u " +
                 "WHERE u.ulozisteDataDruhId =: ulozisteDataDruhyId";               
          return em.createQuery(dotaz, Long.class).setParameter("ulozisteDataDruhyId", druhUloziste).getSingleResult();
    }
    
      public long findPocetByWebKategorieUlozisteDataOstatni(WebKategorieZakladni wkz) {
         String dotaz = "SELECT COUNT (v) FROM VazbaWebKategorieUlozisteData v "
                + "WHERE v.vazbaWebKategorieUlozisteDataPK.vazbaWebKategorieUlozisteDataWebKategorieId = :vazbaWebKategorieUlozisteDataWebKategorieId ";
          return em.createQuery(dotaz, Long.class).
                setParameter("vazbaWebKategorieUlozisteDataWebKategorieId", wkz.getWebKategorieZakladniId()).getSingleResult();
    }
    
    public VazbaWebKategorieUlozisteData findByUloziste(int ulozisteId) {
        em.clear();
        return (VazbaWebKategorieUlozisteData) em.createNamedQuery("VazbaWebKategorieUlozisteData.findByVazbaWebKategorieUlozisteDataDataUlozisteId")
                .setParameter("vazbaWebKategorieUlozisteDataDataUlozisteId", ulozisteId).getSingleResult();
    }
    
}
