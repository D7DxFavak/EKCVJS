/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Organizace;
import entity.Osoby;
import entity.WebOrgOsPending;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class WebOrgOsPendingFacade extends AbstractFacade<WebOrgOsPending> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WebOrgOsPendingFacade() {
        super(WebOrgOsPending.class);
    }

    public List findByOrganizace(int id) {
        return em.createNamedQuery("WebOrgOsPending.findByWebOrgOsPendingOrganizace", WebOrgOsPending.class).setParameter("webOrgOsPendingOrganizace", id).getResultList();
    }
    
    public List findByOsoba(int id) {
        return em.createNamedQuery("WebOrgOsPending.findByWebOrgOsPendingOsoba", WebOrgOsPending.class).setParameter("webOrgOsPendingOsoba", id).getResultList();
    }
    
    public WebOrgOsPending pridatZamestnanec(Organizace org, Osoby os) {
        WebOrgOsPending nova = new WebOrgOsPending(os.getOsobaId(), org.getOrganizaceId() );
        nova.setWebOrgOsOsoba(os);
        nova.setWebOrgOsOrganizace(org);
        nova.setWebOrgOsAktivni(true);
        em.persist(nova);
        
        return nova;
    }
    
    public void odebratZamestnanec(Organizace org, Osoby os) {
        WebOrgOsPending nova = new WebOrgOsPending(os.getOsobaId(), org.getOrganizaceId() );
        nova.setWebOrgOsOsoba(os);
        nova.setWebOrgOsOrganizace(org);
        nova.setWebOrgOsAktivni(true);        
        em.remove(em.merge(nova));
                
    }
}
