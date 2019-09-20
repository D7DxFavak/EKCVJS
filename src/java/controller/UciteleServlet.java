/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;
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
import sprava.PripojeniDB;
import sprava.ZobrazeniTabulek;

/**
 *
 * @author Favak
 */
@WebServlet(name = "UciteleServlet", loadOnStartup = 2,
        urlPatterns = {"/ucitele"})
public class UciteleServlet extends HttpServlet {

    @EJB
    private WebKategorieZakladniFacade kategorieFacade;
    @EJB
    private WebAktualityFacade aktualityFacade;
    @EJB
    private AkceHlavniFacade akceHlavniFacade;
    @EJB
    private OsobyFacade osobyPrihlaseni;
    @EJB
    private PrihlaskyRozpisyFacade prihlaskyFacade;
    @EJB
    private OboryVazbySkupinyFacade oboryVazbySkupinyFacade;
    @EJB
    private WebOsOblzarHrubeFacade webOsOblzarHrubeFacade;
    @EJB
    private WebOsOblzarJemneFacade webOsOblzarJemneFacade;
    @EJB
    private WebOsZarazeniFacade webOsZarazeniFacade;
    @EJB
    private WebKontaktyFotoFacade webKontFotoFacade;
    @EJB
    private WebPanelyFacade panelyFacade;
    @EJB
    private WebPanelyDataFacade webPanelyDataFacade;
    @EJB
    private WebPropertiesFacade propertiesFacade;
    @EJB
    private WebLogaFacade webLogaFacade;
    @EJB
    private VazbaWebKategorieUlozisteDataFacade vazbaWebkategorieUlozisteDataFacade;
    @EJB
    private WebGalerieFacade webGalerieFacade;
    @EJB
    private VazbaGalerieUlozisteFacade vazbaGalerieUlozisteFacade;
    @EJB
    private UlozisteDataFacade ulozisteDataFacade;
    @EJB
    private UlozisteDataDruhyFacade ulozisteDataDruhyFacade;
    @EJB
    private UzivateleFacade uzivatelPrihlaseni;
    private int sort = 0;
    private int sortCislo = 0;
    private int sortNazev = 0;
    private int sortTermin = 0;
    private int sortCena = 0;
    private ArrayList<WebOsOblzarHrube> kontaktyOsOzHrube;
    private ArrayList<WebOsOblzarJemne> kontaktyOsOzJemne;
    private ArrayList<WebOsZarazeni> kontaktyOsZarazeni;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String odkazNazev = request.getQueryString();

        getServletContext().setAttribute("aktualitySouhrn", aktualityFacade.findSouhrn());

        Collection<OboryVazbySkupiny> vybraneOborySkupiny;
        Collection<AkceHlavni> akcePrihlaseni;

        HttpSession session = request.getSession();
        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");
        if (zt == null) {
            // getServletContext().removeAttribute("zobrazeniTabulek");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);
        }

        zt.setIdKategorieZakladni(20);
        request.setAttribute("kategorieZakladniPopis", "ucitele");

        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;

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

        boolean forwardRequest = true;

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

        if (request.getParameter("idKontaktOsoba") != null) {
            WebKontaktyFoto wkf = webKontFotoFacade.findByOsoba(osobyPrihlaseni.findPodleId(Integer.valueOf(request.getParameter("idKontaktOsoba")).intValue()));
            if (wkf != null) {
                response.setContentType("image/gif");
                response.setContentLength(wkf.getWebKontaktyFotoData().length);
                response.getOutputStream().write(wkf.getWebKontaktyFotoData());
                forwardRequest = false;
            }
        }

        if (request.getParameter("ulozisteData") != null) {
            WebLoga wl = webLogaFacade.findByUlozisteId(Integer.valueOf(request.getParameter("ulozisteData")).intValue());
            if (wl != null) {
                response.setContentType("image/gif");
                response.setContentLength(wl.getWebLogaUlozisteData().getUlozisteDataData().length);
                response.getOutputStream().write(wl.getWebLogaUlozisteData().getUlozisteDataData());
                forwardRequest = false;
            }
        }

        if (request.getParameter("idFotoGalerie") != null) {
            zt.setPomString(ulozisteDataFacade.findById(Integer.valueOf(request.getParameter("idFotoGalerie")).intValue()).getUlozisteDataPopis());
            zt.setIdUloziste(Integer.valueOf(request.getParameter("idFotoGalerie")).intValue());
        }

