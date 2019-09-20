/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.VazbaPanelyDataUloziste;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Favak
 */
@Stateless
public class VazbaPanelyDataUlozisteFacade extends AbstractFacade<VazbaPanelyDataUloziste> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VazbaPanelyDataUlozisteFacade() {
        super(VazbaPanelyDataUloziste.class);
    }
    
    public VazbaPanelyDataUloziste findByVazbaPanelDataId(int idPD) {
        String dotaz = "SELECT v "
                + "FROM VazbaPanelyDataUloziste v "
                + "WHERE v.vazbaPanelyDataUlozistePK.vazbaPanelyDataUlozistePanelData = :vazbaPanelyDataUlozistePanelData";
        return em.createQuery(dotaz, VazbaPanelyDataUloziste.class).
                setParameter("vazbaPanelyDataUlozistePanelData", idPD).getSingleResult();
    }
    
}
