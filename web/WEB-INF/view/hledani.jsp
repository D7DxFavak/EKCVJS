<%-- 
    Document   : aktuality
    Created on : 3.11.2011, 9:07:56
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>        
        <p> Vysledky hledani pro vyraz : ${hledanyVyraz}</p>
        <ul>
            <%-- <c:forEach var="panelData" items ="${panelyData}">                        
                 <li>                                          
                    prejit na stranku : ${panelData.webPanelyDataPanel.webPanelyZalozka}?${panelData.webPanelyDataPanel.webPanelyOdkaz}
                    <a href="${panelData.webPanelyDataPanel.webPanelyZalozka}?${panelData.webPanelyDataPanel.webPanelyOdkaz}">
                        ${panelData.webPanelyDataNazev}
                     </a>
                 </li>                        
             </c:forEach>--%>
            <c:forEach var="vysledekHledani" items ="${hledanaData}">                        
                <li>                                       
                    <a href="${vysledekHledani.odkaz}">
                        ${vysledekHledani.nazev}
                    </a>
                </li>                        
            </c:forEach>
        </ul>     


    </body>
</html>
