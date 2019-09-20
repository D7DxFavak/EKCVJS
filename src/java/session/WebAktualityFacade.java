/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entity.WebAktuality;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebAktualityFacade extends AbstractFacade<WebAktuality> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebAktualityFacade() {
        super(WebAktuality.class);
    }
    
    public List findSouhrn() {        
        return em.createNamedQuery("WebAktuality.findSouhrn", WebAktuality.class).setMaxResults(3).getResultList();
    }
    
    public WebAktuality findById(int id) {        
        return em.createNamedQuery("WebAktuality.findByWebAktualityId", WebAktuality.class).setParameter("webAktualityId", id).getSingleResult();
    }
    
    public List findByKategorie(int idKategorie, int pocetStrana, int prvniPozice) { 
        if(idKategorie == 10 ) {
             return em.createNamedQuery("WebAktuality.findAll", WebAktuality.class)
                .setMaxResults(pocetStrana)
                .setFirstResult(prvniPozice).getResultList();
        } else {
             return em.createNamedQuery("WebAktuality.findByWebAktualityKategorie", WebAktuality.class)
                .setParameter("webAktualityKategorie", idKategorie).setMaxResults(pocetStrana)
                .setFirstResult(prvniPozice*pocetStrana).getResultList();
        }
       
    }
    
    public List<WebAktuality> findByVyraz(String vyraz) {
         List<WebAktuality> waOut = new ArrayList<WebAktuality>();
         
        waOut.addAll(em.createQuery("SELECT w FROM WebAktuality w WHERE (lower(w.webAktualityNazev) LIKE :vyraz) "
                + "OR (lower(w.webAktualityPopis) LIKE :vyraz) OR (lower(w.webAktualityDetailyPoznamky) LIKE :vyraz)" ).
                setParameter("vyraz", "%" + vyraz + "%").getResultList());
       // wpdOut.get(0).getWebPanelyDataPanel().getWebPanelyZalozka()
        return waOut;
    }
    
}
