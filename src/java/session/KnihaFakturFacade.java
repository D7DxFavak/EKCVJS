/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.KnihaFaktur;
import entity.Organizace;
import entity.Osoby;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class KnihaFakturFacade extends AbstractFacade<KnihaFaktur> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KnihaFakturFacade() {
        super(KnihaFaktur.class);
    }

    public List<KnihaFaktur> findByFiltr(Organizace orgIn, String raditPodle, int pocetStrana, int prvniPozice) {       
        String dotaz = "SELECT k "
                + "FROM KnihaFaktur k "
                + "WHERE k.objednavatelOrg = :objednavatelOrg "
                + "OR k.platceOrg = :platceOrg "
                + "ORDER BY k." + raditPodle;
        return em.createQuery(dotaz, KnihaFaktur.class).
                setParameter("objednavatelOrg", orgIn).setParameter("platceOrg", orgIn)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public List<KnihaFaktur> findByFiltr(Osoby osIn, String raditPodle, int pocetStrana, int prvniPozice) {       
        String dotaz = "SELECT k "
                + "FROM KnihaFaktur k "
                + "WHERE k.objednavatelOs = :objednavatelOs "
                + "OR k.platceOs = :platceOs "
                + "ORDER BY k." + raditPodle;
        return em.createQuery(dotaz, KnihaFaktur.class).
                setParameter("objednavatelOs", osIn).setParameter("platceOs", osIn)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public Long findPocetByFiltr(Organizace orgIn) {       
        String dotaz = "SELECT COUNT(k) "
                + "FROM KnihaFaktur k "
                + "WHERE k.objednavatelOrg = :objednavatelOrg "
                + "OR k.platceOrg = :platceOrg ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOrg", orgIn).setParameter("platceOrg", orgIn)
                .getSingleResult();
    }
    
    public Long findPocetByFiltr(Osoby osIn) {       
        String dotaz = "SELECT COUNT(k) "
                + "FROM KnihaFaktur k "
                + "WHERE k.objednavatelOs = :objednavatelOs "
                + "OR k.platceOs = :platceOs ";
        return em.createQuery(dotaz, Long.class).
                setParameter("objednavatelOs", osIn).setParameter("platceOs", osIn)
                .getSingleResult();
    }
    
    public KnihaFaktur findById(int id) {
        return em.createNamedQuery("KnihaFaktur.findByCisloFaktury", KnihaFaktur.class).setParameter("cisloFaktury", id).getSingleResult();
    }
    
    public List<KnihaFaktur> findByDate(Date datumVystaveni, String raditPodle, int pocetStrana, int prvniPozice) {
        return em.createNamedQuery("KnihaFaktur.findByDatumVystaveni", KnihaFaktur.class).setParameter("datumVystaveni", datumVystaveni)
                .setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
}
