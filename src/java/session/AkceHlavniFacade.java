/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sprava.DvojiceCisloRetez;
import sprava.DvojiceRetezRetez;

/**
 *
 * @author 7Data Gotzy
 */
@Stateless
public class AkceHlavniFacade extends AbstractFacade<AkceHlavni> {

    @PersistenceContext(unitName = "EKCVJS2PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AkceHlavniFacade() {
        super(AkceHlavni.class);
    }

    /*public List<AkceHlavni> findForCategory(WebKategorieZakladni category) {
     return em.createQuery("SELECT p "
     + "FROM akce_hlavni p "
     + "CROSS JOIN web_vazba_kategorie_akce_hlavni "
     + "CROSS JOIN web_kategorie_zakladni "
     + "WHERE web_kategorie_zakladni_id = web_vazba_kategorie_akce_hlavni_kategorie_id "
     + "AND web_vazba_kategorie_akce_hlavni_akce_id = akce_id "
     + "AND web_kategorie_zakladni_id = :category").
     setParameter("category", category).getResultList();
     }*/

 /*   public List<AkceHlavni> findByFiltr(ArrayList input) {
     int idObdobi = ((DvojiceCisloRetez) input.get(0)).cislo();
     int idObor = ((DvojiceCisloRetez) input.get(1)).cislo();
     Obory obor = new Obory(idObor);
     Obdobi obdobi = new Obdobi(idObdobi);
     String dotaz = "SELECT p "
     + "FROM AkceHlavni p "
     + "WHERE p.akceId > 0 ";
     if (idObdobi > 0) {
     dotaz += "AND p.akceObdobi = :obdobi ";
     } else {
     dotaz += "AND p.akceObdobi != :obdobi ";
     }
     if (idObor > 0) {
     dotaz += "AND p.primObor = :obor ";
     } else {
     dotaz += "AND p.primObor != :obor ";
     }
     dotaz += "ORDER BY p.akceCislo ";
     return em.createQuery(dotaz, AkceHlavni.class).
     setParameter("obdobi", obdobi).setParameter("obor", obor).setMaxResults(20).getResultList();
     }*/
    public AkceHlavni findById(int id) {
        return em.createNamedQuery("AkceHlavni.findByAkceId", AkceHlavni.class).setParameter("akceId", id).getSingleResult();
    }

    public AkceHlavni findByCislo(String cislo) {
        return em.createNamedQuery("AkceHlavni.findByAkceCislo", AkceHlavni.class).setParameter("akceCislo", cislo).getSingleResult();
    }

