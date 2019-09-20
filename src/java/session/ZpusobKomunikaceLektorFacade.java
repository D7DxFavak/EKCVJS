/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ZpusobKomunikaceLektor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class ZpusobKomunikaceLektorFacade extends AbstractFacade<ZpusobKomunikaceLektor> {
    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ZpusobKomunikaceLektorFacade() {
        super(ZpusobKomunikaceLektor.class);
    }
    
}
