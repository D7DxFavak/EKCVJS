/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.*;
import sprava.DvojiceCisloRetez;
import sprava.DvojiceRetezRetez;
import sprava.TrojiceRetezRetezRetez;
import sprava.ZobrazeniTabulek;

/**
 *
 * @author Favak
 */
@WebServlet(name = "EkcvjsServlet", loadOnStartup = 2,
        urlPatterns = {"/fulltextHledani",
            "/ekcvjs"})
public class EkcvjsServlet extends HttpServlet {

    @EJB
    private WebKategorieZakladniFacade kategorieFacade;
    @EJB
    private WebAktualityFacade aktualityFacade;
    @EJB
    private AkceHlavniFacade akceHlavniFacade;
    @EJB
    private OsobyFacade osobyPrihlaseni;
    @EJB
    private OrganizaceFacade organizaceFacade;
    @EJB
    private UzivateleFacade uzivatelPrihlaseni;
    @EJB
    private WebPanelyFacade panelyFacade;
    @EJB
    private PrihlaskyRozpisyFacade prihlaskyFacade;
    @EJB
    private VazbaPrihlaskyUlozisteDataFacade vazbaPrihlaskyUlozisteFacade;
    @EJB
    private OboryVazbySkupinyFacade oboryVazbySkupinyFacade;
    @EJB
    private VazbaOrganizaceUlozisteDataFacade vazbaOrganizaceUlozisteFacade;
    @EJB
    private VazbaOsobyUlozisteDataFacade vazbaOsobyUlozisteFacade;
    @EJB
    private WebPanelyDataFacade webPanelyDataFacade;
    @EJB
    private KatOrgTypyFacade katOrgTypyfacade;
    @EJB
    private KatOrgPolozkyFacade katOrgPolozkyfacade;
    @EJB
    private WebOrgOsFacade webOrgOsFacade;
    @EJB
    private WebOrgOsPendingFacade webOrgOsPendingFacade;
    @EJB
    private WebPropertiesFacade propertiesFacade;
    @EJB
    private KnihaFakturFacade knihaFakturFacade;
    @EJB
    private VazbaWebKategorieUlozisteDataFacade vazbaWebkategorieUlozisteDataFacade;
    @EJB
    private DruhyPrihlasekFacade druhyPrihlasekFacade;
    @EJB
    private WebOsZarazeniFacade webOsZarazeniFacade;
    private int sort = 0;
    private int sortCislo = 0;
    private int sortNazev = 0;
    private int sortTermin = 0;
    private int sortCena = 0;
    private int katOrgTyp = 0;
    private int katOrgDruh = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();

        Collection<PrihlaskyRozpisy> prihlaskySeznam;
        Collection<OboryVazbySkupiny> vybraneOborySkupiny;
        Collection<AkceHlavni> akcePrihlaseni;

        HttpSession session = request.getSession();
        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");
               

        if (zt == null) {
            //getServletContext().removeAttribute("zobrazeniTabulek.webProp");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);
        }

        zt.setIdKategorieZakladni(50);
        request.setAttribute("kategorieZakladniPopis", "ekcvjs");

        String akceRadit = "akceCislo DESC";

        // int idOborSkupina = 0;
        //  int idObor = 0;
        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;

        int idOrgVybrane = 0;
        int idOsobaDetail = 0;

        if (zt.getIdOborSkupina() == 0) {
            zt.setIdOborSkupina(3);
        }

