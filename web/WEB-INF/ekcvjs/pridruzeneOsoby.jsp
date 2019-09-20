<%-- 
    Document   : pridruzeneOsoby
    Created on : 28.12.2011, 10:30:54
    Author     : 7Data Gotzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pridruzene osoby</title>
    </head>
    <body>
        <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("pridruzene_osoby")}</p>
        </div>
        <div id="wrapperPrihlaskyContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="ekcvjs?pridruzeneOsoby.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("pridruzene_osoby")}</span>                                
                        </a></li>
                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="ekcvjs.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <%--<div id="panelOsobyOdkazyPridruzene">
                <a href="ekcvjs?navrhovaneOsoby.jsp">${zobrazeniTabulek.webProp.nazev("navrhovane_osoby")}</a>
                <a href="ekcvjs?novaOsoba.jsp">${zobrazeniTabulek.webProp.nazev("registrovat_nova_osoba")}</a>
            </div>--%>
            <div id="tabulkaPridruzeneOsoby">
                <div id="tableHeaderPridruzeneOsobu">
                    <div id ="headerJmeno">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}</p>                            
                        </a>
                    </div>
                    <div id="headerPrijmeni">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}</p>
                           
                        </a>                                
                    </div>
                    <div id="headerDatumNarozeni">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}</p>                            
                        </a>                                  
                    </div>
                    <div id="headerRodneCislo">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}</p>                            
                        </a>                                  
                    </div>
                    <div id="headeruDetailyOsoby">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("tab_detaily")}</p>                           
                        </a>                                 
                    </div>
                    <div id="headeruGDPR">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("tab_gdpr")}</p>                           
                        </a>                                 
                    </div>    
                    <div id="headerTlacitkoOsoby">
                        <a href="ekcvjs?pridruzeneOsoby.jsp">      
                            <p>${zobrazeniTabulek.webProp.nazev("tab_odebrat")}</p>                                   
                        </a>                                  
                    </div>   
                </div> 
                <table id="osobyOrgPrihlasitTable">                  

                    <c:forEach var="osoby" items="${pridruzeneOsoby}" varStatus="iter">

                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">

                            <td width="100">
                                ${osoby.webOrgOsOsoba.jmeno}               
                            </td>
                            <td width="130">
                                ${osoby.webOrgOsOsoba.prijmeni}                             
                            </td>
                            <td width="110">
                                <fmt:formatDate value="${osoby.webOrgOsOsoba.datumNarozeni}" pattern="d.M.yyyy"/>  
                            </td>
                            <td width="110">
                                ${osoby.webOrgOsOsoba.rodneCislo}  
                            <td width="100">
                                <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${osoby.webOrgOsOsoba.osobaId}">${zobrazeniTabulek.webProp.nazev("uzivatel_detail")} 
                            </td>
                            <td width="100">
                                <c:choose>
                                    <c:when test ="${osoby.webOrgOsOsoba.gdprUdeleno}">
                                        ANO
                                    </c:when>
                                    <c:otherwise>
                                        NE
                                    </c:otherwise>
                                </c:choose>
                                
                            </td>
                            <td width="90">
                                <form action="odebratZeZamestnancu" method="post">
                                    <input type="hidden"
                                           name="osobaId"
                                           id="osobaId"
                                           value="${osoby.webOrgOsOsoba.osobaId}">
                                    <input type="submit"
                                           name="submit"
                                           class="cartTlacitkoOdebrat"
                                           value="${zobrazeniTabulek.webProp.nazev("odebrat")}">
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
                <div id ="navigace">
                    <div id="zobrZaznam">
                        <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                        <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&pocetStrana=10">10</a>
                        <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&pocetStrana=20">20</a>
                        <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&pocetStrana=50">50</a>             
                    </div>
                    <div id="strana">
                        <c:forEach var="strana" items="${strany}" varStatus="iter">
                            <c:choose>
                                <c:when test="${strana.cislo == -1}">
                                    <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:when>
                                <c:when test="${strana.cislo == -2}">
                                    <span>...</span>
                                    <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="navClass" href="ekcvjs?pridruzeneOsoby.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                </c:otherwise>
                            </c:choose>                      
                        </c:forEach>                                 
                    </div>
                </div>
            </div>
    </body>
</html>
