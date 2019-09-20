/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import sprava.ZobrazeniTabulek;

/**
 *
 * @author Favak
 */
@WebServlet(name = "AktualityServlet", loadOnStartup = 2,
urlPatterns = {"/aktuality"})
public class AktualityServlet extends HttpServlet {

    @EJB
    private WebAktualityFacade aktualityFacade;
    @EJB
    private WebPropertiesFacade propertiesFacade;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        String odkazNazev = request.getQueryString();

        getServletContext().setAttribute("aktualitySouhrn", aktualityFacade.findSouhrn());

        HttpSession session = request.getSession();
        ZobrazeniTabulek zt = (ZobrazeniTabulek) session.getAttribute("zobrazeniTabulek");
        if (zt == null) {
            getServletContext().removeAttribute("zobrazeniTabulek.webProp");
             List<WebProperties> wp = propertiesFacade.findAll();
            zt = new ZobrazeniTabulek(wp);         
            session.setAttribute("zobrazeniTabulek", zt);  
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
            if (request.getParameter("idAktualita") != null) {
                zt.setIdAktualita(Integer.valueOf(request.getParameter("idAktualita")).intValue());
                //WebAktuality wak = aktualityFacade.findById(zt.getIdAktualita());
                request.setAttribute("idAktualitaDetail", zt.getIdAktualita());
                request.setAttribute("selectedCenter", odkazNazev);

            } else {
            }
        } else {
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
     * Handles the HTTP
     * <code>POST</code> method.
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