        if (request.getParameter("ulozisteDataId") != null) {
            zt.setIdUloziste(Integer.valueOf(request.getParameter("ulozisteDataId")).intValue());
        }

        if (odkazNazev != null) {
            if (odkazNazev.equals("kontakty.jsp")) {
                kontaktyOsOzHrube = null;
                kontaktyOsOzJemne = null;
                kontaktyOsZarazeni = null;
            }
            if (odkazNazev.contains("&")) {
                odkazNazev = odkazNazev.substring(0, odkazNazev.indexOf("&"));
            }
            if (request.getParameter("idAktualita") != null) {
                zt.setIdAktualita(Integer.valueOf(request.getParameter("idAktualita")).intValue());
            } else {
                zt.setIdAktualita(0);
            }
            if (request.getParameter("idOsOzHrube") != null) {
                if (zt.getIdOsOzHruba() == Integer.valueOf(request.getParameter("idOsOzHrube")).intValue()) {
                    zt.setIdOsOzHruba(0);
                } else {
                    zt.setIdOsOzHruba(Integer.valueOf(request.getParameter("idOsOzHrube")).intValue());
                }
            }

            if (odkazNazev.equals("aktuality.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?aktuality.jsp")) {
                    zt.vycistit("ucitele?aktuality.jsp");
                }
                Collection<WebAktuality> aktualitySeznam = aktualityFacade.findByKategorie(20, zt.getPocetStrana(), zt.getOffset());
                request.setAttribute("aktualitySeznam", aktualitySeznam);
                request.setAttribute("selectedCenter", odkazNazev);
                request.setAttribute("idAktualitaDetail", zt.getIdAktualita());
                request.setAttribute("kategorieAktuality", kategorieFacade.findById(20).getWebKategorieZakladniPopis());

            } else if (odkazNazev.equals("galerie.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?galerie.jsp")) {
                    zt.vycistit("ucitele?galerie.jsp");
                }
                Collection<WebGalerieFacade> galerieSeznam = webGalerieFacade.findByKategorie(kategorieFacade.findById(20), zt.getPocetStrana(), zt.getOffset());
                request.setAttribute("galerieSeznam", galerieSeznam);
                request.setAttribute("selectedCenter", odkazNazev);
                request.setAttribute("kategorieGalerie", kategorieFacade.findById(20).getWebKategorieZakladniPopis());

