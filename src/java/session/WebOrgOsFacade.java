/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import entity.Osoby;
import entity.WebOrgOs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebOrgOsFacade extends AbstractFacade<WebOrgOs> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebOrgOsFacade() {
        super(WebOrgOs.class);
    }

    public List findByOrganizace(int id) {
        return em.createNamedQuery("WebOrgOs.findByWebOrgOsOrganizace", WebOrgOs.class).setParameter("webOrgOsOrganizace", id).getResultList();
    }
    
    public List findByOrganizace(int id, int pocetStrana, int prvniPozice) {
        return em.createNamedQuery("WebOrgOs.findByWebOrgOsOrganizace", WebOrgOs.class).setParameter("webOrgOsOrganizace", id).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
    }
    
    public List findByOsoba(int id) {
        return em.createNamedQuery("WebOrgOs.findByWebOrgOsOsoba", WebOrgOs.class).setParameter("webOrgOsOsoba", id).getResultList();
    }
    
    public WebOrgOs pridatZamestnanec(Organizace org, Osoby os) {
        WebOrgOs nova = new WebOrgOs(os.getOsobaId(), org.getOrganizaceId() );
        nova.setWebOrgOsOsoba(os);
        nova.setWebOrgOsOrganizace(org);
        nova.setWebOrgOsAktivni(true);
        em.persist(nova);
        
        return nova;
    }
    
    public void odebratZamestnanec(Organizace org, Osoby os) {
        WebOrgOs nova = new WebOrgOs(os.getOsobaId(), org.getOrganizaceId() );
        nova.setWebOrgOsOsoba(os);
        nova.setWebOrgOsOrganizace(org);
        nova.setWebOrgOsAktivni(true);        
        em.remove(em.merge(nova));
                
    }
}