    public List<AkceHlavni> findByFiltr(ArrayList input, String raditPodle, int pocetStrana, int prvniPozice) {

        int idObdobi = ((DvojiceCisloRetez) input.get(0)).cislo();
        int idObor = ((DvojiceCisloRetez) input.get(1)).cislo();
        String nazevAkce = ((DvojiceRetezRetez) input.get(2)).getR1();
        int idOborSkupina = ((DvojiceCisloRetez) input.get(3)).cislo();

        Obory obor;
        Obdobi obdobi;

        em.getEntityManagerFactory().getCache().evictAll();

        if (idObor > 0) {
            obor = em.createNamedQuery("Obory.findByOborId", Obory.class).setParameter("oborId", idObor).getSingleResult();
        } else {
            obor = new Obory();
            obor.setOborId(idObor);
        }
        if (idObdobi > 0) {
            obdobi = em.createNamedQuery("Obdobi.findByObdobiId", Obdobi.class).setParameter("obdobiId", idObdobi).getSingleResult();
        } else {
            obdobi = new Obdobi();
            obdobi.setObdobiId(0);
        }

        AkceRezimZverejneni arz1 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 20).getSingleResult();
        AkceRezimZverejneni arz2 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 40).getSingleResult();
              
        
        if (idObor > 0) {
            String dotaz = "SELECT p "
                    + "FROM AkceHlavni p "
                    + "WHERE p.akceId > 0 "
                    + "AND (p.akceRezimZverejneniId = :arz1 OR p.akceRezimZverejneniId = :arz2) ";

            if (idObdobi > 0) {
                dotaz += "AND p.akceObdobi = :obdobi ";
            } else {
                dotaz += "AND p.akceObdobi != :obdobi "
                        + "AND p.akceObdobi.obdobiNaWeb = true ";
            }
            if (idObor > 0) {
                dotaz += "AND p.primObor = :obor ";
            } else {
                dotaz += "AND p.primObor != :obor ";
            }

            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    dotaz += "AND ((lower(p.nazev) LIKE :vyraz) "
                            + "OR (lower(p.charakteristika) LIKE :vyraz)"
                            + "OR (lower(p.doporuceno) LIKE :vyraz)"
                            + "OR (lower(p.popis) LIKE :vyraz)"
                            + "OR (lower(p.poznamky) LIKE :vyraz))";
                }
            }

            dotaz += "ORDER BY p." + raditPodle;            
            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("obor", obor).setParameter("vyraz", "%" + nazevAkce.toLowerCase() + "%").setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
                } else {
                    return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("obor", obor).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
                }
            } else {
                return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                        setParameter("obdobi", obdobi).setParameter("obor", obor).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
            }
        } else {          

            /*String dotaz = "SELECT p "
                    + "FROM AkceHlavni p, OboryVazbySkupiny os "
                    + "WHERE p.akceId > 0 "
                    + "AND (p.akceRezimZverejneniId = :arz1 OR p.akceRezimZverejneniId = :arz2) ";
            if (idObdobi > 0) {
                dotaz += "AND p.akceObdobi = :obdobi ";
            } else {
                dotaz += "AND p.akceObdobi != :obdobi "
                        + "AND p.akceObdobi.obdobiNaWeb = true ";
            }
            dotaz += "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOborySkupinyId = :idOborSkupina "
                    + "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOboryId = p.primObor.oborId ";

            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    dotaz += "AND ((lower(p.nazev) LIKE :vyraz) "
                            + "OR (lower(p.charakteristika) LIKE :vyraz)"
                            + "OR (lower(p.doporuceno) LIKE :vyraz)"
                            + "OR (lower(p.popis) LIKE :vyraz)"
                            + "OR (lower(p.poznamky) LIKE :vyraz))";
                }
            }
            dotaz += "ORDER BY p." + raditPodle;*/
            
             String dotaz = "SELECT p "
                    + "FROM AkceHlavni p, OboryVazbySkupiny os "
                    + "WHERE p.akceId > 0 "
                    + "AND (p.akceRezimZverejneniId = :arz1 OR p.akceRezimZverejneniId = :arz2) ";
            if (idObdobi > 0) {
                dotaz += "AND p.akceObdobi = :obdobi ";
            } else {
                dotaz += "AND p.akceObdobi != :obdobi "
                        + "AND p.akceObdobi.obdobiNaWeb = true ";
            }
            dotaz += "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOborySkupinyId = :idOborSkupina "
                    + "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOboryId = p.primObor.oborId ";

            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    dotaz += "AND ((lower(p.nazev) LIKE :vyraz) "
                            + "OR (lower(p.charakteristika) LIKE :vyraz)"
                            + "OR (lower(p.doporuceno) LIKE :vyraz)"
                            + "OR (lower(p.popis) LIKE :vyraz)"
                            + "OR (lower(p.poznamky) LIKE :vyraz))";
                }
            }
            dotaz += "ORDER BY p." + raditPodle; 
            
           
            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                   
                    return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).setParameter("vyraz", "%" + nazevAkce.toLowerCase() + "%").setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
                } else {
                    return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
                }
            } else {
                return em.createQuery(dotaz, AkceHlavni.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                        setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList();
            }
        }

    }

    public long findPocetByFiltr(ArrayList input, String raditPodle) {
        int idObdobi = ((DvojiceCisloRetez) input.get(0)).cislo();
        int idObor = ((DvojiceCisloRetez) input.get(1)).cislo();
        String nazevAkce = ((DvojiceRetezRetez) input.get(2)).getR1();
        int idOborSkupina = ((DvojiceCisloRetez) input.get(3)).cislo();

        Obory obor;
        Obdobi obdobi;

        AkceRezimZverejneni arz1 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 20).getSingleResult();
        AkceRezimZverejneni arz2 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 40).getSingleResult();

        if (idObor > 0) {
            obor = em.createNamedQuery("Obory.findByOborId", Obory.class).setParameter("oborId", idObor).getSingleResult();
        } else {
            obor = new Obory();
            obor.setOborId(idObor);
        }
        if (idObdobi > 0) {
            obdobi = em.createNamedQuery("Obdobi.findByObdobiId", Obdobi.class).setParameter("obdobiId", idObdobi).getSingleResult();
        } else {
            obdobi = new Obdobi();
            obdobi.setObdobiId(0);
        }

        if (idObor > 0) {
            String dotaz = "SELECT COUNT(p) "
                    + "FROM AkceHlavni p "
                    + "WHERE p.akceId > 0 "
                    + "AND (p.akceRezimZverejneniId = :arz1 OR p.akceRezimZverejneniId = :arz2) ";
            if (idObdobi > 0) {
                dotaz += "AND p.akceObdobi = :obdobi ";
            } else {
                dotaz += "AND p.akceObdobi != :obdobi "
                        + "AND p.akceObdobi.obdobiNaWeb = true ";
            }
            if (idObor > 0) {
                dotaz += "AND p.primObor = :obor ";
            } else {
                dotaz += "AND p.primObor != :obor ";
            }
            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    dotaz += "AND ((lower(p.nazev) LIKE :vyraz)"
                            + "OR (lower(p.charakteristika) LIKE :vyraz)"
                            + "OR (lower(p.doporuceno) LIKE :vyraz)"
                            + "OR (lower(p.popis) LIKE :vyraz)"
                            + "OR (lower(p.poznamky) LIKE :vyraz))";
                }
            }
            //dotaz += "GROUP BY (p."+ raditPodle.substring(0, raditPodle.indexOf(" ")) + ") ORDER BY p." + raditPodle;

            
            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("obor", obor).setParameter("vyraz", nazevAkce).getSingleResult();
                } else {
                    return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("obor", obor).getSingleResult();
                }
            } else {
                return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                        setParameter("obdobi", obdobi).setParameter("obor", obor).getSingleResult();
            }
        } else {
            String dotaz = "SELECT COUNT(p) "
                    + "FROM AkceHlavni p, OboryVazbySkupiny os "
                    + "WHERE p.akceId > 0 "
                    + "AND (p.akceRezimZverejneniId = :arz1 OR p.akceRezimZverejneniId = :arz2) ";
            if (idObdobi > 0) {
                dotaz += "AND p.akceObdobi = :obdobi ";
            } else {
                dotaz += "AND p.akceObdobi != :obdobi "
                        + "AND p.akceObdobi.obdobiNaWeb = true ";
            }
            dotaz += "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOborySkupinyId = :idOborSkupina "
                    + "AND os.oboryVazbySkupinyPK.oboryVazbySkupinyOboryId = p.primObor.oborId ";

            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    dotaz += "AND ((lower(p.nazev) LIKE :vyraz) "
                             + "OR (lower(p.charakteristika) LIKE :vyraz)"
                            + "OR (lower(p.doporuceno) LIKE :vyraz)"
                            + "OR (lower(p.popis) LIKE :vyraz)"
                            + "OR (lower(p.poznamky) LIKE :vyraz))";
                }
            }

            if (nazevAkce != null) {
                if (!nazevAkce.isEmpty()) {
                    return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).setParameter("vyraz", "%" + nazevAkce.toLowerCase() + "%").getSingleResult();
                } else {
                    return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                            setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).getSingleResult();
                }
            } else {
                return em.createQuery(dotaz, Long.class).setParameter("arz1", arz1).setParameter("arz2", arz2).
                        setParameter("obdobi", obdobi).setParameter("idOborSkupina", idOborSkupina).getSingleResult();
            }
        }

    }

    public long findPocetByFiltrSkupina(ArrayList inputObor, ArrayList inputObdobi, String raditPodle) {
        /*
         * int idObdobi = ((DvojiceCisloRetez) input.get(0)).cislo(); int idObor
         * = ((DvojiceCisloRetez) input.get(1)).cislo(); Obory obor = new
         * Obory(idObor); Obdobi obdobi = new Obdobi(idObdobi); String dotaz =
         * "SELECT COUNT(p) " + "FROM AkceHlavni p " + "WHERE p.akceId > 0 "; if
         * (idObdobi > 0) { dotaz += "AND p.akceObdobi = :obdobi "; } else {
         * dotaz += "AND p.akceObdobi != :obdobi "; } if (idObor > 0) { dotaz +=
         * "AND p.primObor = :obor "; } else { dotaz += "AND p.primObor != :obor
         * "; } //dotaz += "GROUP BY (p."+ raditPodle.substring(0,
         * raditPodle.indexOf(" ")) + ") ORDER BY p." + raditPodle;
         *
         * return em.createQuery(dotaz, Long.class).
         * setParameter("obdobi", obdobi).setParameter("obor",
         * obor).getSingleResult();
         */
        return 0;
    }

    public List<AkceHlavni> findByFiltrSkupina(ArrayList inputObor, ArrayList inputObdobi, String raditPodle, int pocetStrana, int prvniPozice) {
        
        return null;
    }

    public List<AkceHlavni> findByNazevPopis(String vyraz, int pocetStrana, int prvniPozice) {
        List<AkceHlavni> wpdOut = new ArrayList<AkceHlavni>();
        
        AkceRezimZverejneni arz1 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 20).getSingleResult();
        AkceRezimZverejneni arz2 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 40).getSingleResult();

        
        wpdOut.addAll(em.createQuery("SELECT w FROM AkceHlavni w WHERE ((lower(w.charakteristika) LIKE :vyraz) OR (lower(w.popis) LIKE :vyraz) "
                + "OR (lower(w.nazev) LIKE :vyraz) OR (lower(w.doporuceno) LIKE :vyraz) "
                + "OR (lower(w.lektoriText) LIKE :vyraz) OR (lower(w.poznamky) LIKE :vyraz) "
                + "OR (lower(w.akceObdobi.nazev) LIKE :vyraz)) AND w.akceObdobi.obdobiId > 17 "
                + "AND w.akceObdobi.obdobiNaWeb = true "
                + "AND (w.akceRezimZverejneniId = :arz1 OR w.akceRezimZverejneniId = :arz2) "
                + "ORDER BY w.akceCislo DESC").
                setParameter("vyraz", "%" + vyraz + "%").setParameter("arz1", arz1).setParameter("arz2", arz2).setMaxResults(pocetStrana).setFirstResult(prvniPozice * pocetStrana).getResultList());
        // wpdOut.get(0).getWebPanelyDataPanel().getWebPanelyZalozka()
        return wpdOut;
    }

    public long findPocetByNazevPopis(String vyraz) {
        List<AkceHlavni> wpdOut = new ArrayList<AkceHlavni>();
        
        AkceRezimZverejneni arz1 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 20).getSingleResult();
        AkceRezimZverejneni arz2 = em.createNamedQuery("AkceRezimZverejneni.findByAkceRezimZverejneniId", AkceRezimZverejneni.class).setParameter("akceRezimZverejneniId", 40).getSingleResult();

        wpdOut.addAll(em.createQuery("SELECT COUNT(w) FROM AkceHlavni w WHERE ((lower(w.charakteristika) LIKE :vyraz) OR (lower(w.popis) LIKE :vyraz) "
                + "OR (lower(w.nazev) LIKE :vyraz) OR (lower(w.doporuceno) LIKE :vyraz) "
                + "OR (lower(w.lektoriText) LIKE :vyraz) OR (lower(w.poznamky) LIKE :vyraz) "
                + "OR (lower(w.akceObdobi.nazev) LIKE :vyraz)) AND w.akceObdobi.obdobiId > 17 "
                + "AND w.akceObdobi.obdobiNaWeb = true "
                + "AND (w.akceRezimZverejneniId = :arz1 OR w.akceRezimZverejneniId = :arz2) ").
                setParameter("vyraz", "%" + vyraz + "%").setParameter("arz1", arz1).setParameter("arz2", arz2).getResultList());
        // wpdOut.get(0).getWebPanelyDataPanel().getWebPanelyZalozka()
        return wpdOut.size();
    }
}