                long celkemZaznamu = webGalerieFacade.findPocetByKategorie(kategorieFacade.findById(20));
                request.setAttribute("pocetZaznamu", 10);
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

            } else if (odkazNazev.equals("galerieDetail.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?galerieDetail.jsp")) {
                    zt.vycistit("ucitele?galerieDetail.jsp");
                }

                if (request.getParameter("idGalerie") != null) {
                    zt.setIdGalerie(Integer.valueOf(request.getParameter("idGalerie")).intValue());
                }

                Long pocetFotek = vazbaGalerieUlozisteFacade.findPocetByGalerie(zt.getIdGalerie());
                if (zt.getOffset() < 0) {
                    zt.setOffset(0);
                }

                if ((zt.getOffset()) > pocetFotek) {
                    zt.setOffset(zt.getOffset() - 1);
                }

                if (zt.getOffset() == pocetFotek) {
                    zt.setOffset(zt.getOffset() - 1);
                }

                List<VazbaGalerieUloziste> fotoSeznam;

                if (zt.getOffset() > 4) {
                   
                    fotoSeznam = vazbaGalerieUlozisteFacade.findByGalerie(zt.getIdGalerie(), 5, zt.getOffset() - 4);
                } else {
                   
                    fotoSeznam = vazbaGalerieUlozisteFacade.findByGalerie(zt.getIdGalerie(), 5, 0);
                }

                //  fotoSeznam = galerieUlozisteFacade.findByGalerie(zt.getIdGalerie(), 5, zt.getOffset());
                if (request.getParameter("idFotoGalerie") == null) {
                    int indexFoto = zt.getOffset();
                    if (indexFoto > 4) {
                        indexFoto = 4;
                    }
                    zt.setIdUloziste(fotoSeznam.get(indexFoto).getVazbaGalerieUlozistePK().getVazbaGalerieUlozisteUloziste());
                    zt.setPomString(fotoSeznam.get(indexFoto).getVazbaGalerieUlozisteUloziste().getUlozisteDataPopis());
                } else {
                    zt.setOffset(Integer.valueOf(request.getParameter("iterIndex")).intValue());
                }

                if ((zt.getIdUloziste() == 0) && fotoSeznam.size() > 0) {
                    zt.setIdUloziste(fotoSeznam.get(0).getVazbaGalerieUlozistePK().getVazbaGalerieUlozisteUloziste());
                    zt.setPomString(fotoSeznam.get(0).getVazbaGalerieUlozisteUloziste().getUlozisteDataPopis());
                }

                request.setAttribute("fotoSeznam", fotoSeznam);
                request.setAttribute("vybranaGalerie", zt.getIdGalerie());
                request.setAttribute("selectedCenter", odkazNazev);
                request.setAttribute("infoGalerie", ((WebGalerie) webGalerieFacade.findById(zt.getIdGalerie())).getWebGalerieNazev());
                request.setAttribute("kategorieGalerie", kategorieFacade.findById(20).getWebKategorieZakladniPopis());

            } /*else if (odkazNazev.equals("ucitele.jsp")) {
             if (!zt.getAktualniStranka().equals("ucitele?ucitele.jsp")) {
             zt.vycistit("ucitele?ucitele.jsp");
             }
             WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(20));
             Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
             request.setAttribute("panelyData", panelyData);
             request.setAttribute("selectedCenter", "WEB-INF/ucitele/zakladniInfo.jsp");
             } else if (odkazNazev.equals("vseobecnepodminky.jsp")) {
             if (!zt.getAktualniStranka().equals("ucitele?vseobecnepodminky.jsp")) {
             zt.vycistit("ucitele?vseobecnepodminky.jsp");
             }
             WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(20));
             Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
             request.setAttribute("panelyData", panelyData);
             request.setAttribute("selectedCenter", "WEB-INF/ucitele/vseobecnepodminky.jsp");
             }*/ else if (odkazNazev.equals("keStazeni.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?keStazeni.jsp")) {
                    zt.vycistit("ucitele?keStazeni.jsp");
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

                //long celkemZaznamu = vazbaWebkategorieUlozisteDataFacade.findPocetByWebKategorieUlozisteData(kategorieFacade.findById(zt.getIdKategorieZakladni()));
                long celkemZaznamu = -1;
                try {

                    ResultSet q = PripojeniDB.dotazS(" SELECT COUNT(uloziste_data_id) "
                            + "FROM uloziste_data "
                            + "CROSS JOIN vazba_web_kategorie_uloziste_data "
                            + "WHERE uloziste_data_druh_id <> 260 "
                            + "AND uloziste_data_id = vazba_web_kategorie_uloziste_data_data_uloziste_id "
                            + "AND vazba_web_kategorie_uloziste_data_web_kategorie_id = " + zt.getIdKategorieZakladni());
                    while (q.next()) {
                        celkemZaznamu = q.getInt(1);
                    }
                    PripojeniDB.rs.close();
                    PripojeniDB.pstmt.close();
                    PripojeniDB.con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

                List<VazbaWebKategorieUlozisteData> resList = vazbaWebkategorieUlozisteDataFacade.findVazbyWebKategorieUlozisteData(kategorieFacade.findById(20), zt, ulozisteDataDruhyFacade.findById(170));
                List<VazbaWebKategorieUlozisteData> resOut = new ArrayList<VazbaWebKategorieUlozisteData>();
                for (int i = 0; i < resList.size(); i++) {
                    if (resList.get(i).getUlozisteData().getUlozisteDataDruhId().getUlozisteDataDruhyId() != 260) {
                        resOut.add(resList.get(i));
                    }
                }
                request.setAttribute("seznamDokumentu", resOut);

                //request.setAttribute("seznamDokumentu", vazbaWebkategorieUlozisteDataFacade.findVazbyWebKategorieUlozisteData(kategorieFacade.findById(20), zt));
            } else if (odkazNazev.equals("reditelePravo.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?reditelePravo.jsp")) {
                    zt.vycistit("ucitele?reditelePravo.jsp");
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
                long celkemZaznamu = -1;
                try {

                    ResultSet q = PripojeniDB.dotazS(" SELECT COUNT(uloziste_data_id) "
                            + "FROM uloziste_data "
                            + "CROSS JOIN vazba_web_kategorie_uloziste_data "
                            + "WHERE uloziste_data_druh_id = 260 "
                            + "AND uloziste_data_id = vazba_web_kategorie_uloziste_data_data_uloziste_id "
                            + "AND vazba_web_kategorie_uloziste_data_web_kategorie_id = " + zt.getIdKategorieZakladni());
                    while (q.next()) {
                        celkemZaznamu = q.getInt(1);
                    }
                    PripojeniDB.rs.close();
                    PripojeniDB.pstmt.close();
                    PripojeniDB.con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // long celkemZaznamu = vazbaWebkategorieUlozisteDataFacade.findPocetByWebKategorieUlozisteData(kategorieFacade.findById(zt.getIdKategorieZakladni()));
                //long celkemZaznamu = vazbaWebkategorieUlozisteDataFacade.findPocetByWebKategorieUlozisteDataByDruh(kategorieFacade.findById(zt.getIdKategorieZakladni()), 260); 
                //vazbaWebkategorieUlozisteDataFacade.findPocetByWebKategorieUlozisteDataByDruh(zt.getIdKategorieZakladni(), ulozisteDataDruhyFacade.findById(260));
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

                List<VazbaWebKategorieUlozisteData> resList = vazbaWebkategorieUlozisteDataFacade.findVazbyWebKategorieUlozisteData(kategorieFacade.findById(20), zt, ulozisteDataDruhyFacade.findById(260));
                List<VazbaWebKategorieUlozisteData> resOut = new ArrayList<VazbaWebKategorieUlozisteData>();
                for (int i = 0; i < resList.size(); i++) {
                    if (resList.get(i).getUlozisteData().getUlozisteDataDruhId().getUlozisteDataDruhyId() == 260) {
                        resOut.add(resList.get(i));
                    }
                }

                request.setAttribute("seznamDokumentu", resOut);

            } else if (odkazNazev.equals("vzdProgramy.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?vzdProgramy.jsp")) {
                    zt.vycistit("ucitele?vzdProgramy.jsp");
                }
                String akceRadit = "akceCislo ASC";
                zt.setIdOborSkupina(4);
                if (request.getParameter("idObor") != null) {
                    zt.setIdObor(Integer.valueOf(request.getParameter("idObor")).intValue());
                }
                if (request.getParameter("idObdobi") != null) {
                    zt.setIdObdobi(Integer.valueOf(request.getParameter("idObdobi")).intValue());
                }
                if (request.getParameter("akceIdDetail") != null) {
                    if (zt.getIdAkce() == Integer.valueOf(request.getParameter("akceIdDetail")).intValue()) {
                        zt.setIdAkce(0);
                    } else {
                        zt.setIdAkce(Integer.valueOf(request.getParameter("akceIdDetail")).intValue());
                    }
                }
                if (request.getParameter("sort") != null) {
                    sort = Integer.valueOf(request.getParameter("sort")).intValue();
                } else {
                    sort = -1;
                }
                akceRadit = nastavSort(akceRadit);
                request.setAttribute("sortCislo", sortCislo);
                request.setAttribute("sortNazev", sortNazev);
                request.setAttribute("sortTermin", sortTermin);
                request.setAttribute("sortCena", sortCena);

                request.setAttribute("selectedCenter", "WEB-INF/ucitele/" + odkazNazev);

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
                }

                dotazIn.add(new DvojiceCisloRetez(zt.getIdObdobi(), "idObdobi"));
                dotazIn.add(new DvojiceCisloRetez(zt.getIdObor(), "idObor"));

                if (zt.getHledanaAkce().isEmpty() == false) {
                    dotazIn.add(new DvojiceRetezRetez(zt.getHledanaAkce(), "hledanaAkce"));
                } else {
                    dotazIn.add(new DvojiceRetezRetez("", "hledanaAkce"));
                }

                dotazIn.add(new DvojiceCisloRetez(zt.getIdOborSkupina(), "idOborSkupina"));

                List akceList = akceHlavniFacade.findByFiltr(dotazIn, akceRadit, zt.getPocetStrana(), zt.getOffset());
                for (int i = 0; i < akceList.size(); i++) {
                    AkceHlavni ah = (AkceHlavni) akceList.get(i);
                    long prihlaseno = prihlaskyFacade.findPocetByFiltr(ah);
                    if (prihlaseno >= ah.getOptimalniPocet()) {
                        ah.setVolno(false);
                    } else {
                        ah.setVolno(true);
                    }
                    if(ah.getStavAkce().getUzavreno() == true) {
                        ah.setVolno(false);
                    }
                    akceList.set(i, ah);
                }
                akcePrihlaseni = akceList;
                long celkemZaznamu = akceHlavniFacade.findPocetByFiltr(dotazIn, akceRadit);
                request.setAttribute("pocetZaznamu", 10);
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

            } else if (odkazNazev.equals("kontakty.jsp")) {
                if (!zt.getAktualniStranka().equals("ucitele?kontakty.jsp")) {
                    zt.vycistit("ucitele?kontakty.jsp");
                    zt.setIdOsOzHruba(20);
                }
                // kontaktyOsOzHrube = new ArrayList<WebOsOblzarHrube>(webOsOblzarHrubeFacade.findAll());
                kontaktyOsOzHrube = new ArrayList<WebOsOblzarHrube>();
                kontaktyOsOzHrube.add(webOsOblzarHrubeFacade.findById(20));
                Collections.sort(kontaktyOsOzHrube, new OblZarHrubeComparator());
                request.setAttribute("osOzHrube", kontaktyOsOzHrube);
                request.setAttribute("aktKategorie", kategorieFacade.findById(20));

                if (zt.getIdOsOzHruba() > 0) {
                    kontaktyOsOzJemne = new ArrayList<WebOsOblzarJemne>();
                    ArrayList<WebOsOblzarJemne> osOzJemnes = new ArrayList<WebOsOblzarJemne>(webOsOblzarJemneFacade.findAll());
                    kontaktyOsZarazeni = new ArrayList<WebOsZarazeni>(webOsZarazeniFacade.findByJemnaZarazeni(osOzJemnes));
                    ArrayList<WebOsOblzarJemne> pomocneJemne = new ArrayList<WebOsOblzarJemne>();
                    for (int i = 0; i < kontaktyOsZarazeni.size(); i++) {
                        pomocneJemne.add(kontaktyOsZarazeni.get(i).getWebOsZarazeniOblzarJemna());
                    }
                    HashSet h = new HashSet(pomocneJemne);
                    osOzJemnes.clear();
                    osOzJemnes.addAll(h);
                    ArrayList<WebOsOblzarHrube> pomocneHrube = new ArrayList<WebOsOblzarHrube>();
                    kontaktyOsOzJemne.clear();
                    // kontaktyOsOzHrube.clear();
                    for (int i = 0; i < osOzJemnes.size(); i++) {
                        pomocneHrube.add(osOzJemnes.get(i).getWebOblzarHrubeId());
                        if (osOzJemnes.get(i).getWebOblzarHrubeId().getWebOblzarHrubeId() == zt.getIdOsOzHruba()) {
                            kontaktyOsOzJemne.add(osOzJemnes.get(i));
                        }                                             
                    }
                    // h = new HashSet(pomocneHrube);

                    // kontaktyOsOzHrube.addAll(h);
                    Collections.sort(kontaktyOsOzJemne, new OblZarJemneComparator());
                    // Collections.sort(kontaktyOsOzHrube, new OblZarHrubeComparator());

                    request.setAttribute("osOzHrube", kontaktyOsOzHrube);

                    request.setAttribute("osOzHruba", webOsOblzarHrubeFacade.findById(zt.getIdOsOzHruba()));
                    request.setAttribute("osOzJemne", kontaktyOsOzJemne);
                    request.setAttribute("kontaktyVybrane", kontaktyOsZarazeni);

                }

                request.setAttribute("selectedCenter", odkazNazev);

            } else {
                if ((odkazNazev.contains("ulozisteData") == false) && (odkazNazev.contains("galerieUvodni") == false)
                        && (odkazNazev.contains("idKontaktOsoba") == false)) {                   
                    if (!zt.getAktualniStranka().equals("ucitele?" + odkazNazev)) {
                        zt.vycistit("ucitele?" + odkazNazev);
                    }
                    WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(zt.getIdKategorieZakladni()));
                    Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                    request.setAttribute("panelNazev", wp.getWebPanelyNazev());
                    request.setAttribute("panelOdkaz", wp.getWebPanelyOdkaz());
                    request.setAttribute("panelyData", panelyData);
                    request.setAttribute("selectedCenter", "statickeInfo.jsp");
                }
            }
        } else {
            request.setAttribute("selectedCenterId", 0);
        }

        if (forwardRequest
                == true) {
            try {
                request.getRequestDispatcher(userPath + ".jsp").forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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

    public class OblZarHrubeComparator implements Comparator<WebOsOblzarHrube> {

        @Override
        public int compare(WebOsOblzarHrube o1, WebOsOblzarHrube o2) {
            return o1.getWebPoradiVyber().compareTo(o2.getWebPoradiVyber());
        }
    }

    public class OblZarJemneComparator implements Comparator<WebOsOblzarJemne> {

        @Override
        public int compare(WebOsOblzarJemne o1, WebOsOblzarJemne o2) {
            return o1.getWebPoradiVyber().compareTo(o2.getWebPoradiVyber());
        }
    }
}
