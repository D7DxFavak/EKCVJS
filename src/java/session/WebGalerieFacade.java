/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebGalerie;
import entity.WebKategorieZakladni;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class WebGalerieFacade extends AbstractFacade<WebGalerie> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WebGalerieFacade() {
        super(WebGalerie.class);
    }

    public List findByKategorie(WebKategorieZakladni wkz, int pocetStrana, int prvniPozice) {
        return em.createNamedQuery("WebGalerie.findByWebGalerieKategorie", WebGalerie.class).setParameter("webGalerieKategorie", wkz).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }

    public List findAll(int pocetStrana, int prvniPozice) {
        return em.createNamedQuery("WebGalerie.findAll", WebGalerie.class).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }

    public Long findPocetAll() {
        String dotaz = "SELECT COUNT(w) FROM WebGalerie w ";
        return em.createQuery(dotaz, Long.class).getSingleResult();
    }

    public Long findPocetByKategorie(WebKategorieZakladni wkz) {
        String dotaz = "SELECT COUNT(w) "
                + "FROM WebGalerie w WHERE w.webGalerieKategorie = :webGalerieKategorie";
        return em.createQuery(dotaz, Long.class).setParameter("webGalerieKategorie", wkz).getSingleResult();
    }

    public WebGalerie findById(int idGalerie) {
        return em.createNamedQuery("WebGalerie.findByWebGalerieId", WebGalerie.class).setParameter("webGalerieId", idGalerie).getSingleResult();
    }
}
