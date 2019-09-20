/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OsobyDalsiKontakty;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class OsobyDalsiKontaktyFacade extends AbstractFacade<OsobyDalsiKontakty> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OsobyDalsiKontaktyFacade() {
        super(OsobyDalsiKontakty.class);
    }

    public OsobyDalsiKontakty registerOsoby(OsobyDalsiKontakty o) {       

        try {
            o.setPoradi(findPodleMaxId().getPoradi() + 1);
            em.persist(o);           
            return o;
        } catch (NoResultException e) {
            o.setPoradi(1);
            em.persist(o);           
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public OsobyDalsiKontakty findPodleMaxId() {
        return em.createNamedQuery("OsobyDalsiKontakty.findByMaxId", OsobyDalsiKontakty.class).setMaxResults(1).getSingleResult();

    }
}
