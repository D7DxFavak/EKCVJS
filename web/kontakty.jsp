<%-- 
    Document   : kontakty
    Created on : 3.11.2011, 9:06:52
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
        <div id="wrapperContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 

                        <a href="${aktKategorie.webKategorieZakladniPopis}?kontakty.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("kontakty")}</span>                                
                        </a></li>
                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="${aktKategorie.webKategorieZakladniPopis}?${aktKategorie.webKategorieZakladniPopis}.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(aktKategorie.webKategorieZakladniPopis)}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <ul>
                <c:forEach var="osOzHrube" items ="${osOzHrube}">    
                    <li> 
                        <a href="${vybranaStrana}?kontakty.jsp&idOsOzHrube=${osOzHrube.webOblzarHrubeId}">
                            <span class="kontaktyLabel"></span>
                            <span class="kontaktyLabelText">${osOzHrube.webNazev}</span>                                
                        </a>

                        <c:if test= "${osOzHruba.webOblzarHrubeId == osOzHrube.webOblzarHrubeId}">                       
                            <ul>
                                <c:forEach var="osOzJemne" items ="${osOzJemne}">    
                                    <li> 
                                        <h2>${osOzJemne.webNazev}</h2>
                                        <ul>
                                            <c:forEach var="kontaktyVybrane" items ="${kontaktyVybrane}"> 
                                                <c:if test= "${kontaktyVybrane.webOsZarazeniOblzarJemna.webOblzarJemneId == osOzJemne.webOblzarJemneId}">  
                                                    <li>
                                                        <div id="kontaktyOsoba">
                                                            <div id="kontaktyLeftDiv">
                                                                <img src="${osOzHruba.webOblzarHrubeKategorie.webKategorieZakladniPopis}?idKontaktOsoba=${kontaktyVybrane.webOsZarazeniOsoba.osobaId}" name="foto">
                                                            </div>
                                                            <div id="kontaktyCenterDiv">
                                                                <p class="kontaktyJmeno">${kontaktyVybrane.webOsZarazeniOsoba.titulPred} ${kontaktyVybrane.webOsZarazeniOsoba.jmeno} ${kontaktyVybrane.webOsZarazeniOsoba.prijmeni} ${kontaktyVybrane.webOsZarazeniOsoba.titulZa}</p>                                                   
                                                                <p class="kontaktyPozice">${kontaktyVybrane.webOsZarazeniPozice.webOsPoziceNazev}</p>
                                                                <c:choose>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon1 == 1}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon}</p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon1 == 2}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon2}</p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon1 == 3}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon3}</p>
                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon2 == 1}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon}</p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon2 == 2}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon2}</p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniTelefon2 == 3}">
                                                                        <p class="kontaktyTelefon">${kontaktyVybrane.webOsZarazeniOsoba.telefon3}</p>
                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <c:choose>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniEmail == 1}">
                                                                        <p class="kontaktyEmail"><a href="mailto:${kontaktyVybrane.webOsZarazeniOsoba.EMail}">${kontaktyVybrane.webOsZarazeniOsoba.EMail}</a></p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniEmail == 2}">
                                                                        <p class="kontaktyEmail"><a href="mailto:${kontaktyVybrane.webOsZarazeniOsoba.EMail2}">${kontaktyVybrane.webOsZarazeniOsoba.EMail2}</a></p>
                                                                    </c:when>
                                                                    <c:when test="${kontaktyVybrane.webOsZarazeniEmail == 3}">
                                                                        <p class="kontaktyEmail"><a href="mailto:${kontaktyVybrane.webOsZarazeniOsoba.EMail3}">${kontaktyVybrane.webOsZarazeniOsoba.EMail3}</a></p>
                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose> 
                                                            </div>
                                                            <div id="kontaktyRightDiv">
                                                                <p class="kontaktyPopis">${kontaktyVybrane.webOsZarazeniPopis}</p>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul>     
                        </c:if>
                    </li>  
                </c:forEach>
            </ul>    
        </div>
    </body>
</html>
