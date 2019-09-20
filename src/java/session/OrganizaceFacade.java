/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class OrganizaceFacade extends AbstractFacade<Organizace> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganizaceFacade() {
        super(Organizace.class);
    }

    public Organizace findPodleId(int loginId) {
        return em.createNamedQuery("Organizace.findByOrganizaceId", Organizace.class).setParameter("organizaceId", loginId).getSingleResult();

    }

    public Organizace findPodleIco(String ico) {
        try {
            return em.createNamedQuery("Organizace.findByIco", Organizace.class).setParameter("ico", ico).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public Organizace findPodleEmail(String email) {
        try {
            return em.createNamedQuery("Organizace.findByEMail", Organizace.class).setParameter("eMail", "%" + email + "%").getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Organizace updateOrganizace(Organizace o) {

        em.merge(o);
        // em.getTransaction().commit();
        return o;
    }

    public Organizace registerOrganizace(Organizace o) {
        o.setOrganizaceId(findPodleMaxId().getOrganizaceId() + 1);
        em.persist(o);
        return o;
    }

    public Organizace findPodleMaxId() {
        return em.createNamedQuery("Organizace.findByMaxId", Organizace.class).setMaxResults(1).getSingleResult();

    }
}
