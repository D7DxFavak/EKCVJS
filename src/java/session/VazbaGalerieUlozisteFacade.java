/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.VazbaGalerieUloziste;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaGalerieUlozisteFacade extends AbstractFacade<VazbaGalerieUloziste> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaGalerieUlozisteFacade() {
        super(VazbaGalerieUloziste.class);
    }

    public VazbaGalerieUloziste findUvodniByGalerie(int galerie) {
        return em.createQuery("SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePK.vazbaGalerieUlozisteGalerie = :vazbaGalerieUlozisteGalerie "
                + "AND v.vazbaGalerieUlozisteUvodni = TRUE", VazbaGalerieUloziste.class).setParameter("vazbaGalerieUlozisteGalerie", galerie).getSingleResult();
    }
    
    public List findByGalerie(int galerie, int pocetFoto, int prvniFoto) {
        return em.createQuery("SELECT v FROM VazbaGalerieUloziste v WHERE v.vazbaGalerieUlozistePK.vazbaGalerieUlozisteGalerie = :vazbaGalerieUlozisteGalerie "
                + "ORDER BY v.vazbaGalerieUlozistePoradiVyber ASC", VazbaGalerieUloziste.class).setParameter("vazbaGalerieUlozisteGalerie", galerie)
                .setMaxResults(pocetFoto).setFirstResult(prvniFoto).getResultList();
    }
    
    
    public Long findPocetByGalerie(int galerie) {
        String dotaz = "SELECT COUNT(v) "
                + "FROM VazbaGalerieUloziste v "
                + "WHERE v.vazbaGalerieUlozistePK.vazbaGalerieUlozisteGalerie = :vazbaGalerieUlozisteGalerie ";
        return em.createQuery(dotaz, Long.class).setParameter("vazbaGalerieUlozisteGalerie", galerie).getSingleResult();
    }
}

