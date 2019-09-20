/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Obdobi;
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
public class ObdobiFacade extends AbstractFacade<Obdobi> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ObdobiFacade() {
        super(Obdobi.class);
    }

    public List<Obdobi> findWeb() {
        List obdobiOut = new ArrayList();
        Obdobi nulovyObdobi = new Obdobi();
        nulovyObdobi.setObdobiId(0);
        nulovyObdobi.setNazev("Neurčené");        
        obdobiOut.add(nulovyObdobi);
        obdobiOut.addAll(em.createNamedQuery("Obdobi.findWeb", Obdobi.class).setParameter("obdobiNaWeb", true).getResultList());
        return obdobiOut;
    }
}
