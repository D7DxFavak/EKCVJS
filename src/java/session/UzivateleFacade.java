/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import entity.Osoby;
import entity.Uzivatele;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class UzivateleFacade extends AbstractFacade<Uzivatele> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UzivateleFacade() {
        super(Uzivatele.class);
    }

    public Uzivatele findPodleJmena(String login) {
        return em.createNamedQuery("Uzivatele.findByUzivateleJmeno", Uzivatele.class).setParameter("uzivateleJmeno", login).getSingleResult();

    }

    public Uzivatele findPodleOsoby(Osoby idOsoba) {
        try {
            return em.createNamedQuery("Uzivatele.findByUzivateleOsobyId", Uzivatele.class).setParameter("uzivateleOsobyId", idOsoba).getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Uzivatele findPodleOrganizace(Organizace idOrganizace) {
        try {
            return em.createNamedQuery("Uzivatele.findByUzivateleOrganizaceId", Uzivatele.class).setParameter("uzivateleOrganizaceId", idOrganizace).getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    public Uzivatele registerUser(String usr, String pwd) {
        Uzivatele u = em.find(Uzivatele.class, usr);
        if (u != null) {
            return null;
        }
        try {
            String sha256pwd = org.apache.commons.codec.digest.DigestUtils.sha256Hex(pwd);

            u = new Uzivatele(usr, sha256pwd);
            em.persist(u);
            return u;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Uzivatele updateUser(Uzivatele u) {
        if (em.find(Uzivatele.class, u.getUzivateleJmeno()) != null) {
            em.merge(u);
            em.flush();
        }
        return u;
    }

    public void removeUser(Uzivatele u) {
        if (em.find(Uzivatele.class, u.getUzivateleJmeno()) != null) {
            em.remove(u);
        }
    }

    public String generovatHeslo(Uzivatele u) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(AB.charAt((int) (AB.length() * Math.random())));
        }
        String sha256pwd = org.apache.commons.codec.digest.DigestUtils.sha256Hex(sb.toString());
        u.setUzivateleHeslo(sha256pwd);
        em.merge(u);
        em.flush();

        return sb.toString();
    }
}
