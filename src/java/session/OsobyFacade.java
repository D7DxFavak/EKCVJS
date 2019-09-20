/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Osoby;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class OsobyFacade extends AbstractFacade<Osoby> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OsobyFacade() {
        super(Osoby.class);
    }

    public Osoby findPodleId(int loginId) {
        try {
            return em.createNamedQuery("Osoby.findByOsobaId", Osoby.class).setParameter("osobaId", loginId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public Osoby findPodleMaxId() {
        return em.createNamedQuery("Osoby.findByMaxId", Osoby.class).setMaxResults(1).getSingleResult();

    }

    public Osoby findPodleRodneCislo(String rodneCislo) {
        try {
            return em.createNamedQuery("Osoby.findByRodneCislo", Osoby.class).setParameter("rodneCislo", rodneCislo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Osoby findPodleEmail(String email) {
        try {
            return em.createNamedQuery("Osoby.findByEMail", Osoby.class).setParameter("eMail", "%" + email + "%").getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public int findPocetPodleEmail(String email) {
        try {
            return em.createNamedQuery("Osoby.findByEMail", Osoby.class).setParameter("eMail", "%" + email + "%").getResultList().size();
        } catch (NoResultException e) {
            return 0;
        }
    }
    

    public Osoby registerOsoby(Osoby o) {        
        Osoby orc = null;
        try {
            orc = em.createNamedQuery("Osoby.findByRodneCislo", Osoby.class).setParameter("rodneCislo", o.getRodneCislo()).getSingleResult();
        } catch (NoResultException e) {
            orc = null;
        }
        try {
            if (orc != null) {
                
                return orc;
            } else {
                if (o.getGdprZpusob() == 0) {
                    o.setGdprZpusob(50);
                    o.setGdprUdeleno(false);
                }
                o.setOsobaId(findPodleMaxId().getOsobaId() + 1);
                em.persist(o);
                
                return o;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void updateOsoby(Osoby o) {
        
        if (em.find(Osoby.class, o.getOsobaId()) != null) {            
            em.merge(o);
            em.flush();
        }

    }
}
