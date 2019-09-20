/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.OutputStream;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.*;

/**
 *
 * @author Favak
 */
@WebServlet(name = "PDFServlet", loadOnStartup = 3,
        urlPatterns = {"/pdf", "/download"})
public class PDFServlet extends HttpServlet {

    @EJB
    private VazbaAkceUlozisteDataFacade ulozisteAkceFacade;
    @EJB
    private VazbaPrihlaskyUlozisteDataFacade ulozistePrihlaskyFacade;
    @EJB
    private VazbaFakturyUlozisteDataFacade ulozisteFakturyFacade;
    @EJB
    private VazbaOrganizaceUlozisteDataFacade ulozisteOrganizaceFacade;
    @EJB
    private VazbaWebKategorieUlozisteDataFacade ulozisteKategorieFacade;
    @EJB
    private UlozisteDataFacade ulozisteDataFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        // HttpSession session = request.getSession();

        if (userPath.equals("/pdf")) {
            String filename = "";
            if (request.getParameter("akceId") != null) {
                int akceId = -1;
                akceId = Integer.valueOf(request.getParameter("akceId")).intValue();
                VazbaAkceUlozisteData vaud = ulozisteAkceFacade.findByAkce(akceId);
                UlozisteData ud = vaud.getUlozisteData();
                request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                filename = vaud.getUlozisteData().getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = ud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            } else if (request.getParameter("polozka") != null) {
                int polozka = -1;
                polozka = Integer.valueOf(request.getParameter("polozka")).intValue();
                VazbaPrihlaskyUlozisteData vaud = ulozistePrihlaskyFacade.findByPrihlasky(polozka);
                UlozisteData ud = vaud.getUlozisteData();
                request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                filename = vaud.getUlozisteData().getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = ud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            } else if (request.getParameter("ostatniDokumentyOrg") != null) {
                int polozka = -1;
                polozka = Integer.valueOf(request.getParameter("ostatniDokumentyOrg")).intValue();
                UlozisteData vaud = ulozisteDataFacade.findById(polozka);                
                request.setAttribute(vaud.getUlozisteDataNazev().substring(vaud.getUlozisteDataNazev().indexOf(".") + 1), vaud);
                filename = vaud.getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = vaud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            } else if (request.getParameter("kategorieDokument") != null) {
                int polozka = -1;
                polozka = Integer.valueOf(request.getParameter("kategorieDokument")).intValue();
                VazbaWebKategorieUlozisteData vaud = ulozisteKategorieFacade.findByUloziste(polozka);
                UlozisteData ud = vaud.getUlozisteData();
                request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                filename = vaud.getUlozisteData().getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = ud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();

            } else if (request.getParameter("faktura") != null) {
                int cisloFaktury = -1;
                cisloFaktury = Integer.valueOf(request.getParameter("faktura")).intValue();
                VazbaFakturyUlozisteData vaud = ulozisteFakturyFacade.findVazbyFakturyUlozisteData(cisloFaktury);
                UlozisteData ud = vaud.getUlozisteData();
                request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                filename = vaud.getUlozisteData().getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = ud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            } else if (request.getParameter("uloziste") != null) {
                int idUloziste = -1;
                idUloziste = Integer.valueOf(request.getParameter("uloziste")).intValue();
                // VazbaFakturyUlozisteData vaud = ulozisteFakturyFacade.findVazbyFakturyUlozisteData(idUloziste);
                UlozisteData ud = ulozisteDataFacade.findById(idUloziste);
                request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                filename = ud.getUlozisteDataNazev();
                response.reset();
                response.setContentType("application/octet-stream");
                response.setHeader("cache-control", "must-revalidate");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                byte[] data = ud.getUlozisteDataData();
                ServletOutputStream os = response.getOutputStream();
                os.write(data);
                os.flush();
                os.close();
            }
            //VazbaAkceUlozisteData vaud = ulozisteAkceFacade.findByAkce(new AkceHlavni(akceId));

            // return;
        } else if (userPath.equals("/download")) {
            String filename = "";
            if (request.getParameter("dokument") != null) {
                int polozka = -1;
                polozka = Integer.valueOf(request.getParameter("dokument")).intValue();
                UlozisteData ud = ulozisteDataFacade.findById(polozka);
                
                if (ud.getUlozisteDataDruhId().getUlozisteDataDruhyId() == 260) {
                    request.setAttribute(ud.getUlozisteDataNazev().substring(ud.getUlozisteDataNazev().indexOf(".") + 1), ud);
                    filename = ud.getUlozisteDataNazev();
                    response.reset();
                    response.setContentType("application/octet-stream");
                    response.setHeader("cache-control", "must-revalidate");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                    byte[] data = ud.getUlozisteDataData();
                    ServletOutputStream os = response.getOutputStream();
                    os.write(data);
                    os.flush();
                    os.close();
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
}
