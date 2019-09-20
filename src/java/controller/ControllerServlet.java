/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;

import cart.ShoppingCartItem;
import entity.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AkceHlavniFacade;
import session.*;
import sprava.*;

/**
 *
 * @author tgiunipero
 */
@WebServlet(name = "Controller",
        loadOnStartup = 1,
        urlPatterns = {"/category",
            "/pridatDoKosiku",
            "/tempKosik",
            "/viewCart",
            "/updateCart",
            "/checkout",
            "/checkoutOs",
            "/purchase",
            "/prihlasitIndex",
            "/hledani",
            "/filtrAkceDvpp",
            "/filtrAkceJs",
            "/filtrAkcedvppvpk",
            "/filtrAkceUcitele",
            "/detaily",
            "/potvrzeni",
            "/potvrzeniOsOrg",
            "/potvrzeniOrg",
            "/potvrzeniOsoby",
            "/novaOsobaOrg",
            "/potvrzeniUdajeOs",
            "/potvrzeniUdajeOrg",
            "/pridatDoZamestnancu",
            "/potvrditPrihlaseniOsoba",
            "/odebratLidizKosiku",
            "/odebratAkcezKosiku",
            "/upravitOsobu",
            "/odebratZeZamestnancu",
            "/organizaceUdaje",
            "/prihlaseni",
            "/registrace",
            "/preRegistrace",
            "/registraceZakZastupce",
            "/zmenaHesla",
            "/potvrzeniRegistrace",
            "/kontakty",
            "/poslatHeslo",
            "/chooseLanguage",
            "/najitZamestnavatele",
            "/registrovatZamestnavatele",
            "/souhlasGDPR",
            "/pridatZamestnance"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private WebKategorieDetailyFacade kategorieDetailyFacade;
    @EJB
    private WebAktualityFacade aktualityFacade;
    @EJB
    private AkceHlavniFacade akceHlavniFacade;
    @EJB
    private OsobyFacade osobyPrihlaseni;
    @EJB
    private OsobyDalsiKontaktyFacade osobyZakZastupceFacade;
    @EJB
    private OrganizaceFacade organizacePrihlaseni;
    @EJB
    private RegionyOkresyFacade regionyOkresyFacade;
    @EJB
    private UzivateleFacade uzivatelPrihlaseni;
    @EJB
    private WebPanelyFacade panelyFacade;
    @EJB
    private PrihlaskyRozpisyFacade prihlaskyFacade;
    @EJB
    private PrihlaskyRozpisyJsFacade prihlaskyJSFacade;
    @EJB
    private OborySkupinyFacade oborySkupinyFacade;
    @EJB
    private OboryVazbySkupinyFacade oboryVazbySkupinyFacade;
    @EJB
    private ObdobiFacade obdobiFacade;
    @EJB
    private WebPropertiesFacade propertiesFacade;
    @EJB
    private WebOsZarazeniFacade webOsZarazeniFacade;
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
    private WebLogaFacade webLogaFacade;
    @EJB
    private WebMainPageFacade webMainPageFacade;
    @EJB
    private VazbaOsobyLoginFacade vazbaOsobyLoginFacade;
    @EJB
    private WebKategorieZakladniFacade kategorieFacade;
    @EJB
    private StatniPrislusnostFacade statniPrislusnostFacade;
    @EJB
    private NarodnostFacade narodnostFacade;
    @EJB
    private DruhyPrihlasekFacade druhyPrihlasekFacade;
    @EJB
    private DruhyFakturFacade druhyFakturFacade;
    @EJB
    private VyberPrihlaskyJsFakturaceFacade vyberPrihlJSFaktFacade;
    @EJB
    private VyberPrihlaskyFakturaceFacade vyberPrihlFaktFacade;
    @EJB
    private KnihaFakturFacade knihaFakturFacade;
    private int sort = 0;
    private int sortCislo = 0;
    private int sortNazev = 0;
    private int sortTermin = 0;
    private int sortCena = 0;
    //private Resource webProp; 

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        List<WebProperties> wp = propertiesFacade.findAll();
        ZobrazeniTabulek zt = new ZobrazeniTabulek(wp);

        getServletContext().setAttribute("categoriesDetail", kategorieDetailyFacade.findAll());
        getServletContext().setAttribute("aktualitySouhrn", aktualityFacade.findSouhrn());
        getServletContext().setAttribute("panelyHomeData", panelyFacade.findByZalozka("home"));
        getServletContext().setAttribute("panelyDvppvpkData", panelyFacade.findByZalozka("dvppvpk"));
        getServletContext().setAttribute("panelyDvppData", panelyFacade.findByZalozka("dvpp"));
        getServletContext().setAttribute("panelyEkcvjsData", panelyFacade.findByZalozka("ekcvjs"));
        getServletContext().setAttribute("panelyJsData", panelyFacade.findByZalozka("js"));
        getServletContext().setAttribute("panelyUciteleData", panelyFacade.findByZalozka("ucitele"));
        getServletContext().setAttribute("panelyOstatniData", panelyFacade.findByZalozka("ostatni"));
        getServletContext().setAttribute("panelyProjektyData", panelyFacade.findByZalozka("projekty"));
        getServletContext().setAttribute("ekcvjsPanelyData", webPanelyDataFacade.findByStranka(panelyFacade.findByOdkazKategorie("ekcvjs.jsp", kategorieFacade.findById(50))));
        getServletContext().setAttribute("oborySkupiny", oborySkupinyFacade.findWeb());
        getServletContext().setAttribute("obdobiSet", obdobiFacade.findWeb());
        getServletContext().setAttribute("webLogaPrave", webLogaFacade.findByWebLogaUlozisteDruh(180));
        getServletContext().setAttribute("webLogaHlavni", webLogaFacade.findByWebLogaUlozisteDruh(190));
        getServletContext().setAttribute("mainPagePolozky", webMainPageFacade.findByPoradiVyber());
        getServletContext().setAttribute("druhyPrihlOrg", druhyPrihlasekFacade.findProOrganizace());
        getServletContext().setAttribute("narodnosti", narodnostFacade.findAllOrderPoradi());
        getServletContext().setAttribute("statPrislusnosti", statniPrislusnostFacade.findAllOrderPoradi());

        getServletContext().setAttribute("pocetStrana", 10);
        getServletContext().setAttribute("offset", 0);
        //   getServletContext().setAttribute("webProp", webProp);
        getServletContext().setAttribute("zobrazeniTabulek", zt);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Osoby klient;
        Organizace klientOrg;

        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");
        if (zt == null) {
            //getServletContext().removeAttribute("zobrazeniTabulek");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);

        }
        Uzivatele uzR = null;
        if (request.getRemoteUser() != null) {
            uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
            if (uzR.getUzivateleOrganizaceId() != null) {
                request.setAttribute("typKlient", 2); //2 - pro organizaci               
            } else if (uzR.getUzivateleOsobyId() != null) {
                request.setAttribute("typKlient", 1); //1 - pro osobu
            } else {
                request.setAttribute("typKlient", 0); //0 - pro nic
            }
        } else {
            request.setAttribute("typKlient", 0); //0 - pro nic
        }

        getServletContext().setAttribute("aktualitySouhrn", aktualityFacade.findSouhrn());

        if (userPath.equals("/detaily")) {
            String odkazNazev = request.getQueryString();
            if (odkazNazev != null) {
                request.setAttribute("selectedCenter", odkazNazev);
            }
            userPath = "/category";
            // if cart page is requested       
        } else if (userPath.equals("/viewCart")) {
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
                e.printStackTrace();
            }

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
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
        } else if (userPath.equals("/checkout")) {
            zpracujCheckout(request, response);
            return;
            // forward to checkout page and switch to a secure channel

        } else if (userPath.equals("/checkoutOs")) {
            String odkazNazev = request.getQueryString();

            if (request.getParameter("idOrganizace") != null) {
                klientOrg = organizacePrihlaseni.findPodleId(Integer.valueOf(request.getParameter("idOrganizace")));
                session.setAttribute("organizaceFakturace", klientOrg);
                zpracujCheckoutOrg(request, response);
            } else {
                zpracujCheckout(request, response);
            }

            return;
            // forward to checkout page and switch to a secure channel

        } else if (userPath.equals("/chooseLanguage")) {
            // get language choice
            String language = request.getParameter("language");
            // place in request scope
            request.setAttribute("language", language);
            zt.getWebProp().setLang(language);
            String userView = (String) session.getAttribute("view");

            try {

                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;

        } else if (userPath.equals("/prihlaseni")) {
            Uzivatele uz = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());

            if (uz.getUzivateleOsobyId() != null) {
                klient = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser()).getUzivateleOsobyId();

                request.setAttribute("klient", klient);
            } else if (uz.getUzivateleOrganizaceId() != null) {
                klientOrg = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser()).getUzivateleOrganizaceId();

                request.setAttribute("klient", klientOrg);
            }

            userPath = "/index.jsp";

            try {
                request.getRequestDispatcher(userPath).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void zpracujCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        String odkazNazev = request.getQueryString();
        HttpSession session = request.getSession();

        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;

        int idOrgVybrane = 0;

        // get categoryId from request
        if (request.getRemoteUser() != null) {
            if (request.getAttribute("uzivatelePrihlaseni") == null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                request.setAttribute("uzivatelePrihlaseni", uzR);
            }

            if (request.getAttribute("klientPrihlaseni") == null) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    orgR = uzR.getUzivateleOrganizaceId();
                    request.setAttribute("klientPrihlaseni", orgR);
                    request.setAttribute("selectedCenter", "WEB-INF/view/checkoutOrg.jsp");
                    request.setAttribute("typKlient", 2); //2 - pro organizaci
                } else if (uzR.getUzivateleOsobyId() != null) {
                    klientR = uzR.getUzivateleOsobyId();
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("selectedCenter", "WEB-INF/view/checkoutOs.jsp");
                    request.setAttribute("typKlient", 1); //1 - pro osobu
                    ArrayList<WebOrgOs> zamestnavateleOrgOs = new ArrayList(webOrgOsFacade.findByOsoba(klientR.getOsobaId()));
                    if (idOrgVybrane > 0) {
                        request.setAttribute("vybranyZam", organizacePrihlaseni.findPodleId(idOrgVybrane));
                    } else {
                        if (zamestnavateleOrgOs.size() > 0) {
                            request.setAttribute("vybranyZam", zamestnavateleOrgOs.get(0).getWebOrgOsOrganizace());
                        }
                    }
                    request.setAttribute("zamestnavatele", zamestnavateleOrgOs);

                    boolean bCartWarn = false;
                    ShoppingCart cartWarn = (ShoppingCart) session.getAttribute("cart");
                    for (ShoppingCartItem sci : cartWarn.getItems()) {

                        OboryVazbySkupiny ovs = sci.getProduct().getPrimObor().getOboryVazbySkupinyCollection().iterator().next();

                        if (ovs.getOborySkupiny().getOborySkupinyId() == 4) {
                            bCartWarn = true;
                        }
                    }

                    if (bCartWarn) {
                        request.setAttribute("fakturaWarn", "warnIndivDVPP");
                    }

                } else {
                    request.setAttribute("typKlient", 0); //0 - pro nic
                }
            } else {
                request.setAttribute("typKlient", 0); //0 - pro nic
            }
        } else {
            request.setAttribute("typKlient", 0); //0 - pro nic
        }
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        cart.calculateTotal("0");
        request.setAttribute("selectedCenterId", 20);

        userPath = "ekcvjs";

        try {
            request.getRequestDispatcher(userPath + ".jsp").forward(request, response);
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void zpracujCheckoutOrg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        String odkazNazev = request.getQueryString();
        HttpSession session = request.getSession();

        Uzivatele uzR = null;
        Osoby klientR = null;
        Organizace orgR = null;

        int idOrgVybrane = 0;

        // get categoryId from request
        if (request.getRemoteUser() != null) {
            if (request.getAttribute("uzivatelePrihlaseni") == null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                request.setAttribute("uzivatelePrihlaseni", uzR);
            }

            if (request.getAttribute("klientPrihlaseni") == null) {
                if (uzR.getUzivateleOrganizaceId() != null) {
                    orgR = uzR.getUzivateleOrganizaceId();
                    request.setAttribute("klientPrihlaseni", orgR);
                    request.setAttribute("selectedCenter", "WEB-INF/view/checkoutOrg.jsp");
                    request.setAttribute("typKlient", 2); //2 - pro organizaci
                } else if (uzR.getUzivateleOsobyId() != null) {
                    klientR = uzR.getUzivateleOsobyId();
                    request.setAttribute("klientPrihlaseni", klientR);
                    request.setAttribute("selectedCenter", "WEB-INF/view/checkoutOs.jsp");
                    request.setAttribute("typKlient", 1); //1 - pro osobu
                    ArrayList<WebOrgOs> zamestnavateleOrgOs = new ArrayList(webOrgOsFacade.findByOsoba(klientR.getOsobaId()));
                    if (idOrgVybrane > 0) {
                        request.setAttribute("vybranyZam", organizacePrihlaseni.findPodleId(idOrgVybrane));
                    } else {
                        if (zamestnavateleOrgOs.size() > 0) {
                            request.setAttribute("vybranyZam", zamestnavateleOrgOs.get(0).getWebOrgOsOrganizace());
                        }
                    }
                    request.setAttribute("zamestnavatele", zamestnavateleOrgOs);

                    boolean bCartWarn = false;
                    ShoppingCart cartWarn = (ShoppingCart) session.getAttribute("cart");
                    for (ShoppingCartItem sci : cartWarn.getItems()) {

                        OboryVazbySkupiny ovs = sci.getProduct().getPrimObor().getOboryVazbySkupinyCollection().iterator().next();

                        if (ovs.getOborySkupiny().getOborySkupinyId() == 4) {
                            bCartWarn = true;
                        }
                    }

                    if (bCartWarn) {
                        request.setAttribute("fakturaWarn", "warnIndivDVPP");
                    }

                } else {
                    request.setAttribute("typKlient", 0); //0 - pro nic
                }
            } else {
                request.setAttribute("typKlient", 0); //0 - pro nic
            }
        } else {
            request.setAttribute("typKlient", 0); //0 - pro nic
        }
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        cart.calculateTotal("0");
        request.setAttribute("selectedCenterId", 20);

        userPath = "ekcvjs";

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

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");

        // if addToCart action is called
        if (zt == null) {

            getServletContext().removeAttribute("zobrazeniTabulek.webProp");
            List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);
            session.setAttribute("zobrazeniTabulek", zt);
        }

        if (userPath.equals("/pridatZamestnance")) {
            String url = "ekcvjs.jsp";
            if (orgR != null) {
                request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/prihlasitOsoby.jsp");
                request.setAttribute("selectedCenterId", 10);
                String akceId = request.getParameter("akceId");
                if (!akceId.isEmpty()) {
                    session.setAttribute("akceObjednavka", akceId);
                }
            }

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals("/pridatDoKosiku")) {
            String url = "ekcvjs.jsp";
            if (orgR != null) {
                request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/prihlasitOsoby.jsp");
                request.setAttribute("selectedCenterId", 10);
                String akceId = request.getParameter("akceId");
                if (!akceId.isEmpty()) {
                    session.setAttribute("akceObjednavka", akceId);
                }

            } else if (klientR != null) {
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }
                String akceId = request.getParameter("akceId");
                if (!akceId.isEmpty()) {

                    AkceHlavni product = akceHlavniFacade.find(Integer.parseInt(akceId));
                    int indexA = 0;
                    for (int i = 0; i < cart.getItems().size(); i++) {
                        if (cart.getItems().get(i).getProduct().getAkceId() == product.getAkceId()) {
                            indexA++;
                        }
                    }
                    if (indexA == 0) {
                        cart.addItem(product, true);
                    }
                }

                ArrayList<Osoby> chybneOsoby = new ArrayList<Osoby>();

                if (klientR.getJmeno() == null || klientR.getPrijmeni() == null || klientR.getAdresa() == null
                        || klientR.getMesto() == null || klientR.getPsc() == null || (klientR.getDatumNarozeni() == null || klientR.getRodneCislo() == null)) {

                    chybneOsoby.add(klientR);
                }

                session.setAttribute("chybneOsoby", chybneOsoby);

                request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
                WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
                Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                request.setAttribute("panelyData", panelyData);
                request.setAttribute("selectedCenterId", 10);

            } else {

                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }
                String akceId = request.getParameter("akceId");
                if (!akceId.isEmpty()) {

                    AkceHlavni product = akceHlavniFacade.find(Integer.parseInt(akceId));
                    int indexA = 0;
                    for (int i = 0; i < cart.getItems().size(); i++) {
                        if (cart.getItems().get(i).getProduct().getAkceId() == product.getAkceId()) {
                            indexA++;
                        }
                    }
                    if (indexA == 0) {
                        cart.addItem(product);
                    }
                }

                request.setAttribute("selectedCenterId", 10);
                session.setAttribute("odkazStranaLogin", true);

                url = "admin/login.jsp"; //https://ekcvjs.kcvjs.cz/ekcvjs/ekcvjs?prihlaseniUzivatele.jsp";
            }

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // if updateCart action is called
        } else if (userPath.equals("/poslatHeslo")) {
            String uzivEmail = request.getParameter("uzivEmail");
            if (uzivEmail.contains("@") && uzivEmail.contains(".")) {
                Osoby osPrihlasena = osobyPrihlaseni.findPodleEmail(uzivEmail);
                Organizace orgPrihlasena = organizacePrihlaseni.findPodleEmail(uzivEmail);
                Uzivatele uzOs = uzivatelPrihlaseni.findPodleOsoby(osPrihlasena);
                Uzivatele uzOrg = uzivatelPrihlaseni.findPodleOrganizace(orgPrihlasena);
                //  
                if (uzOs != null && uzOs.getUzivateleOsobyId() != null) {
                    String noveHeslo = uzivatelPrihlaseni.generovatHeslo(uzOs);

                    String adresaMail = uzOs.getUzivateleOsobyId().getEMail();
                    List<String> adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }
                    for (String am : adresyMailList) {
                        PoslatMail pm = new PoslatMail("noreply@kcvjs.cz", am, "Obnovení hesla eKCVJŠ",
                                "Dobrý den, <br/> "
                                + "posíláme Vám obnovení zapomenutého hesla pro eKCVJŠ: <br/> "
                                + "Uzivatel : " + uzOs.getUzivateleOsobyId().getJmeno() + " " + uzOs.getUzivateleOsobyId().getPrijmeni() + " <br/> "
                                + "Přihlašovací jméno: " + uzOs.getUzivateleJmeno() + " <br/> "
                                + "Heslo: " + /*uz.getUzivateleHeslo()*/ noveHeslo + " <br/>  <br/> "
                                + "S pozdravem,  <br/>"
                                + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");
                        pm.send();
                    }
                } else if (uzOrg != null && uzOrg.getUzivateleOrganizaceId() != null) {
                    String noveHeslo = uzivatelPrihlaseni.generovatHeslo(uzOrg);
                    String adresaMail = uzOrg.getUzivateleOrganizaceId().getEMail();
                    List<String> adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }

                    for (String am : adresyMailList) {
                        PoslatMail pm = new PoslatMail("noreply@kcvjs.cz", am, "Obnovení hesla eKCVJŠ",
                                "Dobrý den, <br/> "
                                + "posíláme Vám obnovení zapomenutého hesla pro eKCVJŠ: <br/> "
                                + "Organizace : " + uzOrg.getUzivateleOrganizaceId().getNazev() + " <br/> "
                                + "Přihlašovací jméno: " + uzOrg.getUzivateleJmeno() + " <br/> "
                                + "Heslo: " + noveHeslo /*uz.getUzivateleHeslo()*/ + " <br/>  <br/> "
                                + "S pozdravem,  <br/>"
                                + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");
                        pm.send();
                    }
                }
            }
            String url = "/index.jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/tempKosik")) {
            String urlIn = request.getParameter("tempKosikUrl").substring(sortNazev);
            String userName = null;
            String uuid = null;
            String akce = null;

            String url = "ekcvjs.jsp";

            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            String[] params = urlIn.substring(1).split("&");

            for (int i = 0; i < params.length; i++) {
                int rovno = params[i].indexOf("=");
                String[] internalParams = new String[2];
                internalParams[0] = params[i].substring(0, rovno);
                internalParams[1] = params[i].substring(rovno + 1);

                switch (i) {
                    case 0:
                        userName = internalParams[1];
                        break;
                    case 1:
                        uuid = internalParams[1].substring(0, internalParams[i].length() - 1);
                        break;
                    case 2:
                        akce = internalParams[1];
                        break;
                    default:
                        break;
                }
            }

            request.login(userName, new String(Base64.getDecoder().decode(uuid)));

            if (request.getRemoteUser() != null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                if (uzR.getUzivateleOrganizaceId() != null) {
                    request.setAttribute("typKlient", 2); //2 - pro organizaci               
                } else if (uzR.getUzivateleOsobyId() != null) {
                    request.setAttribute("typKlient", 1); //1 - pro osobu
                } else {
                    request.setAttribute("typKlient", 0); //0 - pro nic
                }
            } else {
                request.setAttribute("typKlient", 0); //0 - pro nic
            }
            String[] akceList = new String[0];
            if (akce.isEmpty() == false) {
                akceList = akce.split(";");
            }

            if (akceList.length > 0) {
                for (int a = 0; a < akceList.length; a++) {
                    AkceHlavni product = akceHlavniFacade.findByCislo(akceList[a]);
                    int indexA = 0;
                    for (int i = 0; i < cart.getItems().size(); i++) {
                        if (cart.getItems().get(i).getProduct().getAkceId() == product.getAkceId()) {
                            indexA++;
                        }
                    }
                    if (indexA == 0) {
                        cart.addItem(product);
                    }
                }
            }

            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");

            request.setAttribute("selectedCenterId", 10);
            session.setAttribute("odkazStranaLogin", true);

            // url = admin/login.jsp
            url = "ekcvjs.jsp"; //https://ekcvjs.kcvjs.cz/ekcvjs/ekcvjs?prihlaseniUzivatele.jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);

                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals("/prihlasitIndex")) {

            String url = "ekcvjs.jsp";

            String userName = request.getParameter("j_username");
            String uuid = request.getParameter("j_password");

            try {
                request.login(userName, uuid);
                if (request.getRemoteUser() != null) {
                    uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
                    if (uzR.getUzivateleOrganizaceId() != null) {
                        request.setAttribute("typKlient", 2); //2 - pro organizaci   
                        request.setAttribute("logUser", uzR.getUzivateleOrganizaceId().getNazev());
                        List<WebOrgOs> pridruzeneOsoby = webOrgOsFacade.findByOrganizace(uzR.getUzivateleOrganizaceId().getOrganizaceId());
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
                        request.setAttribute("typKlient", 1); //1 - pro osobu
                        request.setAttribute("logUser", uzR.getUzivateleOsobyId().getJmeno() + " " + uzR.getUzivateleOsobyId().getPrijmeni());
                        request.setAttribute("aktivniPrihlasky", prihlaskyFacade.findPocetByOsobaMultiAktivni(uzR.getUzivateleOsobyId()));
                        request.setAttribute("skoncenePrihlasky", prihlaskyFacade.findPocetByOsobaMultiSkoncena(uzR.getUzivateleOsobyId()));
                    } else {
                        request.setAttribute("typKlient", 0); //0 - pro nic
                    }
                } else {
                    request.setAttribute("typKlient", 0); //0 - pro nic
                }

                request.setAttribute("selectedCenter", "prihlaseniUzivatele.jsp");

                request.setAttribute("selectedCenterId", 10);
                session.setAttribute("odkazStranaLogin", true);

                // url = admin/login.jsp
                url = "ekcvjs.jsp"; //"https://ekcvjs.kcvjs.cz/ekcvjs/ekcvjs?prihlaseniUzivatele.jsp";
            } catch (javax.servlet.ServletException sse) {
                request.setAttribute("selectedCenterId", 10);
                session.setAttribute("odkazStranaLogin", true);
                //request.setAttribute("selectedCenter", "admin/error.jsp");
                url = "admin/error.jsp";

            }
            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals("/potvrditPrihlaseniOsoba")) {

            String[] parametry = request.getParameterValues("idOsoba");
            ArrayList<Osoby> prihlaseniOsoby = new ArrayList<Osoby>();
            ArrayList<Osoby> chybneOsoby = new ArrayList<Osoby>();
            ArrayList<DruhyPrihlasek> druhyPrihlasek = new ArrayList<DruhyPrihlasek>();
            if (parametry != null) {
                for (int i = 0; i < parametry.length; i++) {
                    prihlaseniOsoby.add(osobyPrihlaseni.findPodleId(Integer.valueOf(parametry[i]).intValue()));
                    druhyPrihlasek.add(druhyPrihlasekFacade.findById(1));

                }
            }
            AkceHlavni akceVyber = akceHlavniFacade.findById(Integer.valueOf((String) session.getAttribute("akceObjednavka")).intValue());
            if (akceVyber != null) {

                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                    session.setAttribute("chybneOsoby", new ArrayList<Osoby>());
                }

                int indexA = 0;

                for (int i = 0; i < cart.getItems().size(); i++) {
                    ShoppingCartItem sci = cart.getItems().get(i);                   
                    if (Objects.equals(sci.getProduct().getAkceId(), akceVyber.getAkceId())) {
                        indexA++;

                        for (int j = 0; j < prihlaseniOsoby.size(); j++) {
                            int indexP = 0;
                            if (sci.getPrihlaseni() != null) {
                                for (int k = 0; k < sci.getPrihlaseni().size(); k++) {
                                    if (sci.getPrihlaseni().get(k).getOsobaId() == prihlaseniOsoby.get(j).getOsobaId()) {
                                        indexP++;
                                    }
                                }
                            } else {
                                sci.setPrihlaseni(new ArrayList<Osoby>());
                                sci.setDruhyPrihlasek(new ArrayList<DruhyPrihlasek>());
                            }
                            if (indexP == 0) {
                                sci.getPrihlaseni().add(prihlaseniOsoby.get(j));
                                sci.getDruhyPrihlasek().add(druhyPrihlasekFacade.findById(1));
                                sci.setQuantity(sci.getQuantity() + 1);
                            }
                        }
                    }

                }
               
                if (indexA == 0) {
                    cart.addItem(akceVyber, prihlaseniOsoby, obdobiFacade.find(zt.getIdObdobi()), druhyPrihlasek);
                }
            }

            for (int i = 0; i < prihlaseniOsoby.size(); i++) {
                Osoby o = prihlaseniOsoby.get(i);
                if (o.getJmeno() == null || o.getPrijmeni() == null || o.getAdresa() == null
                        || o.getMesto() == null || o.getPsc() == null || (o.getDatumNarozeni() == null || o.getRodneCislo() == null)) {                  
                    chybneOsoby.add(o);
                }
            }
            session.setAttribute("chybneOsoby", chybneOsoby);

            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
            WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
            Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
            request.setAttribute("panelyData", panelyData);
            request.setAttribute("selectedCenterId", 10);
            String url = "/ekcvjs.jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/odebratLidizKosiku")) {
            int osobaId = 0;
            int akceId = 0;
            if (!request.getParameter("osobaAkceId").isEmpty()) {
                osobaId = Integer.valueOf(request.getParameter("osobaAkceId").substring(0, request.getParameter("osobaAkceId").indexOf("x"))).intValue();
                akceId = Integer.valueOf(request.getParameter("osobaAkceId").substring(1 + request.getParameter("osobaAkceId").indexOf("x"))).intValue();
                cart.removeOsoba(akceHlavniFacade.findById(akceId), osobyPrihlaseni.findPodleId(osobaId));
            } else {
                return;
            }

            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
            WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
            Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
            request.setAttribute("panelyData", panelyData);
            request.setAttribute("selectedCenterId", 10);
            String url = "/ekcvjs.jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/odebratAkcezKosiku")) {
            int akceId = 0;
            if (!request.getParameter("akceId").isEmpty()) {
                akceId = Integer.valueOf(request.getParameter("akceId")).intValue();
                cart.removeAkce(akceHlavniFacade.findById(akceId));
            } else {
                return;
            }

            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
            WebPanely wp = panelyFacade.findByOdkazKategorie("cart.jsp", kategorieFacade.findById(70));
            Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
            request.setAttribute("panelyData", panelyData);
            request.setAttribute("selectedCenterId", 10);
            String url = "/ekcvjs.jsp";

            try {
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/zmenaHesla")) {
            String uzivJmeno = request.getParameter("uzivJmeno");
            /*
             * if (request.getRemoteUser() != null) { uzR =
             * uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser()); }
             */
            Uzivatele uz = uzivatelPrihlaseni.findPodleJmena(uzivJmeno);
            String hesloPrvni = request.getParameter("hesloPrvni");
            String hesloNove = request.getParameter("hesloNove");
            String hesloZnovu = request.getParameter("hesloZnovu");
            if (org.apache.commons.codec.digest.DigestUtils.sha256Hex(hesloPrvni).equals(uz.getUzivateleHeslo())) {
                if ((request.getParameter("hesloNove") == null) || (request.getParameter("hesloZnovu") == null)) {
                    request.setAttribute("zmenaHeslaInfo", "vyplnteObePole");
                } else if ((request.getParameter("hesloNove")).equals(request.getParameter("hesloZnovu")) == false) {
                    request.setAttribute("zmenaHeslaInfo", "ruznaHesla");
                } else if ((request.getParameter("hesloNove")).equals(request.getParameter("hesloZnovu")) == true) {
                    uz.setUzivateleHeslo(org.apache.commons.codec.digest.DigestUtils.sha256Hex(hesloNove));
                    uz = uzivatelPrihlaseni.updateUser(uz);
                    if (uz.getUzivateleOsobyId() != null) {

                        String adresaMail = uz.getUzivateleOsobyId().getEMail();
                        List<String> adresyMailList = new ArrayList();
                        if (adresaMail.contains(",")) {
                            adresyMailList = Arrays.asList(adresaMail.split(","));
                        } else {
                            adresyMailList.add(adresaMail);
                        }
                        for (String am : adresyMailList) {

                            PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Změna přihlašovacích údajů eKCVJŠ",
                                    "Dobrý den, <br/> "
                                    + "posíláme Vám aktualizované přihlašovací údaje pro eKCVJŠ: <br/> "
                                    + "Uzivatel : " + uz.getUzivateleOsobyId().getJmeno() + " " + uz.getUzivateleOsobyId().getPrijmeni() + " <br/> "
                                    + "Přihlašovací jméno: " + uz.getUzivateleJmeno() + " <br/> "
                                    + "Heslo: " + hesloNove /*uz.getUzivateleHeslo()*/ + " <br/>  <br/> "
                                    + "S pozdravem,  <br/>"
                                    + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");
                            pm.send();
                        }
                    } else if (uzR.getUzivateleOrganizaceId() != null) {
                        String adresaMail = uz.getUzivateleOrganizaceId().getEMail();
                        List<String> adresyMailList = new ArrayList();
                        if (adresaMail.contains(",")) {
                            adresyMailList = Arrays.asList(adresaMail.split(","));
                        } else {
                            adresyMailList.add(adresaMail);
                        }
                        for (String am : adresyMailList) {
                            PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Změna přihlašovacích údajů eKCVJŠ",
                                    "Dobrý den, <br/> "
                                    + "posíláme Vám aktualizované přihlašovací údaje pro eKCVJŠ: <br/> "
                                    + "Uzivatel : " + uz.getUzivateleOrganizaceId().getNazev() + " <br/> "
                                    + "Přihlašovací jméno: " + uz.getUzivateleJmeno() + " <br/> "
                                    + "Heslo: " + hesloNove /*uz.getUzivateleHeslo()*/ + " <br/>  <br/> "
                                    + "S pozdravem,  <br/>"
                                    + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");
                            pm.send();
                        }
                    }
                    request.setAttribute("zmenaHeslaInfo", "uspesnaZmena");
                }

                String url = "/ekcvjs.jsp";
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/loginUdaje.jsp");

                try {
                    request.getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                request.setAttribute("zmenaHeslaInfo", "chybneHeslo");
                String url = "/ekcvjs.jsp";
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/loginUdaje.jsp");

                try {
                    request.getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }           

        } else if (userPath.equals("/potvrzeniUdajeOs")) {
            java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy", new Locale("cs, CZ"));
            request.setCharacterEncoding("UTF-8");
            if (request.getRemoteUser() != null) {
                uzR = uzivatelPrihlaseni.findPodleJmena(request.getRemoteUser());
            }
            Osoby klient = uzR.getUzivateleOsobyId();            
            if (request.getParameter("titulpred").isEmpty()) {
                klient.setTitulPred(null);
            } else {
                klient.setTitulPred(request.getParameter("titulpred"));
            }
            klient.setJmeno(request.getParameter("jmeno"));
            klient.setPrijmeni(request.getParameter("prijmeni"));
            if (request.getParameter("titulza").isEmpty()) {
                klient.setTitulZa(null);
            } else {
                klient.setTitulZa(request.getParameter("titulza"));
            }
            if (Boolean.parseBoolean(request.getParameter("neexRodneCislo")) == false) {

                if (request.getParameter("rodnecislo") == null || request.getParameter("rodnecislo").isEmpty()) {
                    klient.setRodneCislo(null);                   
                } else {
                    Osoby rcOsoba = osobyPrihlaseni.findPodleRodneCislo(request.getParameter("rodnecislo"));
                    if (rcOsoba != null) {
                        boolean platneRC = false;
                        try {

                            ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                            while (q.next()) {
                                platneRC = q.getBoolean(1);
                            }
                            PripojeniDB.rs.close();
                            PripojeniDB.pstmt.close();
                            PripojeniDB.con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (platneRC == true) {
                            klient.setRodneCislo(request.getParameter("rodnecislo"));
                        } else {
                            try {
                                request.setAttribute("chybaRegistrace", "spatneRC");
                                request.setAttribute("selectedCenter", "registrace.jsp");
                                getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        boolean platneRC = false;
                        try {

                            ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                            while (q.next()) {
                                platneRC = q.getBoolean(1);
                            }
                            PripojeniDB.rs.close();
                            PripojeniDB.pstmt.close();
                            PripojeniDB.con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (platneRC == true) {
                            klient.setRodneCislo(request.getParameter("rodnecislo"));
                        } else {
                            try {
                                request.setAttribute("chybaRegistrace", "spatneRC");
                                request.setAttribute("selectedCenter", "registrace.jsp");
                                getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                }
            } else {
                klient.setRodneCislo(null);
            }
            try {
                klient.setDatumNarozeni(df.parse(request.getParameter("datumnarozeni")));
            } catch (Exception e) {
                klient.setDatumNarozeni(null);
            }
            klient.setMistoNarozeni(request.getParameter("mistonarozeni"));
            klient.setNarodnost(request.getParameter("narodnost"));
            klient.setStatniPrislusnost(request.getParameter("prislusnost"));
            if (request.getParameter("adresa").isEmpty()) {
                klient.setAdresa(null);
            } else {
                klient.setAdresa(request.getParameter("adresa"));
            }
            if (request.getParameter("mesto").isEmpty()) {
                klient.setMesto(null);
            } else {
                klient.setMesto(request.getParameter("mesto"));
            }
            if (request.getParameter("psc").isEmpty()) {
                klient.setPsc(null);
            } else {
                klient.setPsc(request.getParameter("psc"));
            }

            if (request.getParameter("email").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "chybiEmail");
                    request.setAttribute("selectedCenter", "registrace.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (osobyPrihlaseni.findPocetPodleEmail(request.getParameter("email")) > 0) {
                    try {
                        request.setAttribute("chybaRegistrace", "duplicitniEmail");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setEMail(request.getParameter("email"));
                }
            }
            if (request.getParameter("telefon").isEmpty()) {
                klient.setTelefon(null);
            } else {
                klient.setTelefon(request.getParameter("telefon"));
            }

            osobyPrihlaseni.updateOsoby(klient);

            String url = "/ekcvjs.jsp";
            request.setAttribute("klientPrihlaseni", osobyPrihlaseni.findPodleId(uzR.getUzivateleOsobyId().getOsobaId()));
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/klientskeUdaje.jsp");

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/najitZamestnavatele")) {

            if (request.getParameter("zamestnavatel_ic") != null) {

                Organizace zamestnavatel = organizacePrihlaseni.findPodleIco(request.getParameter("zamestnavatel_ic"));
                request.setAttribute("vybranyZam", zamestnavatel);
                request.setAttribute("registrace", true);
            }
            String url = "/ekcvjs.jsp";
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/zamestnavatelUdaje.jsp");

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/registrovatZamestnavatele")) {

            if (request.getParameter("nazev") != null && request.getParameter("ic") != null) {

                String adresaMail = (String) request.getParameter("email");
                List<String> adresyMailList = new ArrayList();
                if (adresaMail.contains(",")) {
                    adresyMailList = Arrays.asList(adresaMail.split(","));
                } else {
                    adresyMailList.add(adresaMail);
                }

                for (String am : adresyMailList) {
                    String textMail = "Vážený kliente, <br/>"
                            + "osoba se jménem : " + klientR.getJmeno() + " " + klientR.getPrijmeni() + " požádala o registraci k vaší organizaci " + request.getParameter("nazev") + ".<br/><br/> "
                            + "Osobu můžete autorizovat na www.kcvjs.cz v sekci EKCJVŠ - navrhované osoby.<br/><br/>"
                            + "S pozdravem,  <br/>"
                            + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)";
                    PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "EKCVJŠ : Registrace nového zaměstnance ", textMail);                  
                    pm.send();
                }
                request.setAttribute("registrace", false);
                try {
                    webOrgOsPendingFacade.pridatZamestnanec(organizacePrihlaseni.findPodleIco(request.getParameter("ic")), klientR);
                    request.setAttribute("registraceOK", true);
                } catch (Exception e) {
                    request.setAttribute("chybaReg", "Došlo k chybě při registraci, kontaktujte správce wwww stránek.");
                }

            }

            String url = "/ekcvjs.jsp";
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/zamestnavatelUdaje.jsp");

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/updateCart")) {
            // get input from request
            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");

            AkceHlavni product = akceHlavniFacade.find(Integer.parseInt(productId));
            cart.update(product, quantity);

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
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

            // if purchase action is called
        } else if (userPath.equals("/organizaceUdaje")) {
            if (request.getParameter("nazev").isEmpty()) {
                orgR.setNazev(null);
            } else {
                orgR.setNazev(request.getParameter("nazev"));
            }

            if (request.getParameter("nazevPlny1").isEmpty()) {
                orgR.setNazevPlny1(null);
            } else {
                orgR.setNazevPlny1(request.getParameter("nazevPlny1"));
            }

            if (request.getParameter("ic").isEmpty()) {
                orgR.setIco(null);
            } else {
                orgR.setIco(request.getParameter("ic"));
            }
            if (request.getParameter("dic").isEmpty()) {
                orgR.setDic(null);
            } else {
                orgR.setDic(request.getParameter("dic"));
            }

            if (request.getParameter("adresa").isEmpty()) {
                orgR.setAdresa(null);
            } else {
                orgR.setAdresa(request.getParameter("adresa"));
            }

            if (request.getParameter("mesto").isEmpty()) {
                orgR.setMesto(null);
            } else {
                orgR.setMesto(request.getParameter("mesto"));
            }

            if (request.getParameter("psc").isEmpty()) {
                orgR.setPsc(null);
            } else {
                orgR.setPsc(request.getParameter("psc"));
            }

            if (request.getParameter("email").isEmpty()) {
                orgR.setEMail(null);
            } else {
                orgR.setEMail(request.getParameter("email"));
            }

            if (request.getParameter("emailFakturace").isEmpty()) {
                orgR.seteMailFakturace(null);
            } else {
                orgR.seteMailFakturace(request.getParameter("emailFakturace"));
            }

            if (request.getParameter("telefon").isEmpty()) {
                orgR.setTelefon(null);
            } else {
                orgR.setTelefon(request.getParameter("telefon"));
            }
            if (request.getParameter("fax").isEmpty()) {
                orgR.setFax(null);
            } else {
                orgR.setFax(request.getParameter("fax"));
            }
            //String[] typOrg = request.getParameterValues("vyberTypOrg");
            if (zt.getKatOrgTyp() > 0) {

                orgR.setKatorgtyp(katOrgTypyfacade.findById(zt.getKatOrgTyp()));
            }
            if (request.getParameter("avizoPozvankyEmail") != null) {
                orgR.setAvizoEmailPozvanky(true);
            } else {
                orgR.setAvizoEmailPozvanky(false);
            }
           
            if ((zt.getKatOrgTyp() > 0) && (zt.getKatOrgDruh() > 0)) {
                orgR.setKatOrgPolozky(katOrgPolozkyfacade.findById(zt.getKatOrgTyp(), zt.getKatOrgDruh()));
            } else if ((zt.getKatOrgTyp() == 0) && (zt.getKatOrgDruh() > 0)) {
                orgR.setKatOrgPolozky(katOrgPolozkyfacade.findById(orgR.getKatorgtyp().getKatorgtypId(), zt.getKatOrgDruh()));
            }

            organizacePrihlaseni.updateOrganizace(orgR);

            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/organizaceUdaje.jsp");
            request.setAttribute("vyberKatOrgTyp", zt.getKatOrgTyp());
            request.setAttribute("vyberKatOrgDruh", zt.getKatOrgDruh());
            request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
            request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
            if (orgR != null) {              
                request.setAttribute("klientPrihlaseni", orgR);
            }
            try {
                String url = "/ekcvjs.jsp";

                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/odebratZeZamestnancu")) {
            
            int osobaId = 0;
            if (!request.getParameter("osobaId").isEmpty()) {
                osobaId = Integer.valueOf(request.getParameter("osobaId")).intValue();
            } else {
                return;
            }
           
            webOrgOsFacade.odebratZamestnanec(orgR, osobyPrihlaseni.findPodleId(osobaId));

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/pridruzeneOsoby.jsp");
            try {
                String url = "/ekcvjs.jsp";
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/pridatDoZamestnancu")) {

            int osobaId = 0;
            if (!request.getParameter("osobaId").isEmpty()) {
                osobaId = Integer.valueOf(request.getParameter("osobaId")).intValue();
            } else {
                return;
            }

            webOrgOsFacade.pridatZamestnanec(orgR, osobyPrihlaseni.findPodleId(osobaId));

            webOrgOsPendingFacade.odebratZamestnanec(orgR, osobyPrihlaseni.findPodleId(osobaId));

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/pridruzeneOsoby.jsp");
            try {
                String url = "/ekcvjs.jsp";
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/souhlasGDPR")) {
            Osoby o = new Osoby();
            if (uzR != null) {
                o = uzR.getUzivateleOsobyId();
            }

            if (request.getParameter("souhlasCheck") != null) {
                if (o.isGdprUdeleno()) {
                    o.setGdprUdeleno(false);
                    String IP = request.getRemoteAddr();
                    o.setGdprPoznamka("Souhlas GDPR odebrán : " + new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()) + " z IP : " + IP);
                    String textMail = "Klient : " + o.getOsobaId() + " - " + o.getJmeno() + " " + o.getPrijmeni() + " zrušila svůj souhlas s poskytováním osobních údajů. Je nutné provést revizi uložených dat o klientovi.";
                    PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", "sekretariat@kcvjs.cz", "Zrušení souhlasu GDPR",
                            textMail);
                    pm.send();
                } else {
                    o.setGdprUdeleno(true);
                    o.setGdprZpusob(10);
                    String IP = request.getRemoteAddr();
                    o.setGdprPoznamka("Souhlas GDPR udělen : " + new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()) + " z IP : " + IP);
                }

            } else {
                //  o.setGdprUdeleno(false);
            }

            osobyPrihlaseni.updateOsoby(o);

            //request.setAttribute("selectedCenterId", 10);
            request.setAttribute("klientPrihlaseni", o);
            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/gdprInfo.jsp");
            request.setAttribute("selectedCenterId", 20);
            try {
                String url = "/ekcvjs.jsp";
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/potvrzeniOrg")) {
            ArrayList<PrihlaskyRozpisy> arPr = new ArrayList<PrihlaskyRozpisy>();
            StavyPrihlasek sp = new StavyPrihlasek(1); //prihlasen

            PrihlaskyDruhy pd = new PrihlaskyDruhy(4);  // ekcvjs
            // DruhyFaktur df = new DruhyFaktur(1);        //hradi organizace

            for (int i = 0; i < cart.getItems().size(); i++) {
                ShoppingCartItem sci = cart.getItems().get(i);
                for (int j = 0; j < sci.getPrihlaseni().size(); j++) {
                    if (sci.getDruhyPrihlasek().get(j).getDruhPrihlId() == 1) {                       
                        PrihlaskyRozpisy p = new PrihlaskyRozpisy();
                        p.setAkce(cart.getItems().get(i).getProduct());
                        p.setOsoba(sci.getPrihlaseni().get(j));
                        p.setObjednavatelOrg(orgR);
                        p.setPlatceOrg(orgR);
                        p.setOdberatelOrg(orgR);
                        p.setStavprihl(sp);
                        p.setPrihlasenDodatecne(false);
                        p.setDruhprihl(sci.getDruhyPrihlasek().get(j));
                        p.setDruhfakt(druhyFakturFacade.findById(sci.getDruhyPrihlasek().get(j).getDruhPrihlId()));
                        p.setObdobi(sci.getProduct().getAkceObdobi());
                        p.setPrihlaseniZpusob(pd);
                        p = prihlaskyFacade.prihlasit(p);
                        arPr.add(p);
                    } else {
                       
                        PrihlaskyRozpisy p = new PrihlaskyRozpisy();
                        p.setAkce(cart.getItems().get(i).getProduct());
                        p.setOsoba(sci.getPrihlaseni().get(j));
                        p.setObjednavatelOrg(orgR);
                        p.setPlatceOs(sci.getPrihlaseni().get(j));
                        p.setOdberatelOs(sci.getPrihlaseni().get(j));
                        p.setStavprihl(sp);
                        p.setPrihlasenDodatecne(false);
                        p.setDruhprihl(sci.getDruhyPrihlasek().get(j));
                        p.setDruhfakt(druhyFakturFacade.findById(sci.getDruhyPrihlasek().get(j).getDruhPrihlId()));
                        p.setObdobi(sci.getProduct().getAkceObdobi());
                        p.setPrihlaseniZpusob(pd);
                        p = prihlaskyFacade.prihlasit(p);
                        arPr.add(p);
                    }
                }
            }
            request.setAttribute("orderedProducts", arPr);
            double cenaCelkem = cart.getTotal();
            request.setAttribute("cenaCelkem", cenaCelkem);

            cart.clear();

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("selectedCenter", "WEB-INF/view/potvrzeniOrg.jsp");

            java.text.NumberFormat nf2 = java.text.NumberFormat.getInstance();

            String textMail = "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_objednavky") + "</p>"
                    + "<div id=\"kcvjsInfo\">"
                    + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                    + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                    + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                    + "<div id=\"horizontRuler\"><hr></div> "
                    + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                    + "</div> "
                    + "<div class=\"summaryColumn\" > "
                    + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                    + "<tr class=\"header\"> "
                    + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_rezervace") + "</th>"
                    + "</tr> "
                    + "<tr class=\"tableHeading\"> "
                    + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                    + "</tr> ";
            for (int i = 0; i < arPr.size(); i++) {
                textMail += "<tr class= 'lightBlue'\"> "
                        + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                        + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                        + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                        + "</td> "
                        + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                        + "</td> "
                        + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                        + "</td> "
                        + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                        + "</td> "
                        + "</tr> ";
            }
            textMail += "<tr class=\"lightBlue\"> "
                    + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                    + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                    + "</tr> "
                    + "</table>"
                    + "</div> "
                    + "<div class=\"summaryObjednavatel\" > "
                    + "<table id=\"potvrzeniObjTable\"> "
                    + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                    + "<tr>"
                    + "<td>" + ((orgR.getNazev() == null) ? "" : orgR.getNazev())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getAdresa() == null) ? "" : orgR.getAdresa())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getMesto() == null) ? "" : orgR.getMesto())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getPsc() == null) ? "" : orgR.getPsc())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getIco() == null) ? "" : "IČ: " + orgR.getIco())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getTelefon() == null) ? "" : orgR.getTelefon())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getEMail() == null) ? "" : orgR.getEMail())
                    + "</td>"
                    + "</tr>"
                    + "</table> "
                    + "<div id = \"shrnutiObjednavky\">";

            String adresaMail = orgR.getEMail();
            List<String> adresyMailList = new ArrayList();
            if (adresaMail.contains(",")) {
                adresyMailList = Arrays.asList(adresaMail.split(","));
            } else {
                adresyMailList.add(adresaMail);
            }
            for (String am : adresyMailList) {

                PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ",
                        textMail);
                pm.send();
            }

            for (int p = 0; p < arPr.size(); p++) {
                if (arPr.get(p).getOsoba().getEMail() != null) {
                    textMail = "Dobrý den, <br/> "
                            + "Váš zaměstnavatel <br/> "
                            + "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:left; width:609px;\">" + ((orgR.getNazev() == null) ? "" : orgR.getNazev()) + "</p>"
                            + "Vás přihlásil na vzdělávací programy shrnuté v objednávce. <br/> "
                            + "Pokud jste přihlášeni jako samoplátce, účastnický poplatek od Vás bude vybrán <br/>"
                            + "při konání vzdělávacího programu. Pokud preferujete úhradu předem <br/>"
                            + "prostřednictvím bankovního účtu, kontaktujte naše účetní oddělení <br/>"
                            + "na email vejvodova@kcvjs.cz. Budou Vám sděleny platební údaje. <br/>"
                            + "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_objednavky") + "</p>"
                            + "<div id=\"kcvjsInfo\">"
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                            + "<div id=\"horizontRuler\"><hr></div> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                            + "</div> "
                            + "<div class=\"summaryColumn\" > "
                            + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                            + "<tr class=\"header\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_objednavka") + "</th>"
                            + "</tr> "
                            + "<tr class=\"tableHeading\"> "
                            + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                            + "</tr> ";
                    for (int i = 0; i < arPr.size(); i++) {
                        textMail += "<tr class= 'lightBlue'\"> "
                                + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                                + "</td> "
                                + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                                + "</td> "
                                + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                                + "</td> "
                                + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                                + "</td> "
                                + "</tr> ";
                    }
                    textMail += "<tr class=\"lightBlue\"> "
                            + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                            + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                            + "</tr> "
                            + "</table>"
                            + "</div> "
                            + "<div class=\"summaryObjednavatel\" > "
                            + "<table id=\"potvrzeniObjTable\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                            + "<tr>"
                            + "<td>" + ((orgR.getNazev() == null) ? "" : orgR.getNazev())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getAdresa() == null) ? "" : orgR.getAdresa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getMesto() == null) ? "" : orgR.getMesto())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getPsc() == null) ? "" : orgR.getPsc())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getIco() == null) ? "" : "IČ: " + orgR.getIco())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getTelefon() == null) ? "" : orgR.getTelefon())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getEMail() == null) ? "" : orgR.getEMail())
                            + "</td>"
                            + "</tr>"
                            + "</table> "
                            + "<div id = \"shrnutiObjednavky\">";

                    adresaMail = arPr.get(p).getOsoba().getEMail();
                    adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }

                    for (String am : adresyMailList) {

                        PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ",
                                textMail);
                        pm.send();
                    }
                }

            }
            try {
                String url = "/ekcvjs.jsp";
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/potvrzeniOsOrg")) {
            ArrayList<PrihlaskyRozpisy> arPr = new ArrayList<PrihlaskyRozpisy>();
            StavyPrihlasek sp = new StavyPrihlasek(1); //prihlasen
            PrihlaskyDruhy pd = new PrihlaskyDruhy(4);  // ekcvjs
            DruhyPrihlasek dp = new DruhyPrihlasek(1); // bylo 3
            DruhyFaktur df = druhyFakturFacade.findById(1);
           
            if ((Organizace) session.getAttribute("organizaceFakturace") != null) {
                orgR = (Organizace) session.getAttribute("organizaceFakturace");
            }

            for (int i = 0; i < cart.getItems().size(); i++) {
                ShoppingCartItem sci = cart.getItems().get(i);               
                PrihlaskyRozpisy p = new PrihlaskyRozpisy();
                p.setAkce(cart.getItems().get(i).getProduct());
                p.setOsoba(klientR);
                p.setObjednavatelOrg(orgR);
                p.setPlatceOrg(orgR);
                p.setOdberatelOrg(orgR);
                p.setStavprihl(sp);
                p.setPrihlasenDodatecne(false);
                p.setDruhprihl(dp);
                p.setDruhfakt(df);
                p.setObdobi(sci.getProduct().getAkceObdobi());
                p.setPrihlaseniZpusob(pd);
                p = prihlaskyFacade.prihlasit(p);
                arPr.add(p);

            }
            request.setAttribute("orderedProducts", arPr);
            double cenaCelkem = cart.getTotal();
            request.setAttribute("cenaCelkem", cenaCelkem);

            cart.clear();

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("selectedCenter", "WEB-INF/view/potvrzeniOsOrg.jsp");

            java.text.NumberFormat nf2 = java.text.NumberFormat.getInstance();

            String textMail = "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_objednavky") + "</p>"
                    + "<div id=\"kcvjsInfo\">"
                    + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                    + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                    + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                    + "<div id=\"horizontRuler\"><hr></div> "
                    + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                    + "</div> "
                    + "<div class=\"summaryColumn\" > "
                    + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                    + "<tr class=\"header\"> "
                    + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_rezervace") + "</th>"
                    + "</tr> "
                    + "<tr class=\"tableHeading\"> "
                    + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                    + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                    + "</tr> ";
            for (int i = 0; i < arPr.size(); i++) {
                textMail += "<tr class= 'lightBlue'\"> "
                        + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                        + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                        + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                        + "</td> "
                        + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                        + "</td> "
                        + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                        + "</td> "
                        + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                        + "</td> "
                        + "</tr> ";
            }
            textMail += "<tr class=\"lightBlue\"> "
                    + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                    + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                    + "</tr> "
                    + "</table>"
                    + "</div> "
                    + "<div class=\"summaryObjednavatel\" > "
                    + "<table id=\"potvrzeniObjTable\"> "
                    + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                    + "<tr>"
                    + "<td>" + ((orgR.getNazev() == null) ? "" : orgR.getNazev())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getAdresa() == null) ? "" : orgR.getAdresa())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getMesto() == null) ? "" : orgR.getMesto())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getPsc() == null) ? "" : orgR.getPsc())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getIco() == null) ? "" : "IČ: " + orgR.getIco())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getTelefon() == null) ? "" : orgR.getTelefon())
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>" + ((orgR.getEMail() == null) ? "" : orgR.getEMail())
                    + "</td>"
                    + "</tr>"
                    + "</table> "
                    + "<div id = \"shrnutiObjednavky\">";

            String adresaMail = orgR.getEMail();
            List<String> adresyMailList = new ArrayList();
            if (adresaMail.contains(",")) {
                adresyMailList = Arrays.asList(adresaMail.split(","));
            } else {
                adresyMailList.add(adresaMail);
            }

            for (String am : adresyMailList) {

                PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ - " + arPr.get(0).getOsoba().getJmeno() + " " + arPr.get(0).getOsoba().getPrijmeni(),
                        textMail);
                pm.send();
            }

            for (int p = 0; p < arPr.size(); p++) {
                if (arPr.get(p).getOsoba().getEMail() != null) {
                    textMail = "Dobrý den, <br/> "
                            + "právě jste se přihlásili na kurz placený Vaším zaměstnavatelem <br/> "
                            + "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:left; width:609px;\">" + ((orgR.getNazev() == null) ? "" : orgR.getNazev()) + "</p>"
                            + "na vzdělávací programy shrnuté v objednávce. <br/> "
                            + "Zároveň byla zaslán e-mail Vašemu zaměstnavateli o provedené objednávce. Po skončení vzdělávacího kurzu bude Vašemu zaměstnavateli vystavena a zaslána faktura. <br/>"
                            + "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_objednavky") + "</p>"
                            + "<div id=\"kcvjsInfo\">"
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                            + "<div id=\"horizontRuler\"><hr></div> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                            + "</div> "
                            + "<div class=\"summaryColumn\" > "
                            + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                            + "<tr class=\"header\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_objednavka") + "</th>"
                            + "</tr> "
                            + "<tr class=\"tableHeading\"> "
                            + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                            + "</tr> ";
                    for (int i = 0; i < arPr.size(); i++) {
                        textMail += "<tr class= 'lightBlue'\"> "
                                + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                                + "</td> "
                                + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                                + "</td> "
                                + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                                + "</td> "
                                + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                                + "</td> "
                                + "</tr> ";
                    }
                    textMail += "<tr class=\"lightBlue\"> "
                            + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                            + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                            + "</tr> "
                            + "</table>"
                            + "</div> "
                            + "<div class=\"summaryObjednavatel\" > "
                            + "<table id=\"potvrzeniObjTable\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                            + "<tr>"
                            + "<td>" + ((orgR.getNazev() == null) ? "" : orgR.getNazev())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getAdresa() == null) ? "" : orgR.getAdresa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getMesto() == null) ? "" : orgR.getMesto())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getPsc() == null) ? "" : orgR.getPsc())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getIco() == null) ? "" : "IČ: " + orgR.getIco())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getTelefon() == null) ? "" : orgR.getTelefon())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((orgR.getEMail() == null) ? "" : orgR.getEMail())
                            + "</td>"
                            + "</tr>"
                            + "</table> "
                            + "<div id = \"shrnutiObjednavky\">";

                    adresaMail = arPr.get(p).getOsoba().getEMail();
                    adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }

                    for (String am : adresyMailList) {

                        PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ",
                                textMail);
                        pm.send();
                    }
                }

            }
            try {
                String url = "/ekcvjs.jsp";
                session.removeAttribute("organizaceFakturace");
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals("/potvrzeni")) {
            if (cart.getItems().size() > 0) {

                if (cart.getItems().get(0).getProduct().getPrimObor().getOborId() > 499 && cart.getItems().get(0).getProduct().getPrimObor().getOborId() < 600) {
                    ArrayList<PrihlaskyRozpisyJs> arPr = new ArrayList<PrihlaskyRozpisyJs>();
                    StavyPrihlasek sp = new StavyPrihlasek(10);
                    DruhyPrihlasek dp = new DruhyPrihlasek(3);
                    PrihlaskyDruhy pd = new PrihlaskyDruhy(4);
                    DruhyFaktur df = druhyFakturFacade.findById(6); // new DruhyFaktur(6);
                    List faktury = new ArrayList();

                    for (int i = 0; i < cart.getItems().size(); i++) {

                        PrihlaskyRozpisyJs p = new PrihlaskyRozpisyJs();
                        p.setAkce(cart.getItems().get(i).getProduct());
                        p.setOsoba(klientR);
                        p.setObjednavatelOs(klientR);
                        p.setPlatceOs(klientR);
                        p.setOdberatelOs(klientR);
                        p.setStavprihl(sp);
                        p.setPrihlasenDodatecne(false);
                        p.setDruhprihl(dp);
                        p.setDruhfakt(df);
                        p.setObdobi(cart.getItems().get(i).getProduct().getAkceObdobi());
                        p.setPrihlaseniZpusob(new PrihlaskyDruhy(4));
                        p = prihlaskyJSFacade.prihlasit(p);
                        vyberPrihlJSFaktFacade.prihlasit(p);

                        arPr.add(p);
                    }
                    faktury = vyberPrihlJSFaktFacade.fakturujPrihlaskyJSZaloha(arPr.get(0));
                    request.setAttribute("orderedProducts", arPr);

                    double cenaCelkem = cart.getTotal();
                    request.setAttribute("cenaCelkem", cart.getTotal());
                    cart.clear();
                    request.setAttribute("selectedCenterId", 10);
                    request.setAttribute("selectedCenter", "WEB-INF/view/potvrzeni.jsp");

                    java.text.NumberFormat nf2 = java.text.NumberFormat.getInstance();

                    String textMail = "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_rezervace") + "</p>"
                            + "<div id=\"kcvjsInfo\">"
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                            + "<div id=\"horizontRuler\"><hr></div> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                            + "</div> "
                            + "<div class=\"summaryColumn\" > "
                            + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                            + "<tr class=\"header\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_rezervace") + "</th>"
                            + "</tr> "
                            + "<tr class=\"tableHeading\"> "
                            + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                            + "</tr> ";
                    for (int i = 0; i < arPr.size(); i++) {
                        textMail += "<tr class= 'lightBlue'\"> "
                                + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                                + "</td> "
                                + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                                + "</td> "
                                + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                                + "</td> "
                                + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                                + "</td> "
                                + "</tr> ";
                    }
                    textMail += "<tr class=\"lightBlue\"> "
                            + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                            + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                            + "</tr> "
                            + "</table>"
                            + "</div> "
                            + "<div class=\"summaryObjednavatel\" > "
                            + "<table id=\"potvrzeniObjTable\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                            + "<tr>"
                            + "<td>" + ((klientR.getTitulPred() == null) ? "" : klientR.getTitulPred()) + " " + ((klientR.getJmeno() == null) ? "" : klientR.getJmeno()) + " " + ((klientR.getPrijmeni() == null) ? "" : klientR.getPrijmeni()) + " " + ((klientR.getTitulZa() == null) ? "" : klientR.getTitulZa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getAdresa() == null) ? "" : klientR.getAdresa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getMesto() == null) ? "" : klientR.getMesto())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getPsc() == null) ? "" : klientR.getPsc())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getTelefon() == null) ? "" : klientR.getTelefon())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getEMail() == null) ? "" : klientR.getEMail())
                            + "</td>"
                            + "</tr>"
                            + "</table> "
                            + "<div id = \"shrnutiObjednavky\">";
                    textMail += "<p class=\"kcvjsInfo\">-----------------------------------------------------------------------------------------------</p> "
                            + "<p class=\"kcvjsInfo\">INFORMACE O PLATBĚ</p> "
                            + "<p class=\"kcvjsInfo\">-----------------------------------------------------------------------------------------------</p> "
                            + "<p class=\"kcvjsInfo\">Úhradu proveďte do 7 dní. Pokud pohlednávka nebude uhrazena v termínu, rezervace bude automaticky zrušena a Vaše místo postoupeno dalšímu zájemci.</p> "
                            + "<p class=\"kcvjsInfo\">Úhradu je možné provést převodem na níže uvedený účet, případně lze platbu provést osobně v zápisové kanceláři KCVJŠ, sady 5. května 42, 301 00 Plzeň. "
                            + "O prázdninách (1.7. - 31. 8.) má zápisová kancelář upravenou otevírací dobu, naleznete ji v sekci Jazyková škola - Ke stažení.</p> "
                            + "<p class=\"kcvjsInfo\">Bankovní spojení: ČSOB</p> "
                            + "<p class=\"kcvjsInfo\">Číslo účtu: 198834747/0300</p> "
                            + "<p class=\"kcvjsInfo\">Variabilní symbol: " + faktury.get(0).toString() + "</p> "
                            + "<p class=\"kcvjsInfo\">Částka: " + knihaFakturFacade.findById((Integer) faktury.get(0)).getFakturovano() + " Kč</p> "
                            + "<p class=\"kcvjsInfo\">Po uhrazení zálohové faktury bude do 14 dní vystaven daňový doklad a naleznete jej po přihlášení v sekci Dokumenty.</p> ";

                    String adresaMail = klientR.getEMail();
                    List<String> adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }

                    for (String am : adresyMailList) {

                        PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ",
                                textMail);
                        pm.send();
                    }
                } else {
                    ArrayList<PrihlaskyRozpisy> arPr = new ArrayList<PrihlaskyRozpisy>();

                    StavyPrihlasek sp = new StavyPrihlasek(10);
                    DruhyPrihlasek dp = new DruhyPrihlasek(3);
                    PrihlaskyDruhy pd = new PrihlaskyDruhy(4);
                    DruhyFaktur df = druhyFakturFacade.findById(6);
                    List faktury = new ArrayList();

                    for (int i = 0; i < cart.getItems().size(); i++) {

                        PrihlaskyRozpisy p = new PrihlaskyRozpisy();
                        p.setAkce(cart.getItems().get(i).getProduct());
                        p.setOsoba(klientR);
                        p.setObjednavatelOs(klientR);
                        p.setPlatceOs(klientR);
                        p.setOdberatelOs(klientR);
                        p.setStavprihl(sp);
                        p.setPrihlasenDodatecne(false);
                        p.setDruhprihl(dp);
                        p.setDruhfakt(df);
                        p.setObdobi(cart.getItems().get(i).getProduct().getAkceObdobi());
                        p.setPrihlaseniZpusob(new PrihlaskyDruhy(4));
                        p = prihlaskyFacade.prihlasit(p);
                        vyberPrihlFaktFacade.prihlasit(p);

                        arPr.add(p);
                    }
                    request.setAttribute("orderedProducts", arPr);
                    faktury = vyberPrihlFaktFacade.fakturujPrihlaskyJSZaloha(arPr.get(0));
                    double cenaCelkem = cart.getTotal();
                    request.setAttribute("cenaCelkem", cart.getTotal());
                    cart.clear();
                    request.setAttribute("selectedCenterId", 10);
                    request.setAttribute("selectedCenter", "WEB-INF/view/potvrzeni.jsp");

                    java.text.NumberFormat nf2 = java.text.NumberFormat.getInstance();

                    String textMail = "<p style=\"font-weight :bold; height:23px; margin:auto; padding-top:3px; text-align:center; width:609px;\">" + zt.getWebProp().nazev("prijeti_rezervace") + "</p>"
                            + "<div id=\"kcvjsInfo\">"
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS1") + "</p> "
                            + "<p style=\"font-weight:bold;\">" + zt.getWebProp().nazev("obj_KCVJS2") + "</p> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS3") + "</p> "
                            + "<div id=\"horizontRuler\"><hr></div> "
                            + "<p class=\"kcvjsInfo\">" + zt.getWebProp().nazev("obj_KCVJS4") + "</p>"
                            + "</div> "
                            + "<div class=\"summaryColumn\" > "
                            + "<table id=\"orderSummaryTable\" class=\"detailsTable\"> "
                            + "<tr class=\"header\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\" colspan=\"4\">" + zt.getWebProp().nazev("shrnuti_rezervace") + "</th>"
                            + "</tr> "
                            + "<tr class=\"tableHeading\"> "
                            + "<td>" + zt.getWebProp().nazev("tab_cislo") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_osoba") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_termin") + "</td> "
                            + "<td>" + zt.getWebProp().nazev("tab_cena") + "</td> "
                            + "</tr> ";
                    for (int i = 0; i < arPr.size(); i++) {
                        textMail += "<tr class= 'lightBlue'\"> "
                                + "<td width=\"120\"> " + arPr.get(i).getAkce().getAkceCislo().substring(0, 2) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(2, 6) + "-"
                                + arPr.get(i).getAkce().getAkceCislo().substring(6, 8)
                                + "</td> "
                                + "<td width=\"200\"> " + arPr.get(i).getOsoba().getJmeno() + " " + arPr.get(i).getOsoba().getPrijmeni()
                                + "</td> "
                                + "<td width=\"300\"> " + arPr.get(i).getAkce().getTerminObecny()
                                + "</td> "
                                + "<td width=\"130\"> <p style=\"text-align: right;\" class=\"cenaTabulka\">" + nf2.format(arPr.get(i).getAkce().getUcastnickyPoplatek()) + " Kč</p> "
                                + "</td> "
                                + "</tr> ";
                    }
                    textMail += "<tr class=\"lightBlue\"> "
                            + "<td colspan=\"3\" style=\"background: none repeat scroll 0 0 #ECECEC;\" id=\"totalCellLeft\"><strong>" + zt.getWebProp().nazev("cena_celkem") + ":</strong></td> "
                            + "<td colspan=\"1\" style=\"background: none repeat scroll 0 0 #ECECEC; text-align: right;\" id=\"totalCellRight\">" + nf2.format(cenaCelkem) + " Kč</td> "
                            + "</tr> "
                            + "</table>"
                            + "</div> "
                            + "<div class=\"summaryObjednavatel\" > "
                            + "<table id=\"potvrzeniObjTable\"> "
                            + "<th style=\"background:none repeat scroll 0 0 lightgrey;\">" + zt.getWebProp().nazev("objednavatel") + "</th>"
                            + "<tr>"
                            + "<td>" + ((klientR.getTitulPred() == null) ? "" : klientR.getTitulPred()) + " " + ((klientR.getJmeno() == null) ? "" : klientR.getJmeno()) + " " + ((klientR.getPrijmeni() == null) ? "" : klientR.getPrijmeni()) + " " + ((klientR.getTitulZa() == null) ? "" : klientR.getTitulZa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getAdresa() == null) ? "" : klientR.getAdresa())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getMesto() == null) ? "" : klientR.getMesto())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getPsc() == null) ? "" : klientR.getPsc())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getTelefon() == null) ? "" : klientR.getTelefon())
                            + "</td>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + ((klientR.getEMail() == null) ? "" : klientR.getEMail())
                            + "</td>"
                            + "</tr>"
                            + "</table> "
                            + "<div id = \"shrnutiObjednavky\">";
                    textMail += "<p class=\"kcvjsInfo\">-----------------------------------------------------------------------------------------------</p> "
                            + "<p class=\"kcvjsInfo\">INFORMACE O PLATBĚ</p> "
                            + "<p class=\"kcvjsInfo\">-----------------------------------------------------------------------------------------------</p> "
                            + "<p class=\"kcvjsInfo\">Úhradu proveďte do 7 dní. Pokud pohlednávka nebude uhrazena v termínu, rezervace bude automaticky zrušena a Vaše místo postoupeno dalšímu zájemci.</p> "
                            + "<p class=\"kcvjsInfo\">Úhradu je možné provést převodem na níže uvedený účet, případně lze platbu provést osobně v zápisové kanceláři KCVJŠ, sady 5. května 42, 301 00 Plzeň. "
                            + "O prázdninách (1.7. - 31. 8.) má zápisová kancelář upravenou otevírací dobu, naleznete ji v sekci Jazyková škola - Ke stažení.</p> "
                            + "<p class=\"kcvjsInfo\">Bankovní spojení: ČSOB</p> "
                            + "<p class=\"kcvjsInfo\">Číslo účtu: 198834747/0300</p> "
                            + "<p class=\"kcvjsInfo\">Variabilní symbol: " + faktury.get(0).toString() + "</p> "
                            + "<p class=\"kcvjsInfo\">Částka: " + knihaFakturFacade.findById((Integer) faktury.get(0)).getFakturovano() + " Kč</p> "
                            + "<p class=\"kcvjsInfo\">Po uhrazení zálohové faktury bude do 14 dní vystaven daňový doklad a naleznete jej po přihlášení v sekci Dokumenty.</p> ";

                    String adresaMail = klientR.getEMail();
                    List<String> adresyMailList = new ArrayList();
                    if (adresaMail.contains(",")) {
                        adresyMailList = Arrays.asList(adresaMail.split(","));
                    } else {
                        adresyMailList.add(adresaMail);
                    }

                    for (String am : adresyMailList) {

                        PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Objednávka v eKCVJŠ",
                                textMail);
                        pm.send();
                    }
                }

                try {
                    String url = "/ekcvjs.jsp";
                    //  request.getRequestDispatcher(url).forward(request, response);
                    getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (userPath.equals("/registrace")) {
            Uzivatele u = null;
            Osoby o = osobyPrihlaseni.findPodleMaxId();
           
            // extract user data from request
            java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy", new Locale("cs, CZ")); //java.text.DateFormat.getDateInstance();
            String username = request.getParameter("loginJmeno");
            String hesloPrvni = request.getParameter("hesloPrvni");
            String hesloZnovu = request.getParameter("hesloZnovu");

            zt.setPotvrzeni("yes");

            if (zt.getDruhUzivatel() == 1 || zt.getDruhUzivatel() == 0) {
                //zt.setNarodnost(request.getParameterValues("vyberNarodnost")[0]);
                //zt.setPrislusnost(request.getParameterValues("vyberPrislusnost")[0]);

                if (!((username == null) || (username.isEmpty()))) {

                    Pattern pattern = Pattern.compile("\\s");
                    Matcher matcher = pattern.matcher(username);
                    boolean found = matcher.find();
                    if (found == true) {
                        request.setAttribute("chybaRegistrace", "loginsmezerou");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    }
                    if (!username.equals(Normalizer.normalize(username, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""))) {
                        request.setAttribute("chybaRegistrace", "loginsdiakritikou");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    }

                }
                
                if ((username == null) || (username.isEmpty())) {
                   
                    try {
                        request.setAttribute("chybaRegistrace", "prazdnyLogin");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if ((hesloPrvni.isEmpty() == false) && (hesloZnovu.isEmpty() == false) && (hesloPrvni.equals(hesloZnovu))) {
                    if (hesloPrvni.length() < 6 || hesloZnovu.length() < 6) {
                        try {
                            request.setAttribute("chybaRegistrace", "kratkeHeslo");
                            request.setAttribute("selectedCenter", "registrace.jsp");
                            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        u = uzivatelPrihlaseni.registerUser(username, hesloPrvni);
                        if (u == null) {
                            try {
                                request.setAttribute("chybaRegistrace", "existujiciLogin");
                                request.setAttribute("selectedCenter", "registrace.jsp");
                                getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                } else {
                    try {
                        request.setAttribute("chybaRegistrace", "spatnaHesla");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                Osoby klient = new Osoby();
                if (request.getParameter("titulpred").isEmpty()) {
                    klient.setTitulPred(null);
                } else {
                    klient.setTitulPred(request.getParameter("titulpred"));
                }
                if (request.getParameter("jmeno").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdneJmeno");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setJmeno(request.getParameter("jmeno"));
                }
                if (request.getParameter("prijmeni").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdnePrijmeni");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setPrijmeni(request.getParameter("prijmeni"));
                }

                if (request.getParameter("titulza").isEmpty()) {
                    klient.setTitulZa(null);
                } else {
                    klient.setTitulZa(request.getParameter("titulza"));
                }
                if (Boolean.parseBoolean(request.getParameter("neexRodneCislo")) == false) {
                    if (request.getParameter("rodnecislo") == null || request.getParameter("rodnecislo").isEmpty()) {
                        klient.setRodneCislo(null);
                    } else {
                        Osoby rcOsoba = osobyPrihlaseni.findPodleRodneCislo(request.getParameter("rodnecislo"));
                        if (rcOsoba != null) {
                            boolean platneRC = false;
                            try {

                                ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                                while (q.next()) {
                                    platneRC = q.getBoolean(1);
                                }
                                PripojeniDB.rs.close();
                                PripojeniDB.pstmt.close();
                                PripojeniDB.con.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (platneRC == true) {
                                klient.setRodneCislo(request.getParameter("rodnecislo"));
                            } else {
                                try {
                                    request.setAttribute("chybaRegistrace", "spatneRC");
                                    request.setAttribute("selectedCenter", "registrace.jsp");
                                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                                    return;
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        } else {
                            boolean platneRC = false;
                            try {

                                ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                                while (q.next()) {
                                    platneRC = q.getBoolean(1);
                                }
                                PripojeniDB.rs.close();
                                PripojeniDB.pstmt.close();
                                PripojeniDB.con.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (platneRC == true) {
                                klient.setRodneCislo(request.getParameter("rodnecislo"));
                            } else {
                                try {
                                    request.setAttribute("chybaRegistrace", "spatneRC");
                                    request.setAttribute("selectedCenter", "registrace.jsp");
                                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                                    return;
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }

                    }
                } else {
                    klient.setRodneCislo(null);
                }
                try {
                    klient.setDatumNarozeni(df.parse(request.getParameter("datumnarozeni")));
                } catch (Exception e) {
                    try {
                        PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", "tomas.gotzy@7data.eu", "chyba", e.getMessage());
                        pm.send();
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdneDatumNarozeni");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                klient.setMistoNarozeni(request.getParameter("mistonarozeni"));

                klient.setNarodnost(null); //request.getParameterValues("vyberNarodnost")[0]);
                klient.setStatniPrislusnost(null); //(request.getParameterValues("vyberPrislusnost")[0]);

                if (request.getParameter("adresa").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdnaAdresa");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setAdresa(request.getParameter("adresa"));
                }
                if (request.getParameter("mesto").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdneMesto");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setMesto(request.getParameter("mesto"));
                }
                if (request.getParameter("psc").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "prazdnePSC");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setPsc(request.getParameter("psc"));
                }

                if (request.getParameter("email").isEmpty()) {
                    try {
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiEmail");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (osobyPrihlaseni.findPocetPodleEmail(request.getParameter("email")) > 0) {
                        try {
                            request.setAttribute("chybaRegistrace", "duplicitniEmail");
                            request.setAttribute("selectedCenter", "registrace.jsp");
                            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        klient.setEMail(request.getParameter("email"));
                    }
                }
                if (request.getParameter("telefon").isEmpty()) {
                    klient.setTelefon(null);
                } else {
                    klient.setTelefon(request.getParameter("telefon"));
                }

               
                Date datumAktualni = new Date();
                if ((Boolean.parseBoolean(request.getParameter("nezletilaOsoba")) == false) && (klient.getDatumNarozeni().getTime() + 567648000000L < datumAktualni.getTime())) {
                    Osoby reg = osobyPrihlaseni.registerOsoby(klient);
                    if (reg == null) {
                        try {
                            uzivatelPrihlaseni.remove(u);
                            request.setAttribute("chybaRegistrace", "neplatneUdaje");
                            request.setAttribute("selectedCenter", "registrace.jsp");
                            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        u.setUzivateleOsobyId(reg);
                        uzivatelPrihlaseni.updateUser(u);
                        if (reg.getEMail() != null) {
                            try {

                                String adresaMail = reg.getEMail();
                                List<String> adresyMailList = new ArrayList();
                                if (adresaMail.contains(",")) {
                                    adresyMailList = Arrays.asList(adresaMail.split(","));
                                } else {
                                    adresyMailList.add(adresaMail);
                                }

                                for (String am : adresyMailList) {

                                    PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Registrace KCVJŠ",
                                            "Dobrý den, <br/> "
                                            + "zaregistrovali jste se na stránkách <a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>. Po přihlášení je možné v sekci <b>Uživatelské údaje</b> si zaregistrované údaje změnit.  <br/> "
                                            + "<u>Vaše přístupové údaje:</u>  <br/> <br/>"
                                            + "Přihlašovací jméno : " + u.getUzivateleJmeno() + "  <br/> "
                                            + "Heslo : " + hesloPrvni /*u.getUzivateleHeslo()*/ + "  <br/>  <br/> "
                                            + "S pozdravem,  <br/>"
                                            + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");

                                    pm.send();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String url = "/index.jsp";
                        if (reg != null) {
                            request.setAttribute("user", u);
                            request.setAttribute("klientPrihlaseni", reg);
                            request.setAttribute("selectedCenter", "potvrzeniRegistrace.jsp");
                        } else {
                            request.setAttribute("selectedCenter", "registrace.jsp");
                        }
                        try {
                            //  request.getRequestDispatcher(url).forward(request, response);
                            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    session.setAttribute("user", u);
                    session.setAttribute("osobaReg", klient);
                    String url = "/index.jsp";
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");

                    try {
                        getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            } else {

                if ((hesloPrvni.isEmpty() == false) && (hesloZnovu.isEmpty() == false) && (hesloPrvni.equals(hesloZnovu))) {
                    u = uzivatelPrihlaseni.registerUser(username, hesloPrvni);
                    if (u == null) {
                        try {
                            request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                            request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                            request.setAttribute("chybaRegistrace", "existujiciLogin");
                            request.setAttribute("selectedCenter", "registrace.jsp");
                            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        request.setAttribute("chybaRegistrace", "spatnaHesla");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                Organizace org = new Organizace();
                if (request.getParameter("nazev").isEmpty()) {
                    org.setNazev(null);
                } else {
                    org.setNazev(request.getParameter("nazev"));
                }
                if (request.getParameter("nazevPlny1").isEmpty()) {
                    org.setNazevPlny1(request.getParameter("nazev"));
                } else {
                    org.setNazevPlny1(request.getParameter("nazevPlny1"));
                }
                if (request.getParameter("ic").isEmpty()) {
                    org.setIco(null);
                } else {
                    if (organizacePrihlaseni.findPodleIco(request.getParameter("ic")) != null) {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        request.setAttribute("chybaRegistrace", "duplIC");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } else {
                        org.setIco(request.getParameter("ic"));
                    }

                }
                if (request.getParameter("dic").isEmpty()) {
                    org.setDic(null);
                } else {
                    org.setDic(request.getParameter("dic"));
                }
                if (request.getParameter("adresa").isEmpty()) {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiAdresa");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    org.setAdresa(request.getParameter("adresa"));
                }
                if (request.getParameter("mesto").isEmpty()) {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiMesto");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    org.setMesto(request.getParameter("mesto"));
                }
                if (request.getParameter("psc").isEmpty()) {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiPSC");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    org.setPsc(request.getParameter("psc"));
                }
                if (request.getParameter("telefon").isEmpty()) {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiTelefon");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    org.setTelefon(request.getParameter("telefon"));
                }
                if (request.getParameter("email").isEmpty()) {
                    try {
                        request.setAttribute("katOrgTypy", katOrgTypyfacade.findAll());
                        request.setAttribute("katOrgPolozky", katOrgPolozkyfacade.findByKategorieTyp(zt.getKatOrgTyp()));
                        uzivatelPrihlaseni.remove(u);
                        request.setAttribute("chybaRegistrace", "chybiEmail");
                        request.setAttribute("selectedCenter", "registrace.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    org.setEMail(request.getParameter("email"));
                }
                if (request.getParameter("emailFakturace").isEmpty()) {
                    org.seteMailFakturace(null);
                } else {
                    org.seteMailFakturace(request.getParameter("emailFakturace"));
                }
                if (request.getParameter("fax").isEmpty()) {
                    org.setFax(null);
                } else {
                    org.setFax(request.getParameter("fax"));
                }
                org.setKatOrgPolozky(katOrgPolozkyfacade.findById(zt.getKatOrgTyp(), zt.getKatOrgDruh()));
                org.setKatorgtyp(katOrgTypyfacade.findById(zt.getKatOrgTyp()));
                org.setRegionOkres(regionyOkresyFacade.findById(999));

                Organizace reg = organizacePrihlaseni.registerOrganizace(org);

                String url = "/index.jsp";
                if (reg != null) {
                    u.setUzivateleOrganizaceId(reg);
                    uzivatelPrihlaseni.updateUser(u);
                    request.setAttribute("organizacePrihlaseni", reg);
                    WebPanely wp = panelyFacade.findByOdkazKategorie("potvrzeniRegistraceOrg.jsp", kategorieFacade.findById(70));
                    Collection<WebPanelyData> panelyData = webPanelyDataFacade.findByStranka(wp);
                    request.setAttribute("panelyData", panelyData);
                    request.setAttribute("selectedCenter", "potvrzeniRegistraceOrg.jsp");

                } else {
                    request.setAttribute("selectedCenter", "registrace.jsp");
                }

                if (reg.getEMail() != null) {
                    try {

                        String adresaMail = reg.getEMail();
                        List<String> adresyMailList = new ArrayList();
                        if (adresaMail.contains(",")) {
                            adresyMailList = Arrays.asList(adresaMail.split(","));
                        } else {
                            adresyMailList.add(adresaMail);
                        }

                        for (String am : adresyMailList) {

                            PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Registrace KCVJŠ",
                                    "Dobrý den, <br/> "
                                    + "zaregistrovali jste se na stránkách <a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>. Po přihlášení je možné v sekci <b>Uživatelské údaje</b> si zaregistrované údaje změnit.  <br/> "
                                    + "<u>Vaše přístupové údaje:</u>  <br/> <br/>"
                                    + "Přihlašovací jméno : " + u.getUzivateleJmeno() + "  <br/><br/> "
                                    + "Heslo : " + hesloPrvni + "  <br/>  <br/> "
                                    + "S pozdravem,  <br/>"
                                    + "KCVJŠ Plzeň (<a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>)");

                            pm.send();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                try {
                    //  request.getRequestDispatcher(url).forward(request, response);
                    getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (userPath.equals("/preRegistrace")) {
            String url = "/index.jsp";
            request.setAttribute("selectedCenter", "preRegistrace.jsp");

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals(
                "/registraceZakZastupce")) {
            Uzivatele u = null;

            OsobyDalsiKontakty zakZastupce = new OsobyDalsiKontakty();

            if (request.getParameter("jmenoZastupce").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "prazdneJmeno");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setJmeno(request.getParameter("jmenoZastupce"));
            }
            if (request.getParameter("prijmeniZastupce").isEmpty()) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "prazdnePrijmeni");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setPrijmeni(request.getParameter("prijmeniZastupce"));
            }

            if (request.getParameter("adresaZastupce").isEmpty()) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "prazdnaAdresa");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setAdresa(request.getParameter("adresaZastupce"));
            }

            if (request.getParameter("mestoZastupce").isEmpty()) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "prazdneMesto");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setMesto(request.getParameter("mestoZastupce"));
            }
            if (request.getParameter("pscZastupce").isEmpty()) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "prazdnePSC");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setPsc(request.getParameter("pscZastupce"));
            }

            if (request.getParameter("emailZastupce").isEmpty()) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "chybiEmail");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                zakZastupce.setEMail(request.getParameter("emailZastupce"));
            }
            if (request.getParameter("telefonZastupce").isEmpty()) {
                zakZastupce.setTelefon(null);
            } else {
                zakZastupce.setTelefon(request.getParameter("telefonZastupce"));
            }

            u = (Uzivatele) session.getAttribute("user");
            Osoby reg = osobyPrihlaseni.registerOsoby((Osoby) session.getAttribute("osobaReg"));
            zakZastupce.setOsobaId(reg);
            osobyZakZastupceFacade.registerOsoby(zakZastupce);

            if (reg == null) {
                try {
                    uzivatelPrihlaseni.remove(u);
                    request.setAttribute("chybaRegistrace", "neplatneUdaje");
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                u.setUzivateleOsobyId(reg);
                uzivatelPrihlaseni.updateUser(u);
                if (reg.getEMail() != null) {
                    try {

                        String adresaMail = reg.getEMail();
                        List<String> adresyMailList = new ArrayList();
                        if (adresaMail.contains(",")) {
                            adresyMailList = Arrays.asList(adresaMail.split(","));
                        } else {
                            adresyMailList.add(adresaMail);
                        }

                        for (String am : adresyMailList) {

                            PoslatMail pm = new PoslatMail("no-reply@kcvjs.cz", am, "Registrace KCVJŠ",
                                    "Dobrý den, \n "
                                    + "zaregistrovali jste se na stránkách <a href=\"www.kcvjs.cz\">www.kcvjs.cz<a>. Po přihlášení je možné v sekci <b>Uživatelské údaje</b> si zaregistrované údaje změnit.\n \n "
                                    + "<u>Vaše přístupové údaje:</u>"
                                    + "Přihlašovací jméno : " + u.getUzivateleJmeno() + " \n "
                                    + "Heslo : " + u.getUzivateleHeslo() + " \n \n "
                                    + "S pozdravem, \n"
                                    + "KCVJŠ Plzeň (www.kcvjs.cz)");

                            pm.send();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String url = "/index.jsp";
                if (reg != null) {
                    request.setAttribute("user", u);
                    request.setAttribute("klientPrihlaseni", reg);
                    request.setAttribute("selectedCenter", "potvrzeniRegistrace.jsp");
                } else {
                    request.setAttribute("selectedCenter", "registraceZastupce.jsp");
                }
                try {
                    //  request.getRequestDispatcher(url).forward(request, response);
                    getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        } else if (userPath.equals(
                "/novaOsobaOrg")) {
            java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy", new Locale("cs, CZ"));

            Osoby klient = new Osoby();
            if (request.getParameter("titulpred").isEmpty()) {
                klient.setTitulPred(null);
            } else {
                klient.setTitulPred(request.getParameter("titulpred"));
            }
            if (request.getParameter("jmeno").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "prazdneJmeno");
                    request.setAttribute("selectedCenter", "registrace.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                klient.setJmeno(request.getParameter("jmeno"));
            }
            if (request.getParameter("prijmeni").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "prazdnePrijmeni");
                    request.setAttribute("selectedCenter", "registrace.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                klient.setPrijmeni(request.getParameter("prijmeni"));
            }
            if (request.getParameter("titulza").isEmpty()) {
                klient.setTitulZa(null);
            } else {
                klient.setTitulZa(request.getParameter("titulza"));
            }
            if (Boolean.parseBoolean(request.getParameter("neexRodneCislo")) == false) {
                if (request.getParameter("rodnecislo") == null) {
                    try {
                        request.setAttribute("chybaRegistrace", "neniRodneCislo");
                        request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    Osoby rcOsoba = osobyPrihlaseni.findPodleRodneCislo(request.getParameter("rodnecislo"));
                    if (rcOsoba != null) {
                        boolean platneRC = false;
                        try {

                            ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                            while (q.next()) {
                                platneRC = q.getBoolean(1);
                            }
                            PripojeniDB.rs.close();
                            PripojeniDB.pstmt.close();
                            PripojeniDB.con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (platneRC == true) {
                            klient.setRodneCislo(request.getParameter("rodnecislo"));
                        } else {
                            try {
                                request.setAttribute("chybaRegistrace", "spatneRC");
                                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                                getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else {
                        boolean platneRC = false;
                        try {

                            ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                            while (q.next()) {
                                platneRC = q.getBoolean(1);
                            }
                            PripojeniDB.rs.close();
                            PripojeniDB.pstmt.close();
                            PripojeniDB.con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (platneRC == true) {
                            klient.setRodneCislo(request.getParameter("rodnecislo"));
                        } else {
                            try {
                                request.setAttribute("chybaRegistrace", "spatneRC");
                                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                                getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                                return;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                }
            } else {
                klient.setRodneCislo(null);
            }
            try {
                klient.setDatumNarozeni(df.parse(request.getParameter("datumnarozeni")));
            } catch (Exception e) {
                klient.setDatumNarozeni(null);
            }
            klient.setMistoNarozeni(request.getParameter("mistonarozeni"));
            klient.setNarodnost(request.getParameterValues("vyberNarodnost")[0]);
            klient.setStatniPrislusnost(request.getParameterValues("vyberPrislusnost")[0]);
            if (request.getParameter("adresa").isEmpty()) {
                klient.setAdresa(null);
            } else {
                klient.setAdresa(request.getParameter("adresa"));
            }
            if (request.getParameter("mesto").isEmpty()) {
                klient.setMesto(null);
            } else {
                klient.setMesto(request.getParameter("mesto"));
            }
            if (request.getParameter("psc").isEmpty()) {
                klient.setPsc(null);
            } else {
                //if(request.getParameter("psc").)
                klient.setPsc(request.getParameter("psc"));
            }

            if (((klient.getAdresa() == null) && (klient.getPsc() == null) && (klient.getMesto() == null))
                    || ((klient.getAdresa() != null) && (klient.getPsc() != null) && (klient.getMesto() != null))) {
            } else {
                try {
                    request.setAttribute("chybaRegistrace", "chybiAdresyUdaje");
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                    request.setAttribute("klientPrihlaseni", klient);
                    getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (request.getParameter("email").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "chybiEmail");
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (osobyPrihlaseni.findPocetPodleEmail(request.getParameter("email")) > 0) {
                    try {
                        request.setAttribute("chybaRegistrace", "duplicitniEmail");
                        request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/novaOsoba.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setEMail(request.getParameter("email"));
                }
            }
            if (request.getParameter("telefon").isEmpty()) {
                klient.setTelefon(null);
            } else {
                klient.setTelefon(request.getParameter("telefon"));
            }

            //osobyPrihlaseni.updateOsoby(klient);
            String url = "/ekcvjs.jsp";

            if (uzR.getUzivateleOrganizaceId() != null) {
                klient = osobyPrihlaseni.registerOsoby(klient);
                webOrgOsFacade.pridatZamestnanec(orgR, klient);

                request.setAttribute("selectedCenterId", 10);
                request.setAttribute("pridruzeneOsoby", webOrgOsFacade.findByOrganizace(orgR.getOrganizaceId()));
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/pridruzeneOsoby.jsp");

                try {
                    //  request.getRequestDispatcher(url).forward(request, response);
                    getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (userPath.equals(
                "/upravitOsobu")) {
            Osoby klient = osobyPrihlaseni.findPodleId(Integer.valueOf(request.getParameter("osobaId")));

            try {
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
                request.setAttribute("klientPrihlaseni", klient);
                session.setAttribute("returnPage", "cart");
                getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (userPath.equals(
                "/potvrzeniOsoby")) {
            java.text.DateFormat df = new SimpleDateFormat("dd.MM.yyyy", new Locale("cs, CZ"));

            //  Osoby klient =new Osoby();
            //    klient.setOsobaId(Integer.valueOf(request.getParameter("osobaId")));
            Osoby klient = osobyPrihlaseni.findPodleId(Integer.valueOf(request.getParameter("osobaId")));
            if (request.getParameter("titulpred").isEmpty()) {
                klient.setTitulPred(null);
            } else {
                klient.setTitulPred(request.getParameter("titulpred"));
            }
            if (request.getParameter("jmeno").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "prazdneJmeno");
                    request.setAttribute("selectedCenter", "registrace.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                klient.setJmeno(request.getParameter("jmeno"));
            }
            if (request.getParameter("prijmeni").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "prazdnePrijmeni");
                    request.setAttribute("selectedCenter", "registrace.jsp");
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                klient.setPrijmeni(request.getParameter("prijmeni"));
            }

            if (request.getParameter("titulza").isEmpty()) {
                klient.setTitulZa(null);
            } else {
                klient.setTitulZa(request.getParameter("titulza"));
            }

            if (request.getParameter("rodnecislo") == null) {
                klient.setRodneCislo(null);
            } else {
                Osoby rcOsoba = osobyPrihlaseni.findPodleRodneCislo(request.getParameter("rodnecislo"));
                if (rcOsoba != null) {
                    boolean platneRC = false;
                    try {

                        ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                        while (q.next()) {
                            platneRC = q.getBoolean(1);
                        }
                        PripojeniDB.rs.close();
                        PripojeniDB.pstmt.close();
                        PripojeniDB.con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (platneRC == true) {
                        klient.setRodneCislo(request.getParameter("rodnecislo"));
                    } else {
                        try {
                            request.setAttribute("chybaRegistrace", "spatneRC");
                            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
                            request.setAttribute("klientPrihlaseni", klient);
                            getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    boolean platneRC = false;
                    try {

                        ResultSet q = PripojeniDB.dotazS("SELECT * FROM osetri_rc('" + request.getParameter("rodnecislo") + "')");
                        while (q.next()) {
                            platneRC = q.getBoolean(1);
                        }
                        PripojeniDB.rs.close();
                        PripojeniDB.pstmt.close();
                        PripojeniDB.con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (platneRC == true) {
                        klient.setRodneCislo(request.getParameter("rodnecislo"));
                    } else {
                        try {
                            request.setAttribute("chybaRegistrace", "spatneRC");
                            request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
                            request.setAttribute("klientPrihlaseni", klient);
                            getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                            return;
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
            try {
                klient.setDatumNarozeni(df.parse(request.getParameter("datumnarozeni")));
            } catch (Exception e) {
                klient.setDatumNarozeni(null);
            }
            klient.setMistoNarozeni(request.getParameter("mistonarozeni"));
            //klient.setNarodnost(request.getParameter("narodnost"));
            //klient.setStatniPrislusnost(request.getParameter("prislusnost"));
            klient.setNarodnost(request.getParameterValues("vyberNarodnost")[0]);
            klient.setStatniPrislusnost(request.getParameterValues("vyberPrislusnost")[0]);
            if (request.getParameter("adresa").isEmpty()) {
                klient.setAdresa(null);
            } else {
                klient.setAdresa(request.getParameter("adresa"));
            }
            if (request.getParameter("mesto").isEmpty()) {
                klient.setMesto(null);
            } else {
                klient.setMesto(request.getParameter("mesto"));
            }
            if (request.getParameter("psc").isEmpty()) {
                klient.setPsc(null);
            } else {
                klient.setPsc(request.getParameter("psc"));
            }
            if (((klient.getAdresa() == null) && (klient.getPsc() == null) && (klient.getMesto() == null))
                    || ((klient.getAdresa() != null) && (klient.getPsc() != null) && (klient.getMesto() != null))) {
            } else {
                try {
                    request.setAttribute("chybaRegistrace", "chybiAdresyUdaje");
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
                    request.setAttribute("klientPrihlaseni", klient);
                    getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (request.getParameter("email").isEmpty()) {
                try {
                    request.setAttribute("chybaRegistrace", "chybiEmail");
                    request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");

                    request.setAttribute("klientPrihlaseni", klient);
                    getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (osobyPrihlaseni.findPocetPodleEmail(request.getParameter("email")) > 0) {
                    try {
                        request.setAttribute("chybaRegistrace", "duplicitniEmail");
                        request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
                        getServletConfig().getServletContext().getRequestDispatcher("/ekcvjs.jsp").forward(request, response);
                        return;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    klient.setEMail(request.getParameter("email"));
                }
            }
            if (request.getParameter("telefon").isEmpty()) {
                klient.setTelefon(null);
            } else {
                klient.setTelefon(request.getParameter("telefon"));
            }

            //osobyPrihlaseni.updateOsoby(klient);
            String url = "/ekcvjs.jsp";
            // if (uzR.getUzivateleOrganizaceId() != null) {
            osobyPrihlaseni.updateOsoby(klient);

            request.setAttribute("selectedCenterId", 10);
            request.setAttribute("klientPrihlaseni", klient);
            if (session.getAttribute("returnPage") != null && session.getAttribute("returnPage").equals("cart")) {
                ArrayList<Osoby> chybneOsoby = (ArrayList) session.getAttribute("chybneOsoby");
                ArrayList<Osoby> chybneOsobyOut = new ArrayList<Osoby>();

                for (int i = 0; i < chybneOsoby.size(); i++) {
                    Osoby o = osobyPrihlaseni.findPodleId(chybneOsoby.get(i).getOsobaId());
                    if (o.getJmeno() == null || o.getPrijmeni() == null || o.getAdresa() == null
                            || o.getMesto() == null || o.getPsc() == null || (o.getDatumNarozeni() == null || o.getRodneCislo() == null)) {

                        chybneOsobyOut.add(o);
                    }
                }
                session.setAttribute("chybneOsoby", chybneOsobyOut);
                request.setAttribute("selectedCenter", "WEB-INF/view/cart.jsp");
            } else {
                request.setAttribute("selectedCenter", "WEB-INF/ekcvjs/detailyOsoby.jsp");
            }

            try {
                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // }

        } else if (userPath.equals(
                "/index")) {
           
        } else if (userPath.equals(
                "/hledani")) {

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
            zt.vycistit("index?hledani.jsp");
            zt.setPocetStrana(20);

            String hledanyVyraz = request.getParameter("vyraz");
            Collection<TrojiceRetezRetezRetez> cTr = hledani(hledanyVyraz, zt);

            request.setAttribute("hledanyVyraz", hledanyVyraz);
            request.setAttribute("hledanaData", cTr);

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
            request.setAttribute("selectedCenter", "hledani.jsp");

            try {
                String url = "/index.jsp";

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
        } else if (userPath.equals(
                "/filtrAkceDvpp")) {

            zt.setHledanaAkce(request.getParameter("filtrNazevAkce"));

            String akceRadit = "akceCislo ASC";
            if (!zt.getAktualniStranka().equals("dvpp/vzdProgramy.jsp")) {
                zt.vycistit("dvpp/vzdProgramy.jsp");
            }
            zt.setIdOborSkupina(6);

            akceRadit = nastavSort(akceRadit);
            request.setAttribute("sortCislo", sortCislo);
            request.setAttribute("sortNazev", sortNazev);
            request.setAttribute("sortTermin", sortTermin);
            request.setAttribute("sortCena", sortCena);
            request.setAttribute("selectedCenter", "WEB-INF/dvpp/vzdProgramy.jsp");
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
                String url = "/dvpp.jsp";

                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals(
                "/filtrAkcedvppvpk")) {

            zt.setHledanaAkce(request.getParameter("filtrNazevAkce"));

            String akceRadit = "akceCislo ASC";
            if (!zt.getAktualniStranka().equals("dvppvpk/vzdProgramy.jsp")) {
                zt.vycistit("dvppvpk/vzdProgramy.jsp");
            }
            zt.setIdOborSkupina(5);

            akceRadit = nastavSort(akceRadit);
            request.setAttribute("sortCislo", sortCislo);
            request.setAttribute("sortNazev", sortNazev);
            request.setAttribute("sortTermin", sortTermin);
            request.setAttribute("sortCena", sortCena);
            request.setAttribute("selectedCenter", "WEB-INF/dvppvpk/vzdProgramy.jsp");
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
                String url = "/dvppvpk.jsp";

                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (userPath.equals(
                "/filtrAkceUcitele")) {

            String akceRadit = "akceCislo ASC";
            if (!zt.getAktualniStranka().equals("ucitele/vzdProgramy.jsp")) {
                zt.vycistit("ucitele/vzdProgramy.jsp");
            }
            zt.setHledanaAkce(request.getParameter("filtrNazevAkce"));
            zt.setIdOborSkupina(4);

            akceRadit = nastavSort(akceRadit);
            request.setAttribute("sortCislo", sortCislo);
            request.setAttribute("sortNazev", sortNazev);
            request.setAttribute("sortTermin", sortTermin);
            request.setAttribute("sortCena", sortCena);
            request.setAttribute("selectedCenter", "WEB-INF/ucitele/vzdProgramy.jsp");
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
                String url = "/ucitele.jsp";

                //  request.getRequestDispatcher(url).forward(request, response);
                getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
                return;
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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

    private List<TrojiceRetezRetezRetez> hledani(String hledanyVyraz, ZobrazeniTabulek zt) {
        TrojiceRetezRetezRetez trr = new TrojiceRetezRetezRetez();

        List<WebPanelyData> wpd = webPanelyDataFacade.findByNazevPopis(hledanyVyraz.toLowerCase());
        List<WebOsZarazeni> woz = webOsZarazeniFacade.findByOsobaKontakty(hledanyVyraz.toLowerCase());
        List<WebAktuality> wak = aktualityFacade.findByVyraz(hledanyVyraz.toLowerCase());
        List<AkceHlavni> wah = null; //TODO = akceHlavniFacade.findByNazevPopis(hledanyVyraz);

        for (int i = 0; i < wpd.size(); i++) {
            trr = new TrojiceRetezRetezRetez();
            trr.setNazev(wpd.get(i).getWebPanelyDataNazev());
            trr.setOdkaz(wpd.get(i).getWebPanelyDataPanel().getWebPanelyZalozka() + "?" + wpd.get(i).getWebPanelyDataPanel().getWebPanelyOdkaz());
            zt.getArTr().add(trr);
        }

        for (int i = 0; i < woz.size(); i++) {
            trr = new TrojiceRetezRetezRetez();
            trr.setNazev(((woz.get(i).getWebOsZarazeniOsoba().getTitulPred() == null) ? "" : woz.get(i).getWebOsZarazeniOsoba().getTitulPred()) + " "
                    + ((woz.get(i).getWebOsZarazeniOsoba().getJmeno() == null) ? "" : woz.get(i).getWebOsZarazeniOsoba().getJmeno()) + " "
                    + ((woz.get(i).getWebOsZarazeniOsoba().getPrijmeni() == null) ? "" : woz.get(i).getWebOsZarazeniOsoba().getPrijmeni()) + " "
                    + ((woz.get(i).getWebOsZarazeniOsoba().getTitulZa() == null) ? "" : woz.get(i).getWebOsZarazeniOsoba().getTitulZa()));
            trr.setOdkaz(woz.get(i).getWebOsZarazeniOblzarJemna().getWebOblzarHrubeId().getWebOblzarHrubeKategorie().getWebKategorieZakladniPopis()
                    + "?kontakty.jsp&idOsOzHrube=" + woz.get(i).getWebOsZarazeniOblzarJemna().getWebOblzarHrubeId().getWebOblzarHrubeId());
            zt.getArTr().add(trr);
        }

        for (int i = 0; i < wak.size(); i++) {
            trr = new TrojiceRetezRetezRetez();
            trr.setNazev(wak.get(i).getWebAktualityNazev());
            trr.setOdkaz("index?aktualita.jsp&idAktualita=" + wak.get(i).getWebAktualityPK().getWebAktualityId());
            zt.getArTr().add(trr);
        }

        for (int i = 0; i < wah.size(); i++) {
            trr = new TrojiceRetezRetezRetez();
            trr.setNazev(wah.get(i).getNazev());
            trr.setOdkaz("index?vzdProgram.jsp&akceIdDetail=" + wah.get(i).getAkceId()); //bylo index?vzdProgramy.jsp
            zt.getArTr().add(trr);
        }
        if (zt.getArTr().size() >= zt.getOffset() * zt.getPocetStrana()) {
            if (zt.getArTr().size() > zt.getOffset() * zt.getPocetStrana() + zt.getPocetStrana()) {
                return zt.getArTr().subList(zt.getOffset() * zt.getPocetStrana(), zt.getOffset() * zt.getPocetStrana() + zt.getPocetStrana());
            } else {
                return zt.getArTr().subList(zt.getOffset() * zt.getPocetStrana(), zt.getOffset() * zt.getPocetStrana() + zt.getArTr().size());
            }
        } else {
            return zt.getArTr();

        }

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
