/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Osoby;
import entity.WebKontaktyFoto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebKontaktyFotoFacade extends AbstractFacade<WebKontaktyFoto> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebKontaktyFotoFacade() {
        super(WebKontaktyFoto.class);
    }

    public WebKontaktyFoto findByOsoba(Osoby osobaFoto) {
        try {
            return em.createNamedQuery("WebKontaktyFoto.findByWebKontaktyFotoOsoba", WebKontaktyFoto.class).setParameter("webKontaktyFotoOsoba", osobaFoto).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
