/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import entity.Osoby;
import entity.Uzivatele;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import session.UzivateleFacade;

/**
 *
 * @author 7Data Gotzy
 */
@WebFilter(servletNames = {"Controller"})
public class SessionTimeoutFilter implements Filter {
    
    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession(false);

        // String url = "/WEB-INF/view/index.jsp";

        /*if (req.getRemoteUser() != null) {
            if ((Osoby) req.getAttribute("klient") != null) {
                System.out.println("stavajici prihlaseni");
            } else {
                System.out.println("nove prihlaseni " + req.getRemoteUser());

                try {
                    req.getRequestDispatcher("/prihlaseni").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;

            }
        } else {
            System.out.println("Filter : " + req.getRemoteUser());
        }*/

        // if session doesn't exist, forward user to welcome page
        if (session == null) {
            try {
                req.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
