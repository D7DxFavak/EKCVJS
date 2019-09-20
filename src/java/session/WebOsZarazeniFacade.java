/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WebOsOblzarJemne;
import entity.WebOsZarazeni;
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
public class WebOsZarazeniFacade extends AbstractFacade<WebOsZarazeni> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebOsZarazeniFacade() {
        super(WebOsZarazeni.class);
    }
    
    public List findByJemnaZarazeni(ArrayList<WebOsOblzarJemne> osOzJemnes) {
        List out = new ArrayList();
        List pom;
        for(int i =0; i < osOzJemnes.size(); i++) {
            pom = em.createNamedQuery("WebOsZarazeni.findByWebOsZarazeniOblzarJemna", WebOsZarazeni.class)
                .setParameter("webOsZarazeniOblzarJemna", osOzJemnes.get(i)).getResultList();
            for(int j = 0; j <pom.size(); j++) {
                out.add(pom.get(j));
            }
        }
        return out;
        
    }        
    
    public List<WebOsZarazeni> findByOsobaKontakty(String vyraz) {
         List<WebOsZarazeni> wpdOut = new ArrayList<WebOsZarazeni>();
         
        wpdOut.addAll(em.createQuery("SELECT w FROM WebOsZarazeni w WHERE (lower(w.webOsZarazeniOsoba.jmeno) LIKE :vyraz) OR (lower(w.webOsZarazeniOsoba.prijmeni) LIKE :vyraz) "
                + "OR (lower(w.webOsZarazeniOsoba.telefon) LIKE :vyraz) OR (lower(w.webOsZarazeniOsoba.telefon2) LIKE :vyraz) OR (lower(w.webOsZarazeniOsoba.telefon3) LIKE :vyraz) "
                + "OR (lower(w.webOsZarazeniOsoba.eMail) LIKE :vyraz) OR (lower(w.webOsZarazeniOsoba.eMail2) LIKE :vyraz) OR (lower(w.webOsZarazeniOsoba.eMail3) LIKE :vyraz) "
                + "OR (lower(w.webOsZarazeniPozice.webOsPoziceNazev) LIKE :vyraz) OR (lower(w.webOsZarazeniPozice.webOsPoziceNazev) LIKE :vyraz) OR (lower(w.webOsZarazeniPozice.webOsPoziceNazevEn) LIKE :vyraz) "
                + "OR (lower(w.webOsZarazeniPozice.webOsPoziceNazevDe) LIKE :vyraz) OR (lower(w.webOsZarazeniOblzarJemna.webNazev) LIKE :vyraz) "
                + "OR (lower(w.webOsZarazeniOblzarJemna.webNazevEn) LIKE :vyraz) OR (lower(w.webOsZarazeniOblzarJemna.webNazevDe) LIKE :vyraz)" ).
                setParameter("vyraz", "%" + vyraz + "%").getResultList());
       // wpdOut.get(0).getWebPanelyDataPanel().getWebPanelyZalozka()
        return wpdOut;
    }
    
}