        // get categoryId from request
        String odkazNazev = request.getQueryString();
        if (request.getRemoteUser() != null) {
            if (request.getAttribute("uzivatelePrihlaseni") == null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                request.setAttribute("uzivatelePrihlaseni", uzR);
            }
            if (request.getAttribute("klientPrihlaseni") == null) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    orgR = uzR.getUzivateleOrganizaceId();
                    request.setAttribute("klientPrihlaseni", orgR);
                    request.setAttribute("typKlient", 2); //2 - pro organizaci
                } else if (uzR.getUzivateleOsobyId() != null) {
                    klientR = uzR.getUzivateleOsobyId();
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("typKlient", 1); //1 - pro osobu
                } else {
                    request.setAttribute("typKlient", 0); //0 - pro nic
                }
            } else {
                request.setAttribute("typKlient", 0); //0 - pro nic
            }
        } else {
            request.setAttribute("typKlient", 0); //0 - pro nic
        }
       
        if (request.getParameter("idSkupina") != null) {
            zt.setIdOborSkupina(Integer.valueOf(request.getParameter("idSkupina")).intValue());
        }
        if (request.getParameter("idObor") != null) {
            zt.setIdObor(Integer.valueOf(request.getParameter("idObor")).intValue());
        }
        if (request.getParameter("idObdobi") != null) {
            zt.setIdObdobi(Integer.valueOf(request.getParameter("idObdobi")).intValue());
        }

        if (request.getParameter("hledanyText") != null) {
            zt.setHledanaAkce(request.getParameter("hledanyText"));
        }
        /*else {
            zt.setHledanaAkce("");
        }  */        
       
        if (request.getParameter("akceIdDetail") != null) {
            if (zt.getIdAkce() == Integer.valueOf(request.getParameter("akceIdDetail")).intValue()) {
                zt.setIdAkce(0);
            } else {
                zt.setIdAkce(Integer.valueOf(request.getParameter("akceIdDetail")).intValue());
            }
        }

        if (request.getParameter("zobrazTabulku") != null) {
            zt.setZobrazitTabulku(Integer.valueOf(request.getParameter("zobrazTabulku")).intValue());
        }/*
         * else { zt.setZobrazitTabulku(1); }
         */

        if (request.getParameter("idTypOrg") != null) {
            katOrgTyp = Integer.valueOf(request.getParameter("idTypOrg")).intValue();
            zt.setKatOrgTyp(Integer.valueOf(request.getParameter("idTypOrg")).intValue());
        } else {
            if (orgR != null && request.getParameter("idDruhOrg") == null) {
                katOrgTyp = orgR.getKatorgtyp().getKatorgtypId();
                zt.setKatOrgTyp(orgR.getKatorgtyp().getKatorgtypId());
                // session.setAttribute("zobrazeniTabulek", zt);
            }
        }
        if (request.getParameter("idDruhOrg") != null) {

            katOrgDruh = Integer.valueOf(request.getParameter("idDruhOrg")).intValue();
            zt.setKatOrgDruh(Integer.valueOf(request.getParameter("idDruhOrg")).intValue());
        } else {
            if (orgR != null) {

                katOrgDruh = orgR.getKatOrgPolozky().getKatOrgPolozkyPK().getKatorgpolId();
                zt.setKatOrgDruh(orgR.getKatOrgPolozky().getKatOrgPolozkyPK().getKatorgpolId());
              
            }
        }
       
        if (request.getParameter("detailOsobaId") != null) {
            idOsobaDetail = Integer.valueOf(request.getParameter("detailOsobaId")).intValue();
        }

        if (request.getParameter("idOrganizace") != null) {

            idOrgVybrane = Integer.valueOf(request.getParameter("idOrganizace"));
        }

        if (request.getParameter("sort") != null) {
            sort = Integer.valueOf(request.getParameter("sort")).intValue();
        } else {
            sort = -1;
        }
        if (request.getParameter("pocetStrana") != null) {
            zt.setPocetStrana(Integer.valueOf(request.getParameter("pocetStrana")).intValue());
            getServletContext().setAttribute("pocetStrana", zt.getPocetStrana());
        }
        if (request.getParameter("offset") != null) {
            int strana = Integer.valueOf(request.getParameter("offset")).intValue();
            if (strana == -1) {
                zt.setOffset(zt.getOffset() - 1);
            } else if (strana == -2) {
                zt.setOffset(zt.getOffset() + 1);
            } else {
                zt.setOffset(strana);
            }
            getServletContext().setAttribute("offset", zt.getOffset());
        }
        if (odkazNazev != null) {
            if (odkazNazev.contains("&")) {
                odkazNazev = odkazNazev.substring(0, odkazNazev.indexOf("&"));
            }

            if (odkazNazev.equals("prihlaskyAkce.jsp") || odkazNazev.equals("novePrihlaseni.jsp") || odkazNazev.equals("absolvovaneAkce.jsp")) {
                request.setAttribute("selectedCenterId", 10);
                akceRadit = nastavSort(akceRadit);
                request.setAttribute("sortCislo", sortCislo);
                request.setAttribute("sortNazev", sortNazev);
                request.setAttribute("sortTermin", sortTermin);
                request.setAttribute("sortCena", sortCena);
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);

                if (odkazNazev.equals("prihlaskyAkce.jsp")) {
                    if (!zt.getAktualniStranka().equals("ekcvjs?prihlaskyAkce.jsp")) {
                        zt.vycistit("ekcvjs?prihlaskyAkce.jsp");
                    }

                    if (uzR.getUzivateleOrganizaceId() != null) {
                        long celkemZaznamu = prihlaskyFacade.findPocetAkceByOrganizaceMultiAktivni(orgR);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOrganizaceMultiAktivni(orgR, akceRadit, zt.getPocetStrana(), zt.getOffset()));

                    } else if (uzR.getUzivateleOsobyId() != null) {
                        long celkemZaznamu = prihlaskyFacade.findPocetByOsobaMultiAktivni(klientR);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);
                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOsobaMultiAktivni(klientR, akceRadit, zt.getPocetStrana(), 0));
                    } else {
                        prihlaskySeznam = null;
                    }

                    if (zt.getIdAkce() > 0) {
                        if ((odkazNazev.equals("prihlaskyAkce.jsp")) && (uzR.getUzivateleOrganizaceId() != null)) {
                            request.setAttribute("prihlaseneOsoby", prihlaskyFacade.findByOrganizaceAkceAktivni(orgR, akceHlavniFacade.findById(zt.getIdAkce())));
                        }
                    }
                }
                if (odkazNazev.equals("absolvovaneAkce.jsp")) {
                    if (!zt.getAktualniStranka().equals("ekcvjs?absolvovaneAkce.jsp")) {
                        zt.vycistit("ekcvjs?absolvovaneAkce.jsp");
                    }

                    if (uzR.getUzivateleOrganizaceId() != null) {
                        long celkemZaznamu = prihlaskyFacade.findPocetAkceByOrganizaceMultiSkoncena(orgR);
                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);
                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOrganizaceMultiSkoncena(orgR, akceRadit, zt.getPocetStrana(), zt.getOffset()));

                    } else if (uzR.getUzivateleOsobyId() != null) {
                        long celkemZaznamu = prihlaskyFacade.findPocetByOsobaMultiSkoncena(klientR);
                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        //prihlaskySeznam = ;
                       
                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOsobaMultiSkoncena(klientR, akceRadit, zt.getPocetStrana(), 0));
                    } else {
                        prihlaskySeznam = null;
                    }
                    if (zt.getIdAkce() > 0) {
                        if (uzR.getUzivateleOrganizaceId() != null) {
                            request.setAttribute("prihlaseneOsoby", prihlaskyFacade.findByOrganizaceAkceSkoncena(orgR, akceHlavniFacade.findById(zt.getIdAkce())));
                        }
                    }
                }
                if (odkazNazev.equals("novePrihlaseni.jsp")) {
                    if (!zt.getAktualniStranka().equals("ekcvjs?novePrihlaseni.jsp")) {
                        zt.vycistit("ekcvjs?novePrihlaseni.jsp");
                    }
                   
                    ArrayList dotazIn = new ArrayList();
                    if (zt.getIdOborSkupina() > 0) {
                        vybraneOborySkupiny = new ArrayList<OboryVazbySkupiny>();
                        OboryVazbySkupiny nulovy = new OboryVazbySkupiny();
                        Obory nulovyObor = new Obory();
                        nulovyObor.setOborId(0);
                        nulovyObor.setNazev("Neurčen");
                        nulovy.setObory(nulovyObor);
                        vybraneOborySkupiny.add(nulovy);
                        vybraneOborySkupiny.addAll(oboryVazbySkupinyFacade.findBySkupinyId(zt.getIdOborSkupina()));
                        request.setAttribute("vybraneOborySkupiny", vybraneOborySkupiny);
                    } else if (zt.getIdOborSkupina() == 0 /*&& (Integer) request.getAttribute("typKlient") == 2*/) {
                        zt.setIdOborSkupina(4);
                        vybraneOborySkupiny = new ArrayList<OboryVazbySkupiny>();
                        OboryVazbySkupiny nulovy = new OboryVazbySkupiny();
                        Obory nulovyObor = new Obory();
                        nulovyObor.setOborId(0);
                        nulovyObor.setNazev("Neurčen");
                        nulovy.setObory(nulovyObor);
                        vybraneOborySkupiny.add(nulovy);
                        vybraneOborySkupiny.addAll(oboryVazbySkupinyFacade.findBySkupinyId(zt.getIdOborSkupina()));
                        request.setAttribute("vybraneOborySkupiny", vybraneOborySkupiny);
                    }
                    dotazIn.add(new DvojiceCisloRetez(zt.getIdObdobi(), "idObdobi"));
                    dotazIn.add(new DvojiceCisloRetez(zt.getIdObor(), "idObor"));
                    
                    
                    if (zt.getHledanaAkce().isEmpty() == false) {
                        dotazIn.add(new DvojiceRetezRetez(zt.getHledanaAkce(), "hledanaAkce"));
                    } else {
                        dotazIn.add(new DvojiceRetezRetez("", "hledanaAkce"));
                    }

                    dotazIn.add(new DvojiceCisloRetez(zt.getIdOborSkupina(), "idOborSkupina"));

                    /*if (session.getAttribute("fulltextSearch") != null) {
                        dotazIn.add(new DvojiceRetezRetez((String) session.getAttribute("fulltextSearch"), "nazevPopis"));
                    } else {
                        dotazIn.add(new DvojiceRetezRetez("", "nazevPopis"));
                    }*/
                    request.setAttribute("vybranyOborSkupina", zt.getIdOborSkupina());
                    List akceList = akceHlavniFacade.findByFiltr(dotazIn, akceRadit, zt.getPocetStrana(), zt.getOffset());
                    for (int i = 0; i < akceList.size(); i++) {
                        AkceHlavni ah = (AkceHlavni) akceList.get(i);
                        long prihlaseno = prihlaskyFacade.findPocetByFiltr(ah);
                        if (prihlaseno >= ah.getOptimalniPocet()) {
                            ah.setVolno(false);
                        } else {
                            ah.setVolno(true);
                        }
                        if(ah.getStavAkce().getUPridprihl() == false) { // TODO : dodelat pred kompilaci
                            ah.setVolno(false);
                        }
                        akceList.set(i, ah);
                    }
                    akcePrihlaseni = akceList;
                    long celkemZaznamu = akceHlavniFacade.findPocetByFiltr(dotazIn, akceRadit);
                                    
                    request.setAttribute("pocetZaznamu", celkemZaznamu);
                    request.setAttribute("akcePrihlaseni", akcePrihlaseni);
                    long pocetStran = celkemZaznamu / zt.getPocetStrana();
                    if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                        pocetStran++;
                    }
                    ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                    DvojiceCisloRetez dcr;
                    if (zt.getOffset() > 0) {
                        dcr = new DvojiceCisloRetez(-1, "Předchozí");
                        strany.add(dcr);
                    }
                    for (int i = zt.getOffset(); i < pocetStran /*
                             * + offset
                             */; i++) {
                        if (i < 4 + zt.getOffset()) {
                            dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                            strany.add(dcr);
                        }
                        if (i >= 4 + zt.getOffset()) {
                            dcr = new DvojiceCisloRetez(-2, "Další");
                            strany.add(dcr);
                            break;
                        }
                    }
                    request.setAttribute("strany", strany);
                }
            } else if (odkazNazev.equals("aktuality.jsp")) {
                Collection<WebAktuality> aktualitySeznam = aktualityFacade.findByKategorie(50, zt.getPocetStrana(), zt.getOffset());
                request.setAttribute("aktualitySeznam", aktualitySeznam);
                request.setAttribute("selectedCenter", odkazNazev);
                request.setAttribute("idAktualitaDetail", zt.getIdAktualita());
                request.setAttribute("kategorieAktuality", kategorieFacade.findById(50).getWebKategorieZakladniPopis());
            } else if (odkazNazev.equals("ekcvjs.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?ekcvjs.jsp")) {
                    zt.vycistit("ekcvjs?ekcvjs.jsp");
                }
                WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(50));
                Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);               
                request.setAttribute("panelyData", panelyData);
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/zakladniInfo.jsp");
                // request.setAttribute("idAktualitaDetail", zt.getIdAktualita());
            } else if (odkazNazev.equals("keStazeni.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?keStazeni.jsp")) {
                    zt.vycistit("ekcvjs?keStazeni.jsp");
                    zt.setPocetStrana(20);
                }
                if (request.getParameter("sort") != null) {
                    if (zt.getSort() == -1) {
                        zt.setSort(Integer.valueOf(request.getParameter("sort")).intValue());
                        zt.setSortTyp(" ASC");
                    } else {
                        if (zt.getSort() == Integer.valueOf(request.getParameter("sort")).intValue()) {
                            if (zt.getSortTyp().contains("ASC")) {
                                zt.setSortTyp(" DESC");
                            } else {
                                zt.setSortTyp(" ASC");
                            }
                        } else {
                            zt.setSort(Integer.valueOf(request.getParameter("sort")).intValue());
                        }
                    }
                } else {
                    zt.setSort(-1);
                }

                long celkemZaznamu = vazbaWebkategorieUlozisteDataFacade.findPocetByWebKategorieUlozisteData(kategorieFacade.findById(zt.getIdKategorieZakladni()));

                long pocetStran = celkemZaznamu / zt.getPocetStrana();
                if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                    pocetStran++;
                }
                ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                DvojiceCisloRetez dcr;
                if (zt.getOffset() > 0) {
                    dcr = new DvojiceCisloRetez(-1, "Předchozí");
                    strany.add(dcr);
                }
                for (int i = zt.getOffset(); i < pocetStran /*
                         * + offset
                         */; i++) {
                    if (i < 4 + zt.getOffset()) {
                        dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                        strany.add(dcr);
                    }
                    if (i >= 4 + zt.getOffset()) {
                        dcr = new DvojiceCisloRetez(-2, "Další");
                        strany.add(dcr);
                        break;
                    }
                }
                request.setAttribute("strany", strany);

                WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(zt.getIdKategorieZakladni()));
                Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                request.setAttribute("panelNazev", wp.getWebPanelyNazev());
                request.setAttribute("panelOdkaz", wp.getWebPanelyOdkaz());
                request.setAttribute("panelyData", panelyData);
                request.setAttribute("selectedCenter", odkazNazev);

                request.setAttribute("seznamDokumentu", vazbaWebkategorieUlozisteDataFacade.findVazbyWebKategorieUlozisteData(kategorieFacade.findById(zt.getIdKategorieZakladni()), zt));

            } else if (odkazNazev.equals("prihlaseniUzivatele.jsp")) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    request.setAttribute("logUser", uzR.getUzivateleOrganizaceId().getNazev());
                    List<WebOrgOs> pridruzeneOsoby = webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId());
                    boolean gdprSouhlasVsichni = true;
                    for (WebOrgOs pd : pridruzeneOsoby) {
                        if (!pd.getWebOrgOsOsoba().isGdprUdeleno()) {
                            gdprSouhlasVsichni = false;
                            break;
                        }
                    }
                    request.setAttribute("gdprVsichniZamestnanci", gdprSouhlasVsichni);
                    request.setAttribute("aktivniPrihlasky", prihlaskyFacade.findPocetByOrganizaceMultiAktivni(uzR.getUzivateleOrganizaceId()));
                    request.setAttribute("skoncenePrihlasky", prihlaskyFacade.findPocetByOrganizaceMultiSkoncena(uzR.getUzivateleOrganizaceId()));
                } else if (uzR.getUzivateleOsobyId() != null) {
                    request.setAttribute("logUser", uzR.getUzivateleOsobyId().getJmeno() + " " + uzR.getUzivateleOsobyId().getPrijmeni());
                    request.setAttribute("aktivniPrihlasky", prihlaskyFacade.findPocetByOsobaMultiAktivni(uzR.getUzivateleOsobyId()));
                    request.setAttribute("skoncenePrihlasky", prihlaskyFacade.findPocetByOsobaMultiSkoncena(uzR.getUzivateleOsobyId()));
                }
                request.setAttribute("aktualniStranka", zt.getAktualniStranka());
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/prihlaseniUzivatele.jsp");
            } else if (odkazNazev.equals("klientskeUdaje.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?klientskeUdaje.jsp")) {
                    zt.vycistit("ekcvjs?klientskeUdaje.jsp");
                }
                if (uzR.getUzivateleOrganizaceId() != null) {
                    request.setAttribute("vyberKatOrgTyp", katOrgTyp);
                    request.setAttribute("vyberKatOrgDruh", katOrgDruh);
                    request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                    request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(katOrgTyp));
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/organizaceUdaje.jsp");
                } else if (uzR.getUzivateleOsobyId() != null) {
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
                }
            } else if (odkazNazev.equals("organizaceUdaje.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?organizaceUdaje.jsp")) {
                    zt.vycistit("ekcvjs?organizaceUdaje.jsp");
                }
                request.setAttribute("vyberKatOrgTyp", katOrgTyp);
                request.setAttribute("vyberKatOrgDruh", katOrgDruh);
                request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(katOrgTyp));
                request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/organizaceUdaje.jsp");
            } else if (odkazNazev.equals("detailyOsoby.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?detailyOsoby.jsp")) {
                    zt.vycistit("ekcvjs?detailyOsoby.jsp");
                }
                if (idOsobaDetail > 0) {
                    klientR = osobyPrihlaseni.findPodleId(idOsobaDetail);
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("selectedCenterId", 10);
                    if (zt.getZobrazitTabulku() == 2) {
                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOsobaMultiAktivniPrihlaska(klientR, akceRadit, 10, 0));
                    } else if (zt.getZobrazitTabulku() == 3) {
                        request.setAttribute("prihlaskyAkce", prihlaskyFacade.findByOsobaMultiSkoncenaPrihlaska(klientR, akceRadit, 10, 0));
                    }
                } else {
                    request.setAttribute("klientPrihlaseni", new Osoby());
                }
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            } else if (odkazNazev.equals("gdprInfo.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?gdprInfo.jsp")) {
                    zt.vycistit("ekcvjs?gdprInfo.jsp");
                }
                if (idOsobaDetail > 0) {
                    klientR = osobyPrihlaseni.findPodleId(idOsobaDetail);
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("selectedCenterId", 10);

                }
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            } else if (odkazNazev.equals("vseobecnepodminky.jsp")) {
                if (!zt.getAktualniStranka().equals("ekcvjs?vseobecnepodminky.jsp")) {
                    zt.vycistit("ekcvjs?vseobecnepodminky.jsp");
                }
                /* if (idOsobaDetail > 0) {
                    klientR = osobyPrihlaseni.findPodleId(idOsobaDetail);
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("selectedCenterId", 10);

                }*/
                request.setAttribute("selectedCenterId", 10);
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            } else if (odkazNazev.equals("pridruzeneOsoby.jsp") && (orgR != null)) {
              
                if (!zt.getAktualniStranka().equals("ekcvjs?pridruzeneOsoby.jsp")) {
                    zt.vycistit("ekcvjs?pridruzeneOsoby.jsp");
                }
                ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();;
                if (webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()) != null) {
                    long celkemZaznamu = webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()).size();
                    long pocetStran = celkemZaznamu / zt.getPocetStrana();
                    if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                        pocetStran++;
                    }
                    DvojiceCisloRetez dcr;
                    if (zt.getOffset() > 0) {
                        dcr = new DvojiceCisloRetez(-1, "Předchozí");
                        strany.add(dcr);
                    }
                    for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                             */; i++) {
                        if (i < 4 + zt.getOffset()) {
                            dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                            strany.add(dcr);
                        }
                        if (i >= 4 + zt.getOffset()) {
                            dcr = new DvojiceCisloRetez(-2, "Další");
                            strany.add(dcr);
                            break;
                        }
                    }
                } else {
                    DvojiceCisloRetez dcr = new DvojiceCisloRetez(0, 1 + "");
                    strany.add(dcr);
                }
                request.setAttribute("strany", strany);
               
                request.setAttribute("selectedCenterId", 10);
                request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId(), zt.getPocetStrana(), zt.getOffset()));

                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            } else if (odkazNazev.equals("zamestnavatelUdaje.jsp") && (klientR != null)) {
                if (!zt.getAktualniStranka().equals("ekcvjs?zamestnavatelUdaje.jsp")) {
                    zt.vycistit("ekcvjs?zamestnavatelUdaje.jsp");
                }
               
                // request.setAttribute("selectedCenterId", 10);
                // request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                ArrayList<WebOrgOs> zamestnavateleOrgOs = new ArrayList(webOrgOsFacade.findByOsoba(klientR.getOsobaId()));
                if (idOrgVybrane > 0) {
                    request.setAttribute("vybranyZam", organizaceFacade.findPodleId(idOrgVybrane));
                } else {
                    if (zamestnavateleOrgOs.size() > 0) {
                        request.setAttribute("vybranyZam", zamestnavateleOrgOs.get(0).getWebOrgOsOrganizace());
                    }
                }
                request.setAttribute("zamestnavatele", zamestnavateleOrgOs);

                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/zamestnavatelUdaje.jsp");
            } else if (odkazNazev.equals("navrhovaneOsoby.jsp") && (orgR != null)) {
                if (!zt.getAktualniStranka().equals("ekcvjs?navrhovaneOsoby.jsp")) {
                    zt.vycistit("ekcvjs?navrhovaneOsoby.jsp");
                }
                ArrayList<Osoby> navrhOsoby = new ArrayList(prihlaskyFacade.findDistinctByObjednavatel(orgR));
                ArrayList<WebOrgOs> pridrOsoby = new ArrayList(webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                ArrayList<WebOrgOsPending> pridrOsobyPending = new ArrayList(webOrgOsPendingFacade.findByOrganizace(orgR.getOrganizaceId()));
                for (int i = 0; i < pridrOsoby.size(); i++) {
                    if (navrhOsoby.contains(pridrOsoby.get(i).getWebOrgOsOsoba())) {
                        navrhOsoby.remove(pridrOsoby.get(i).getWebOrgOsOsoba());
                    }
                }
                for (int i = 0; i < pridrOsobyPending.size(); i++) {
                    if (!navrhOsoby.contains(pridrOsobyPending.get(i).getWebOrgOsOsoba())) {
                        navrhOsoby.add(pridrOsobyPending.get(i).getWebOrgOsOsoba());
                    }
                }
                request.setAttribute("navrhovaneOsoby", navrhOsoby);
                request.setAttribute("selectedCenterId", 10);
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            } else if (odkazNazev.equals("vypisDokumentu.jsp")) {

                if (uzR.getUzivateleOrganizaceId() != null) {
                    if (!zt.getAktualniStranka().equals("ekcvjs?vypisDokumentuOrg.jsp")) {
                        int pomZobrazitTabulku = zt.getZobrazitTabulku();
                        zt.vycistit("ekcvjs?vypisDokumentuOrg.jsp");
                        zt.setZobrazitTabulku(pomZobrazitTabulku);
                    }
                    if (request.getParameter("zobrazitTabulku") != null) {// 1 - faktury, 2 - certifikaty, 3 - ostatni
                        zt.setZobrazitTabulku(Integer.valueOf(request.getParameter("zobrazitTabulku")).intValue());
                    }
                    if (zt.getZobrazitTabulku() == 1) {
                        java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy", new Locale("cs, CZ"));
                        Date d = null;
                        try {
                            d = df.parse("2.11.2018");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //TODO : List knihaFaktur = knihaFakturFacade.findByDate(d, "datumVystaveni DESC", zt.getPocetStrana(), zt.getOffset());

                        List knihaFaktur = knihaFakturFacade.findByFiltr(orgR, "datumVystaveni DESC", zt.getPocetStrana(), zt.getOffset());
                        KnihaFaktur kf = null;
                        for (int i = 0; i < knihaFaktur.size(); i++) {
                            kf = (KnihaFaktur) knihaFaktur.get(i);
                            if (kf.getFakturyUhradyCollection().size() > 0) {
                                ArrayList aFU = new ArrayList(kf.getFakturyUhradyCollection());
                                BigDecimal uhrazeno = new BigDecimal(0);
                                for (int j = 0; j < aFU.size(); j++) {
                                    uhrazeno = uhrazeno.add(((FakturyUhrady) aFU.get(j)).getUhrada());
                                }
                                kf.setUhrazeno(uhrazeno);
                            } else {
                                kf.setUhrazeno(BigDecimal.ZERO);
                            }
                            if (kf.getVazbaFakturyUlozisteDataCollection().size() > 0) {
                                kf.setExistujePDF(true);
                            } else {
                                kf.setExistujePDF(false);
                            }
                        }

                        long celkemZaznamu = knihaFakturFacade.findPocetByFiltr(orgR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamFaktur", knihaFaktur);
                    } else if (zt.getZobrazitTabulku() == 2) {
                        List seznamPrihlasek = vazbaPrihlaskyUlozisteFacade.findByTEST(orgR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());
                        //TODO : List seznamPrihlasek = vazbaPrihlaskyUlozisteFacade.findByOrganizace(orgR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());

                        long celkemZaznamu = vazbaPrihlaskyUlozisteFacade.findPocetByFiltr(orgR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamCertifikatu", seznamPrihlasek);
                    } else if (zt.getZobrazitTabulku() == 3) {
                        List seznamPrihlasek = vazbaOrganizaceUlozisteFacade.findVazbyOrganizaceUlozisteData(orgR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());

                        long celkemZaznamu = vazbaOrganizaceUlozisteFacade.findPocetVazbyOrganizaceUlozisteData(orgR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamDokumentu", seznamPrihlasek);
                    }
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/vypisDokumentuOrg.jsp");
                    request.setAttribute("selectedCenterId", 10);
                } else if (uzR.getUzivateleOsobyId() != null) {
                    if (!zt.getAktualniStranka().equals("ekcvjs?vypisDokumentuOs.jsp")) {
                        zt.vycistit("ekcvjs?vypisDokumentuOs.jsp");
                    }
                    if (request.getParameter("zobrazitTabulku") != null) {// 1 - faktury, 2 - certifikaty, 3 - ostatni
                        zt.setZobrazitTabulku(Integer.valueOf(request.getParameter("zobrazitTabulku")).intValue());
                    }
                    if (zt.getZobrazitTabulku() == 1) {
                        List knihaFaktur = knihaFakturFacade.findByFiltr(klientR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());
                        KnihaFaktur kf = null;
                        for (int i = 0; i < knihaFaktur.size(); i++) {
                            kf = (KnihaFaktur) knihaFaktur.get(i);
                            if (kf.getFakturyUhradyCollection().size() > 0) {
                                ArrayList aFU = new ArrayList(kf.getFakturyUhradyCollection());
                                BigDecimal uhrazeno = new BigDecimal(0);
                                for (int j = 0; j < aFU.size(); j++) {
                                    uhrazeno = uhrazeno.add(((FakturyUhrady) aFU.get(j)).getUhrada());
                                }
                                kf.setUhrazeno(uhrazeno);
                            } else {
                                kf.setUhrazeno(BigDecimal.ZERO);
                            }
                            if (kf.getVazbaFakturyUlozisteDataCollection().size() > 0) {
                                kf.setExistujePDF(true);
                            } else {
                                kf.setExistujePDF(false);
                            }
                        }

                        long celkemZaznamu = knihaFakturFacade.findPocetByFiltr(klientR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamFaktur", knihaFaktur);
                    } else if (zt.getZobrazitTabulku() == 2) {
                        List seznamPrihlasek = vazbaPrihlaskyUlozisteFacade.findByOsoba(klientR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());

                        long celkemZaznamu = vazbaPrihlaskyUlozisteFacade.findPocetByFiltr(klientR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamCertifikatu", seznamPrihlasek);
                    } else if (zt.getZobrazitTabulku() == 3) {
                        List seznamPrihlasek = vazbaOsobyUlozisteFacade.findVazbyOsobyUlozisteData(klientR, "datumVystaveni", zt.getPocetStrana(), zt.getOffset());

                        long celkemZaznamu = vazbaOsobyUlozisteFacade.findPocetVazbyOsobyUlozisteData(klientR);
                        request.setAttribute("pocetZaznamu", celkemZaznamu);

                        long pocetStran = celkemZaznamu / zt.getPocetStrana();
                        if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                            pocetStran++;
                        }
                        ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
                        DvojiceCisloRetez dcr;
                        if (zt.getOffset() > 0) {
                            dcr = new DvojiceCisloRetez(-1, "Předchozí");
                            strany.add(dcr);
                        }
                        for (int i = zt.getOffset(); i < pocetStran /*
                                 * + offset
                                 */; i++) {
                            if (i < 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                                strany.add(dcr);
                            }
                            if (i >= 4 + zt.getOffset()) {
                                dcr = new DvojiceCisloRetez(-2, "Další");
                                strany.add(dcr);
                                break;
                            }
                        }
                        request.setAttribute("strany", strany);

                        request.setAttribute("seznamDokumentu", seznamPrihlasek);
                    }
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/vypisDokumentuOs.jsp");
                    request.setAttribute("selectedCenterId", 10);
                }
            } else {
               
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/" + odkazNazev);
            }

        } /*else if (odkazNazev.equals("cart.jsp")) {
            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {                
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
                session.setAttribute("chybneOsoby", new ArrayList<Osoby>());

            }

            ArrayList<Osoby> chybneOsoby = (ArrayList) session.getAttribute("chybneOsoby");
            ArrayList<Osoby> chybneOsobyOut = new ArrayList<Osoby>();

            if (chybneOsoby != null) {
                for (int i = 0; i < chybneOsoby.size(); i++) {
                    Osoby o = osobyPrihlaseni.findPodleId(chybneOsoby.get(i).getOsobaId());
                    if (o.getJmeno() == null || o.getPrijmeni() == null || o.getAdresa() == null
                            || o.getMesto() == null || o.getPsc() == null || (o.getDatumNarozeni() == null || o.getRodneCislo() == null)) {
                        chybneOsobyOut.add(o);
                    }
                }
                session.setAttribute("chybneOsoby", chybneOsobyOut);
            }
            try {
                if (request.getParameterValues("idDruhPrihl")[0] != null) {
                    String param = request.getParameterValues("idDruhPrihl")[0];
                    int indexKosik = Integer.parseInt(param.substring(0, param.indexOf("x")));
                    int indexDruhPrihl = Integer.parseInt(param.substring(param.indexOf("x") + 1, param.lastIndexOf("x")));
                    int idDruhPrihl = Integer.valueOf(param.substring(param.lastIndexOf("x") + 1)).intValue();

                    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                    DruhyPrihlasek dp = druhyPrihlasekFacade.findById(idDruhPrihl);
                    cart.getItems().get(indexKosik).getDruhyPrihlasek().get(indexDruhPrihl).setDruhPrihlId(idDruhPrihl);
                    cart.getItems().get(indexKosik).getDruhyPrihlasek().get(indexDruhPrihl).setNazev(dp.getNazev());

                    session.setAttribute("cart", cart);
                }
            } catch (Exception e) {
            }

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/cart.jsp");
            WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
            Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
            request.setAttribute("panelyData", panelyData);
            String url = "/ekcvjs.jsp";
            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // if checkout page is requested
        } */ else {
            request.setAttribute("selectedCenterId", 0);
        }

        try {
            request.getRequestDispatcher(userPath + ".jsp").forward(request, response);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        
        request.setCharacterEncoding("UTF-8");

        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;
        // get categoryId from request
        String odkazNazev = request.getQueryString();

        if (request.getRemoteUser() != null) {
            if (request.getAttribute("uzivatelePrihlaseni") == null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                request.setAttribute("uzivatelePrihlaseni", uzR);
            }
            if (request.getAttribute("klientPrihlaseni") == null) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    orgR = uzR.getUzivateleOrganizaceId();
                    request.setAttribute("klientPrihlaseni", orgR);
                    request.setAttribute("typKlient", 2); //2 - pro organizaci
                } else if (uzR.getUzivateleOsobyId() != null) {
                    klientR = uzR.getUzivateleOsobyId();
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("typKlient", 1); //1 - pro osobu
                }
            }
        }

        //ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");

        // if addToCart action is called
        if (zt == null) {
            getServletContext().removeAttribute("zobrazeniTabulek.webProp");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);
        }

        if (userPath.equals("/fulltextHledani")) {

            Collection<OboryVazbySkupiny> vybraneOborySkupiny;
            /*
             * PoslatMail pm = new PoslatMail("pokus@favak.cz",
             * "tomas.gotzy@7data.eu", "Zprava z ekCVJS", "Prvni text je na
             * svete");
             *
             * String reportSource =
             * getServletConfig().getServletContext().getRealPath("/tisk/osvedceni.jrxml");
             * pm.vytvorPrilohu(reportSource, 100432);
             *
             * pm.send();
             */
            Collection<AkceHlavni> akcePrihlaseni;

            //zt.vycistit("ekcvjs?noveprihlaseni.jsp");
            zt.setPocetStrana(20);

            String hledanyVyraz = request.getParameter("hledanyText");

            if (!zt.getAktualniStranka().equals("ekcvjs?novePrihlaseni.jsp")) {
                zt.vycistit("ekcvjs?novePrihlaseni.jsp");
            }
            
            zt.setHledanaAkce(hledanyVyraz);

            if (zt.getIdOborSkupina() > 0) {
                vybraneOborySkupiny = new ArrayList<OboryVazbySkupiny>();
                OboryVazbySkupiny nulovy = new OboryVazbySkupiny();
                Obory nulovyObor = new Obory();
                nulovyObor.setOborId(0);
                nulovyObor.setNazev("Neurčen");
                nulovy.setObory(nulovyObor);
                vybraneOborySkupiny.add(nulovy);
                vybraneOborySkupiny.addAll(oboryVazbySkupinyFacade.findBySkupinyId(zt.getIdOborSkupina()));
                request.setAttribute("vybraneOborySkupiny", vybraneOborySkupiny);
            } else if (zt.getIdOborSkupina() == 0 && (Integer) request.getAttribute("typKlient") == 2) {
                zt.setIdOborSkupina(4);
                vybraneOborySkupiny = new ArrayList<OboryVazbySkupiny>();
                OboryVazbySkupiny nulovy = new OboryVazbySkupiny();
                Obory nulovyObor = new Obory();
                nulovyObor.setOborId(0);
                nulovyObor.setNazev("Neurčen");
                nulovy.setObory(nulovyObor);
                vybraneOborySkupiny.add(nulovy);
                vybraneOborySkupiny.addAll(oboryVazbySkupinyFacade.findBySkupinyId(zt.getIdOborSkupina()));
                request.setAttribute("vybraneOborySkupiny", vybraneOborySkupiny);
            }

            List akceList = akceHlavniFacade.findByNazevPopis(hledanyVyraz.toLowerCase(),zt.getPocetStrana(), zt.getOffset());
            for (int i = 0; i < akceList.size(); i++) {
                AkceHlavni ah = (AkceHlavni) akceList.get(i);
                long prihlaseno = prihlaskyFacade.findPocetByFiltr(ah);
                if (prihlaseno >= ah.getOptimalniPocet()) {
                    ah.setVolno(false);
                } else {
                    ah.setVolno(true);
                }
                akceList.set(i, ah);
            }
            akcePrihlaseni = akceList;
            long celkemZaznamu = akceHlavniFacade.findPocetByNazevPopis(hledanyVyraz.toLowerCase());
            request.setAttribute("pocetZaznamu", celkemZaznamu);
            request.setAttribute("akcePrihlaseni", akcePrihlaseni);
            long pocetStran = celkemZaznamu / zt.getPocetStrana();
            if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                pocetStran++;
            }
            ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
            DvojiceCisloRetez dcr;
            if (zt.getOffset() > 0) {
                dcr = new DvojiceCisloRetez(-1, "Předchozí");
                strany.add(dcr);
            }
            for (int i = zt.getOffset(); i < pocetStran /*
                             * + offset
                     */; i++) {
                if (i < 4 + zt.getOffset()) {
                    dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                    strany.add(dcr);
                }
                if (i >= 4 + zt.getOffset()) {
                    dcr = new DvojiceCisloRetez(-2, "Další");
                    strany.add(dcr);
                    break;
                }
            }
            request.setAttribute("strany", strany);
            session.setAttribute("fulltextSearch", hledanyVyraz);

            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novePrihlaseni.jsp");
            request.setAttribute("selectedCenterId", 10);
            try {
                String url = "/ekcvjs.jsp";
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals(
                "/filtrAkceJs")) {
            zt.setHledanaAkce(request.getParameter("filtrNazevAkce"));

            String akceRadit = "akceCislo ASC";
            if (!zt.getAktualniStranka().equals("js/vzdProgramy.jsp")) {
                zt.vycistit("js/vzdProgramy.jsp");
            }

            zt.setIdOborSkupina(3);

            akceRadit = nastavSort(akceRadit);
            request.setAttribute("sortCislo", sortCislo);
            request.setAttribute("sortNazev", sortNazev);
            request.setAttribute("sortTermin", sortTermin);
            request.setAttribute("sortCena", sortCena);
            request.setAttribute("selectedCenter", "WEB-INF/js/vzdProgramy.jsp");
            request.setAttribute("selectedCenterId", 10);

            ArrayList dotazIn = new ArrayList();
            if (zt.getIdOborSkupina() > 0) {
                ArrayList vybraneOborySkupiny = new ArrayList<OboryVazbySkupiny>();
                OboryVazbySkupiny nulovy = new OboryVazbySkupiny();
                Obory nulovyObor = new Obory();
                nulovyObor.setOborId(0);
                nulovyObor.setNazev("Neurčen");
                nulovy.setObory(nulovyObor);
                vybraneOborySkupiny.add(nulovy);
                vybraneOborySkupiny.addAll(oboryVazbySkupinyFacade.findBySkupinyId(zt.getIdOborSkupina()));
                request.setAttribute("vybraneOborySkupiny", vybraneOborySkupiny);
            }

            dotazIn.add(new DvojiceCisloRetez(zt.getIdObdobi(), "idObdobi"));
            dotazIn.add(new DvojiceCisloRetez(zt.getIdObor(), "idObor"));
            if (zt.getHledanaAkce().isEmpty() == false) {
                dotazIn.add(new DvojiceRetezRetez(zt.getHledanaAkce(), "hledanaAkce"));
            } else {
                dotazIn.add(new DvojiceRetezRetez("", "hledanaAkce"));
            }
            dotazIn.add(new DvojiceCisloRetez(zt.getIdOborSkupina(), "idOborSkupina"));
            request.setAttribute("vybranyOborSkupina", zt.getIdOborSkupina());
            List akceList = akceHlavniFacade.findByFiltr(dotazIn, akceRadit, zt.getPocetStrana(), zt.getOffset());
            for (int i = 0; i < akceList.size(); i++) {
                AkceHlavni ah = (AkceHlavni) akceList.get(i);
                long prihlaseno = prihlaskyFacade.findPocetByFiltr(ah);
                if (prihlaseno >= ah.getOptimalniPocet()) {
                    ah.setVolno(false);
                } else {
                    ah.setVolno(true);
                }
                akceList.set(i, ah);
            }

            long celkemZaznamu = akceHlavniFacade.findPocetByFiltr(dotazIn, akceRadit);
            request.setAttribute("pocetZaznamu", 10);
            request.setAttribute("akcePrihlaseni", akceList);
            long pocetStran = celkemZaznamu / zt.getPocetStrana();
            if (pocetStran * zt.getPocetStrana() < celkemZaznamu) {
                pocetStran++;
            }
            ArrayList<DvojiceCisloRetez> strany = new ArrayList<DvojiceCisloRetez>();
            DvojiceCisloRetez dcr;
            if (zt.getOffset() > 0) {
                dcr = new DvojiceCisloRetez(-1, "Předchozí");
                strany.add(dcr);
            }
            for (int i = zt.getOffset(); i < pocetStran /*
                     * + offset
                     */; i++) {
                if (i < 4 + zt.getOffset()) {
                    dcr = new DvojiceCisloRetez(i, (i + 1) + "");
                    strany.add(dcr);
                }
                if (i >= 4 + zt.getOffset()) {
                    dcr = new DvojiceCisloRetez(-2, "Další");
                    strany.add(dcr);
                    break;
                }
            }
            request.setAttribute("strany", strany);
            try {
                String url = "/js.jsp";

                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String nastavSort(String akceRadit) {
        if (sort == 0) {
            if (sortCislo == 0) {
                sortCislo = 1;
                sortNazev = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "akceCislo DESC";

            } else {
                sortNazev = 0;
                sortCislo = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "akceCislo ASC";
            }
        } else if (sort == 1) {
            if (sortNazev == 0) {
                sortNazev = 1;
                sortCislo = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "nazev DESC";
            } else {
                sortNazev = 0;
                sortCislo = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "nazev ASC";
            }
        } else if (sort == 2) {
            if (sortTermin == 0) {
                sortTermin = 1;
                sortNazev = 0;
                sortCislo = 0;
                sortCena = 0;
                akceRadit = "terminObecny DESC";
            } else {
                sortNazev = 0;
                sortCislo = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "terminObecny ASC";
            }
        } else if (sort == 3) {
            if (sortCena == 0) {
                sortCena = 1;
                sortNazev = 0;
                sortCislo = 0;
                sortTermin = 0;
                akceRadit = "ucastnickyPoplatek DESC";
            } else {
                sortNazev = 0;
                sortCislo = 0;
                sortTermin = 0;
                sortCena = 0;
                akceRadit = "ucastnickyPoplatek ASC";
            }
        }
        return akceRadit;
    }
}
