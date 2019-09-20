/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AkceHlavni;
import entity.Organizace;
import entity.Osoby;
import entity.PrihlaskyRozpisyJs;
import entity.StavyPrihlasek;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class PrihlaskyRozpisyJsFacade extends AbstractFacade<PrihlaskyRozpisyJs> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrihlaskyRozpisyJsFacade() {
        super(PrihlaskyRozpisyJs.class);
    }
    
    public PrihlaskyRozpisyJs findByOsoba(Osoby customer) {
        return (PrihlaskyRozpisyJs) em.createNamedQuery("PrihlaskyRozpisyJs.findByOsoba").setParameter("osoba", customer).getSingleResult();
    }

    public List<PrihlaskyRozpisyJs> findByOsobaMulti(Osoby customer) {
        return em.createNamedQuery("PrihlaskyRozpisyJs.findByOsoba").setParameter("osoba", customer).getResultList();
    }

    public List<PrihlaskyRozpisyJs> findByOsobaMultiAktivni(Osoby customer) {
        return em.createNamedQuery("PrihlaskyRozpisyJs.findByOsobaAktivni").setParameter("osoba", customer).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).getResultList();
    }

    public List<Osoby> findDistinctByObjednavatel(Organizace objednavatel) {
        return em.createNamedQuery("PrihlaskyRozpisyJs.findDistinctByObjednavatel", Osoby.class).setParameter("objednavatelOrg", objednavatel).getResultList();
    }

    public List<AkceHlavni> findByOsobaMultiAktivni(Osoby customer, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT p.akce FROM PrihlaskyRozpisyJs p "
                + "WHERE p.osoba = :osoba "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "ORDER BY p.akce." + raditPodle;

        return em.createQuery(dotaz, AkceHlavni.class).setParameter("osoba", customer).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).setMaxResults(pocetStrana).setFirstResult(prvniPozice).getResultList();
    }
    
    public List<PrihlaskyRozpisyJs> findByOsobaMultiAktivniPrihlaska(Osoby customer, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT p FROM PrihlaskyRozpisyJs p "
                + "WHERE p.osoba = :osoba "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "ORDER BY p.akce." + raditPodle;

        return em.createQuery(dotaz, PrihlaskyRozpisyJs.class).setParameter("osoba", customer).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).setMaxResults(pocetStrana).setFirstResult(prvniPozice).getResultList();
    }

    public List<AkceHlavni> findByOrganizaceMultiAktivni(Organizace oop, String raditPodle, int pocetStrana, int prvniPozice) {


        String dotaz = "SELECT DISTINCT p.akce FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "ORDER BY p.akce." + raditPodle;
        return em.createQuery(dotaz, AkceHlavni.class).setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public List<AkceHlavni> findByOrganizaceMultiSkoncena(Organizace oop, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT DISTINCT p.akce FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "ORDER BY p.akce." + raditPodle;
        return em.createQuery(dotaz, AkceHlavni.class).setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }

    public List<Osoby> findByOrganizaceAkceAktivni(Organizace oop, AkceHlavni akce) {
        String dotaz = "SELECT p.osoba FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "AND p.akce = :akce";
        return em.createQuery(dotaz, Osoby.class).setParameter("objednavatelOrg", oop).setParameter("akce", akce).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).getResultList();
    }
    
    public List<Osoby> findByOrganizaceAkceSkoncena(Organizace oop, AkceHlavni akce) {
        String dotaz = "SELECT p.osoba FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "AND p.akce = :akce";
        return em.createQuery(dotaz, Osoby.class).setParameter("objednavatelOrg", oop).setParameter("akce", akce).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).getResultList();
    }

    public Long findPocetAkceByOrganizaceMultiAktivni(Organizace oop) {
        String dotaz = "SELECT COUNT(DISTINCT p.akce) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).getSingleResult();

    }
    
     public Long findPocetByOrganizaceMultiAktivni(Organizace oop) {
        String dotaz = "SELECT COUNT(p) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).getSingleResult();

    }
    
    public Long findPocetByOsobaMultiAktivni(Osoby oop) {
        String dotaz = "SELECT COUNT(p) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.osoba = :osoba "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("osoba", oop).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(10)).getSingleResult();

    }

    public Long findPocetAkceByOrganizaceMultiSkoncena(Organizace oop) {
        String dotaz = "SELECT COUNT(DISTINCT p.akce) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).getSingleResult();
    }
    
    public Long findPocetByOrganizaceMultiSkoncena(Organizace oop) {
        String dotaz = "SELECT COUNT(p) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.objednavatelOrg = :objednavatelOrg "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOrg", oop).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).getSingleResult();
    }
    
    public Long findPocetByOsobaMultiSkoncena(Osoby oop) {
        String dotaz = "SELECT COUNT(p) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.osoba = :osoba "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) ";
        return em.createQuery(dotaz, Long.class).
                setParameter("osoba", oop).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).getSingleResult();
    }

    public List<PrihlaskyRozpisyJs> findByOsobaMultiSkoncenaPrihlaska(Osoby customer, String raditPodle, int pocetStrana, int prvniPozice) {
        String dotaz = "SELECT p FROM PrihlaskyRozpisyJs p "
                + "WHERE p.osoba = :osoba "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2) "
                + "ORDER BY p.akce." + raditPodle;

        return em.createQuery(dotaz, PrihlaskyRozpisyJs.class).setParameter("osoba", customer).setParameter("stav1", new StavyPrihlasek(2)).setParameter("stav2", new StavyPrihlasek(3)).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }

    public PrihlaskyRozpisyJs findPodleMaxId() {
        return em.createNamedQuery("PrihlaskyRozpisyJs.findByMaxId", PrihlaskyRozpisyJs.class).setMaxResults(1).getSingleResult();
    }

    public long findPocetByFiltr(AkceHlavni ah) {

        String dotaz = "SELECT COUNT(p) FROM PrihlaskyRozpisyJs p "
                + "WHERE p.akce = :akce "
                + "AND (p.stavprihl = :stav1 "
                + "OR p.stavprihl = :stav2 "
                + "OR p.stavprihl = :stav4 "
                + "OR p.stavprihl = :stav8 "
                + "OR p.stavprihl = :stav9 "
                + "OR p.stavprihl = :stav10)";
        return em.createQuery(dotaz, Long.class).
                setParameter("akce", ah).setParameter("stav1", new StavyPrihlasek(1)).setParameter("stav2", new StavyPrihlasek(2)).setParameter("stav4", new StavyPrihlasek(4)).setParameter("stav8", new StavyPrihlasek(8)).setParameter("stav9", new StavyPrihlasek(9)).setParameter("stav10", new StavyPrihlasek(10)).getSingleResult();
    }

    public PrihlaskyRozpisyJs prihlasit(PrihlaskyRozpisyJs p) {
        p.setPolozka(findPodleMaxId().getPolozka() + 1);
        em.persist(p);
        return p;
    }
    
}
