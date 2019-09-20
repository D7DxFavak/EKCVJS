/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import entity.*;
import java.io.IOException;
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
import sprava.ZobrazeniTabulek;

/**
 *
 * @author Favak
 */
@WebServlet(name = "IndexServlet", loadOnStartup = 2,
        urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    @EJB
    private WebKategorieZakladniFacade kategorieFacade;
    @EJB
    private WebAktualityFacade aktualityFacade;
    @EJB
    private AkceHlavniFacade akceHlavniFacade;
    @EJB
    private OsobyFacade osobyPrihlaseni;
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
    private VazbaWebKategorieUlozisteDataFacade vazbaWebkategorieUlozisteDataFacade;
    @EJB
    private UlozisteDataFacade ulozisteDataFacade;
    @EJB
    private UzivateleFacade uzivatelPrihlaseni;
    @EJB
    private WebOrgOsFacade webOrgOsFacade;
    @EJB
    private VazbaGalerieUlozisteFacade galerieUlozisteFacade;
    @EJB
    private WebGalerieFacade webGalerieFacade;
    @EJB
    private KatOrgTypyFacade katOrgTypyfacade;
    @EJB
    private PrihlaskyRozpisyFacade prihlaskyFacade;
    @EJB
    private KatOrgPolozkyFacade katOrgPolozkyfacade;
    @EJB
    private OboryVazbySkupinyFacade oboryVazbySkupinyFacade;
    private ArrayList<WebOsOblzarHrube> kontaktyOsOzHrube;
    private ArrayList<WebOsOblzarJemne> kontaktyOsOzJemne;
    private ArrayList<WebOsZarazeni> kontaktyOsZarazeni;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String odkazNazev = request.getQueryString();
        boolean forwardRequest = true;

        getServletContext().setAttribute("aktualitySouhrn", aktualityFacade.findSouhrn());

        HttpSession session = request.getSession();

        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;

        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");
        if (zt == null) {
            //getServletContext().removeAttribute("zobrazeniTabulek.webProp");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);
        }
        

        zt.setIdKategorieZakladni(10);
        request.setAttribute("kategorieZakladniPopis", "index");

        if (request.getRemoteUser() != null) {
            if (request.getAttribute("uzivatelePrihlaseni") == null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                request.setAttribute("uzivatelePrihlaseni", uzR);
            }
            if (request.getAttribute("klientPrihlaseni") == null) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    orgR = uzR.getUzivateleOrganizaceId();
                    request.setAttribute("klientPrihlaseni", orgR);
                    session.setAttribute("typKlient", 2); //2 - pro organizaci
                } else if (uzR.getUzivateleOsobyId() != null) {
                    klientR = uzR.getUzivateleOsobyId();
                    request.setAttribute("klientPrihlaseni", klientR);
                    session.setAttribute("typKlient", 1); //1 - pro osobu
                } else {
                    session.setAttribute("typKlient", 0); //0 - pro nic
                }
            } else {
                session.setAttribute("typKlient", 0); //0 - pro nic
            }
        } else {
            session.setAttribute("typKlient", 0); //0 - pro nic
        }

        if (odkazNazev.equals("preRegistrace.jsp")) {
            String url = "/index.jsp";
            request.setAttribute("selectedCenter", "preRegistrace.jsp");

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        
        
        else if (session.getAttribute("odkazStranaLogin") != null && !odkazNazev.equals("registrace.jsp")) {
            
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            String url = "/ekcvjs?ekcvjs.jsp";
            session.removeAttribute("odkazStranaLogin");
            if (orgR != null) {
                request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/prihlasitOsoby.jsp");
                request.setAttribute("selectedCenterId", 10);
                String akceId = zt.getIdAkce() + "";
                if (!akceId.isEmpty()) {
                    session.setAttribute("akceObjednavka", akceId);
                }

            } else if (klientR != null) {
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }
                String akceId = zt.getIdAkce() + "";
                if (!akceId.isEmpty()) {

                    AkceHlavni product = akceHlavniFacade.find(Integer.parseInt(akceId));
                    cart.addItem(product);
                }
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/cart.jsp");
                WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
                Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                request.setAttribute("panelyData", panelyData);
                request.setAttribute("selectedCenterId", 10);

            }

            if (odkazNazev.equals("registrace.jsp")) {
                
                if (!zt.getAktualniStranka().equals("index?registrace.jsp")) {
                    zt.vycistit("index?registrace.jsp");
                }
                if (zt.getDruhUzivatel() == 0) {
                    zt.setDruhUzivatel(1);
                }

                if (request.getParameter("idTypOrg") != null) {
                    zt.setKatOrgTyp(Integer.valueOf(request.getParameter("idTypOrg")).intValue());
                }
                if (request.getParameter("idDruhOrg") != null) {
                    zt.setKatOrgDruh(Integer.valueOf(request.getParameter("idDruhOrg")).intValue());
                }
                String[] typOrg = request.getParameterValues("vyberTypOrg");
                if (typOrg != null) {
                    orgR.setKatorgtyp(katOrgTypyfacade.findById(zt.getKatOrgTyp()));
                }

                String[] druhOrg = request.getParameterValues("vyberTypOrgPol");
                if (druhOrg != null) {
                    orgR.setKatOrgPolozky(katOrgPolozkyfacade.findById(zt.getKatOrgTyp(), zt.getKatOrgDruh()));
                }
                request.setAttribute("vyberKatOrgTyp", zt.getKatOrgTyp());
                request.setAttribute("vyberKatOrgDruh", zt.getKatOrgDruh());
                request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                request.setAttribute("selectedCenter", "registrace.jsp");
            }
            
            try {

                request.getRequestDispatcher(url).forward(request, response); //BYLO
                //request.getRequestDispatcher(userPath + ".jsp").forward(request, response);
                //response.sendRedirect("http://www.seznam.cz");
                //response.sendRedirect(getServletContext().getContextPath() + url);
                //response.flushBuffer();
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
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

            if (request.getParameter("idOsOzHrube") != null) {
                if (zt.getIdOsOzHruba() == Integer.valueOf(request.getParameter("idOsOzHrube")).intValue()) {
                    zt.setIdOsOzHruba(0);
                } else {
                    zt.setIdOsOzHruba(Integer.valueOf(request.getParameter("idOsOzHrube")).intValue());
                }
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

            if (request.getParameter("idFotoGalerie") != null) {
                zt.setPomString(ulozisteDataFacade.findById(Integer.valueOf(request.getParameter("idFotoGalerie")).intValue()).getUlozisteDataPopis());
                zt.setIdUloziste(Integer.valueOf(request.getParameter("idFotoGalerie")).intValue());
            }

            if (request.getParameter("ulozisteDataId") != null) {
                zt.setIdUloziste(Integer.valueOf(request.getParameter("ulozisteDataId")).intValue());
            }

            if (request.getParameter("ulozisteData") != null) {
                UlozisteData wl = ulozisteDataFacade.findById(Integer.valueOf(request.getParameter("ulozisteData")).intValue());
                if (wl != null) {
                    response.setContentType("image/gif");
                    response.setContentLength(wl.getUlozisteDataData().length);
                    response.getOutputStream().write(wl.getUlozisteDataData());
                    forwardRequest = false;
                }
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
            if (request.getParameter("akceIdDetail") != null) {
                if (zt.getIdAkce() == Integer.valueOf(request.getParameter("akceIdDetail")).intValue()) {
                    zt.setIdAkce(0);
                } else {
                    zt.setIdAkce(Integer.valueOf(request.getParameter("akceIdDetail")).intValue());
                }
            }

            if (request.getParameter("galerieUvodni") != null) {
                VazbaGalerieUloziste vgu = galerieUlozisteFacade.findUvodniByGalerie(Integer.valueOf(request.getParameter("galerieUvodni")).intValue());

                UlozisteData wl = ulozisteDataFacade.findById(vgu.getVazbaGalerieUlozisteNahled().getUlozisteDataId());
                if (wl != null) {
                    response.setContentType("image/gif");

                    response.setContentLength(wl.getUlozisteDataData().length);
                    response.getOutputStream().write(wl.getUlozisteDataData());
                    forwardRequest = false;
                }
            }

            if (request.getParameter("idDruhUzivatel") != null) {
                zt.setDruhUzivatel(Integer.valueOf(request.getParameter("idDruhUzivatel")).intValue());
            }
            //boolean nactiKontakty = true;

            request.setCharacterEncoding("UTF-8");

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

                if (odkazNazev.equals("aktualita.jsp")) {
                    if (request.getParameter("idAktualita") != null) {
                        zt.setIdAktualita(Integer.valueOf(request.getParameter("idAktualita")).intValue());
                        WebAktuality wak = aktualityFacade.findById(zt.getIdAktualita());
                        request.setAttribute("vyberAktualita", wak);
                        request.setAttribute("selectedCenter", odkazNazev);
                    } else {
                        request.setAttribute("selectedCenter", "WEB-INF/index/" + odkazNazev);
                    }
                } else if (odkazNazev.equals("galerie.jsp")) {

                    if (!zt.getAktualniStranka().equals("index?galerie.jsp")) {
                        zt.vycistit("index?galerie.jsp");
                    }
                    Collection<WebGalerieFacade> galerieSeznam = webGalerieFacade.findAll(zt.getPocetStrana(), zt.getOffset());
                    request.setAttribute("galerieSeznam", galerieSeznam);
                    request.setAttribute("selectedCenter", odkazNazev);
                    request.setAttribute("kategorieGalerie", kategorieFacade.findById(zt.getIdKategorieZakladni()).getWebKategorieZakladniPopis());

                    long celkemZaznamu = webGalerieFacade.findPocetAll();
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
                    if (!zt.getAktualniStranka().equals("index?galerieDetail.jsp")) {
                        zt.vycistit("index?galerieDetail.jsp");
                    }

                    if (request.getParameter("idGalerie") != null) {
                        zt.setIdGalerie(Integer.valueOf(request.getParameter("idGalerie")).intValue());
                    }

                    Long pocetFotek = galerieUlozisteFacade.findPocetByGalerie(zt.getIdGalerie());
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
                        fotoSeznam = galerieUlozisteFacade.findByGalerie(zt.getIdGalerie(), 5, zt.getOffset() - 4);
                    } else {
                        fotoSeznam = galerieUlozisteFacade.findByGalerie(zt.getIdGalerie(), 5, 0);
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
                    request.setAttribute("kategorieGalerie", kategorieFacade.findById(zt.getIdKategorieZakladni()).getWebKategorieZakladniPopis());

                } /*
                 * else if (odkazNazev.equals("produkce.jsp")) { if
                 * (!zt.getAktualniStranka().equals("index?produkce.jsp")) {
                 * zt.vycistit("index?produkce.jsp"); } WebPanely wp =
                 * panelyFacade.findByOdkazKategorie(odkazNazev,
                 * kategorieFacade.findById(10)); Collection<WebPanelyData>
                 * panelyData = webPanelyDataFacade.findByStranka(wp);
                 * request.setAttribute("panelyData", panelyData);
                 * request.setAttribute("selectedCenter",
                 * "WEB-INF/index/produkce.jsp"); //
                 * request.setAttribute("idAktualitaDetail",
                 * zt.getIdAktualita()); }
                 */ else if (odkazNazev.equals("registrace.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?registrace.jsp")) {
                        zt.vycistit("index?registrace.jsp");
                    }
                    if (zt.getDruhUzivatel() == 0) {
                        zt.setDruhUzivatel(1);
                    }

                    if (request.getParameter("idTypOrg") != null) {
                        zt.setKatOrgTyp(Integer.valueOf(request.getParameter("idTypOrg")).intValue());
                    }
                    if (request.getParameter("idDruhOrg") != null) {
                        zt.setKatOrgDruh(Integer.valueOf(request.getParameter("idDruhOrg")).intValue());
                    }
                    String[] typOrg = request.getParameterValues("vyberTypOrg");
                    if (typOrg != null) {
                        orgR.setKatorgtyp(katOrgTypyfacade.findById(zt.getKatOrgTyp()));
                    }

                    String[] druhOrg = request.getParameterValues("vyberTypOrgPol");
                    if (druhOrg != null) {
                        orgR.setKatOrgPolozky(katOrgPolozkyfacade.findById(zt.getKatOrgTyp(), zt.getKatOrgDruh()));
                    }
                    request.setAttribute("vyberKatOrgTyp", zt.getKatOrgTyp());
                    request.setAttribute("vyberKatOrgDruh", zt.getKatOrgDruh());
                    request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                    request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                    request.setAttribute("selectedCenter", "registrace.jsp");
                } /*
                 * else if (odkazNazev.equals("projekty.jsp")) { if
                 * (!zt.getAktualniStranka().equals("index?projekty.jsp")) {
                 * zt.vycistit("index?projekty.jsp"); } WebPanely wp =
                 * panelyFacade.findByOdkazKategorie(odkazNazev,
                 * kategorieFacade.findById(10)); Collection<WebPanelyData>
                 * panelyData = webPanelyDataFacade.findByStranka(wp);
                 * request.setAttribute("panelyData", panelyData);
                 * request.setAttribute("selectedCenter",
                 * "WEB-INF/index/projekty.jsp"); //
                 * request.setAttribute("idAktualitaDetail",
                 * zt.getIdAktualita()); }
                 */ else if (odkazNazev.equals("organizaceInfo.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?organizaceInfo.jsp")) {
                        zt.vycistit("index?organizaceInfo.jsp");
                    }
                    WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(zt.getIdKategorieZakladni()));
                    Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                    request.setAttribute("panelyData", panelyData);
                    request.setAttribute("selectedCenter", "WEB-INF/index/organizaceInfo.jsp");
                } else if (odkazNazev.equals("potvrzeniRegistraceOrg.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?potvrzeniRegistraceOrg.jsp")) {
                        zt.vycistit("index?potvrzeniRegistraceOrg.jsp");
                    }
                    WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(70));
                    Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                    request.setAttribute("panelyData", panelyData);
                    request.setAttribute("selectedCenter", "potvrzeniRegistraceOrg.jsp");
                } else if (odkazNazev.equals("loginRegistrace.jsp")) {
                    request.setAttribute("selectedCenter", "admin/login.jsp");
                } else if (odkazNazev.equals("errorLogin.jsp")) {
                    request.setAttribute("selectedCenter", "admin/error.jsp");
                } else if (odkazNazev.equals("akceHlavni.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?akceHlavni.jsp")) {
                        zt.vycistit("index?akceHlavni.jsp");
                    }
                    if (request.getParameter("idAkce") != null) {
                        int idAkce = Integer.valueOf(request.getParameter("idAkce")).intValue();
                        AkceHlavni ah = akceHlavniFacade.findById(idAkce);
                        request.setAttribute("vyberAkce", ah);
                        request.setAttribute("selectedCenter", odkazNazev);
                    } else {
                        request.setAttribute("selectedCenter", "WEB-INF/index/" + odkazNazev);
                    }
                } else if (odkazNazev.equals("hledani.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?hledani.jsp")) {
                        zt.vycistit("index?hledani.jsp");
                    }
                    String hledanyVyraz;

                    if (request.getParameter("hledanyVyraz") != null) {
                        hledanyVyraz = request.getParameter("hledanyVyraz");
                        request.setAttribute("hledanyVyraz", hledanyVyraz);
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

                    long pocetStran = zt.getArTr().size() / zt.getPocetStrana();
                    if (pocetStran * zt.getPocetStrana() < zt.getArTr().size()) {
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

                    request.setAttribute("pocetZaznamuHledani", zt.getArTr().size());

                    if (zt.getArTr().size() >= zt.getOffset() * zt.getPocetStrana()) {
                        if (zt.getArTr().size() > zt.getOffset() * zt.getPocetStrana() + zt.getPocetStrana()) {
                            request.setAttribute("hledanaData", zt.getArTr().subList(zt.getOffset() * zt.getPocetStrana(), zt.getOffset() * zt.getPocetStrana() + zt.getPocetStrana()));
                        } else {
                            request.setAttribute("hledanaData", zt.getArTr().subList(zt.getOffset() * zt.getPocetStrana(), zt.getArTr().size()));
                        }
                    } else {
                        //return arTr;
                    }
                    request.setAttribute("selectedCenter", odkazNazev);
                } else if (odkazNazev.equals("aktuality.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?aktuality.jsp")) {
                        zt.vycistit("index?aktuality.jsp");
                    }
                    Collection<WebAktuality> aktualitySeznam = aktualityFacade.findByKategorie(zt.getIdKategorieZakladni(), zt.getPocetStrana(), zt.getOffset());
                    request.setAttribute("aktualitySeznam", aktualitySeznam);
                    request.setAttribute("selectedCenter", odkazNazev);
                    request.setAttribute("idAktualitaDetail", zt.getIdAktualita());
                    request.setAttribute("kategorieAktuality", kategorieFacade.findById(zt.getIdKategorieZakladni()).getWebKategorieZakladniPopis());

                } else if (odkazNazev.equals("kontakty.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?kontakty.jsp")) {
                        zt.vycistit("index?kontakty.jsp");
                        zt.setIdOsOzHruba(10);
                    }
                    kontaktyOsOzHrube = new ArrayList<WebOsOblzarHrube>(webOsOblzarHrubeFacade.findAll());

                    Collections.sort(kontaktyOsOzHrube, new OblZarHrubeComparator());
                    request.setAttribute("osOzHrube", kontaktyOsOzHrube);
                    request.setAttribute("aktKategorie", kategorieFacade.findById(zt.getIdKategorieZakladni()));
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
                        kontaktyOsOzHrube.clear();
                        for (int i = 0; i < osOzJemnes.size(); i++) {
                            pomocneHrube.add(osOzJemnes.get(i).getWebOblzarHrubeId());
                            if (osOzJemnes.get(i).getWebOblzarHrubeId().getWebOblzarHrubeId() == zt.getIdOsOzHruba()) {
                                kontaktyOsOzJemne.add(osOzJemnes.get(i));
                            }                                             
                        }
                        h = new HashSet(pomocneHrube);

                        kontaktyOsOzHrube.addAll(h);
                        Collections.sort(kontaktyOsOzJemne, new OblZarJemneComparator());
                        Collections.sort(kontaktyOsOzHrube, new OblZarHrubeComparator());
                        request.setAttribute("osOzHrube", kontaktyOsOzHrube);

                        request.setAttribute("osOzHruba", webOsOblzarHrubeFacade.findById(zt.getIdOsOzHruba()));
                        request.setAttribute("osOzJemne", kontaktyOsOzJemne);
                        request.setAttribute("kontaktyVybrane", kontaktyOsZarazeni);

                    }
                    request.setAttribute("selectedCenter", odkazNazev);
                } else if (odkazNazev.equals("index.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?index.jsp")) {
                        zt.vycistit("index?index.jsp");
                    }
                    request.setAttribute("selectedCenter", "zakladniInfo.jsp");
                } else if (odkazNazev.equals("keStazeni.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?" + odkazNazev)) {
                        zt.vycistit("index?" + odkazNazev);
                        zt.setPocetStrana(20);
                    }

                    WebPanely wp = panelyFacade.findByOdkazKategorie(odkazNazev, kategorieFacade.findById(zt.getIdKategorieZakladni()));
                    Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                    request.setAttribute("panelNazev", wp.getWebPanelyNazev());
                    request.setAttribute("panelOdkaz", wp.getWebPanelyOdkaz());
                    request.setAttribute("panelyData", panelyData);
                    request.setAttribute("selectedCenter", odkazNazev);

                    if (!zt.getAktualniStranka().equals("index?keStazeni.jsp")) {
                        zt.vycistit("index?keStazeni.jsp");
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

                    request.setAttribute("seznamDokumentu", vazbaWebkategorieUlozisteDataFacade.findVazbyWebKategorieUlozisteData(kategorieFacade.findById(zt.getIdKategorieZakladni()), zt));

                } else if (odkazNazev.equals("vzdProgramy.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?vzdProgramy.jsp")) {
                        zt.vycistit("index?vzdProgramy.jsp");
                    }

                    Collection<OboryVazbySkupiny> vybraneOborySkupiny;
                    String akceRadit = "akceCislo ASC";
                    Collection<AkceHlavni> akcePrihlaseni;
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

                    if (request.getParameter("akceIdDetail") != null) {
                        zt.setHledanaAkce(akceHlavniFacade.findById(Integer.valueOf(request.getParameter("akceIdDetail")).intValue()).getNazev());
                    }

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
                        if (ah.getStavAkce().getUzavreno() == true) {
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
                    request.setAttribute("selectedCenter", "WEB-INF/index/" + odkazNazev);
                    request.setAttribute("strany", strany);
                } else if (odkazNazev.equals("vzdProgram.jsp")) {
                    if (!zt.getAktualniStranka().equals("index?vzdProgram.jsp")) {
                        zt.vycistit("index?vzdProgram.jsp");
                    }

                    Collection<OboryVazbySkupiny> vybraneOborySkupiny;
                    String akceRadit = "akceCislo ASC";
                    Collection<AkceHlavni> akcePrihlaseni;
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

                    request.setAttribute("vybranyOborSkupina", zt.getIdOborSkupina());
                    List akceList = new ArrayList<AkceHlavni>();
                    if (request.getParameter("akceIdDetail") != null) {
                        akceList.add(akceHlavniFacade.findById(Integer.valueOf(request.getParameter("akceIdDetail")).intValue()));
                        zt.setIdAkce(Integer.valueOf(request.getParameter("akceIdDetail")).intValue());
                    }
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
                    long celkemZaznamu = 1;
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
                    request.setAttribute("selectedCenter", "WEB-INF/index/vzdProgramy.jsp");
                    request.setAttribute("strany", strany);
                } else {
                    if ((odkazNazev.contains("ulozisteData") == false) && (odkazNazev.contains("galerieUvodni") == false)
                            && (odkazNazev.contains("idKontaktOsoba") == false)) {

                        if (!zt.getAktualniStranka().equals("index?" + odkazNazev)) {
                            zt.vycistit("index?" + odkazNazev);
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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
