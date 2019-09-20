/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.OborySkupiny;
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
public class OborySkupinyFacade extends AbstractFacade<OborySkupiny> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OborySkupinyFacade() {
        super(OborySkupiny.class);
    }
    
    public OborySkupiny findById(int id) {
        return em.createNamedQuery("OborySkupiny.findByOborySkupinyId", OborySkupiny.class).setParameter("oborySkupinyId", id).getSingleResult();
    }
    
    public List<OborySkupiny> findWeb() {
        List skupinaOut = new ArrayList();
        OborySkupiny nulovaSkupina = new OborySkupiny();
        nulovaSkupina.setOborySkupinyId(0);
        nulovaSkupina.setOborySkupinyNazev("Neurčená");    
        nulovaSkupina.setOborySkupinyPopis("Neurčená");   
        skupinaOut.add(nulovaSkupina);
        skupinaOut.addAll(em.createNamedQuery("OborySkupiny.findAll", OborySkupiny.class).getResultList());
        return skupinaOut;
    }
    
}
