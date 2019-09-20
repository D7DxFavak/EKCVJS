<%--
    Document   : confirmation
    Created on : Sep 9, 2009, 12:20:30 AM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/potvrzeni' scope='session' />

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
        <title>Potvrzeni nakupu</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/affablebean2.css">
    </head>

    <body>

        <div id="singleColumn">



            <p id="confirmationText"> 
                ${zobrazeniTabulek.webProp.nazev("prijeti_objednavky")}        
            </p>

            <div id="kcvjsInfo">
                <p class="kcvjsInfoBold">${zobrazeniTabulek.webProp.nazev("obj_KCVJS1")}   </p>
                <p class="kcvjsInfoBold">${zobrazeniTabulek.webProp.nazev("obj_KCVJS2")}   </p>
                <p class="kcvjsInfo">${zobrazeniTabulek.webProp.nazev("obj_KCVJS3")}   </p>
                <div id="horizontRuler"><hr></div>
                <p class="kcvjsInfo">${zobrazeniTabulek.webProp.nazev("obj_KCVJS4")}   </p>
            </div>

            <div class="summaryColumn" >

                <table id="orderSummaryTable" class="detailsTable">
                    <tr class="header">
                        <th colspan="4">${zobrazeniTabulek.webProp.nazev("shrnuti_objednavka")}</th>
                    </tr>

                    <tr class="tableHeading">
                        <td>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</td>
                        <td>${zobrazeniTabulek.webProp.nazev("tab_osoba")}</td>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_zpusob_placeni")}</td>
                        <td>${zobrazeniTabulek.webProp.nazev("tab_cena")}</td>
                    </tr>

                    <c:forEach var="products" items="${orderedProducts}" varStatus="iter">

                        <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'lightBlue'}">
                            <td width="120">${fn:substring(products.akce.akceCislo,0,2)} - ${fn:substring(products.akce.akceCislo,2,6)} - ${fn:substring(products.akce.akceCislo,6,8)}</td>
                            <td width="200">
                                ${products.osoba.jmeno} ${products.osoba.prijmeni}                             
                            </td>
                            <td width="300">                                
                                ${products.druhprihl.nazev}
                            </td>
                            <td width="130">
                                <p class="cenaTabulka"><fmt:formatNumber value="${products.akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>   
                            </td>
                        </tr>

                    </c:forEach>

                    <tr class="lightBlue">
                        <td id="totalCellLeft"><strong>${zobrazeniTabulek.webProp.nazev("cena_celkem")}:</strong></td>
                        <td colspan="3" id="totalCellRight">${cenaCelkem} Kc</td>
                    </tr>                  
                </table>

            </div>

            <div class="summaryObjednavatel" >
                <table id="potvrzeniObjTable">
                    <th>
                        ${zobrazeniTabulek.webProp.nazev("objednavatel")}
                    </th>
                    <tr>                
                        <td>${klientPrihlaseni.jmeno} ${klientPrihlaseni.prijmeni}                            
                        </td>
                    </tr>
                    <tr>                       
                        <td>${klientPrihlaseni.adresa}
                        </td>
                    </tr>
                    <tr>                      
                        <td>${klientPrihlaseni.mesto}
                        </td>
                    </tr>
                    <tr>                      
                        <td>${klientPrihlaseni.psc}
                        </td>
                    </tr>    
                    <tr>                      
                        <td>${klientPrihlaseni.telefon}
                        </td>
                    </tr>  
                    <tr>                       
                        <td>${klientPrihlaseni.EMail}
                        </td>
                    </tr>                      
                </table>

                <%-- <table id="potvrzeniPlatceTable">
                     <th>
                         ${zobrazeniTabulek.webProp.nazev("platce")}
                     </th>
                     <tr>                
                         <td>${klientPrihlaseni.nazev}                            
                         </td>
                     </tr>
                     <tr>                       
                         <td>${klientPrihlaseni.adresa}
                         </td>
                     </tr>
                     <tr>                      
                         <td>${klientPrihlaseni.mesto}
                         </td>
                     </tr>
                     <tr>                      
                         <td>${klientPrihlaseni.psc}
                         </td>
                     </tr>    
                     <tr>                      
                         <td>${klientPrihlaseni.telefon}
                         </td>
                     </tr>  
                     <tr>                       
                         <td>${klientPrihlaseni.EMail}
                         </td>
                     </tr>  
                 </table>--%>

            </div>
            <div id="shrnutiObjednavky">
                <p class="shrnutiObjednavkyText">${zobrazeniTabulek.webProp.nazev("shrnuti_objednavky_odeslano_org")}</p>   
            </div>
            <div id="odkazMain">
                <a href="${pageContext.request.contextPath}/index.jsp">${zobrazeniTabulek.webProp.nazev("pokracovat_main_page")}</a>
            </div>
        </div>
    </body>
</html>