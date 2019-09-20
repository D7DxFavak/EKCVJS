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

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
    <title>Potvrzeni nakupu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/affablebean2.css">
</head>

<div id="singleColumn">

    <p id="confirmationText"> 
        ${zobrazeniTabulek.webProp.nazev("prijeti_rezervace")}        
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
                <th colspan="4">${zobrazeniTabulek.webProp.nazev("shrnuti_rezervace")}</th>
            </tr>

            <tr class="tableHeading">
                <td>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</td>
                <td>${zobrazeniTabulek.webProp.nazev("tab_osoba")}</td>
                <td>${zobrazeniTabulek.webProp.nazev("tab_termin")}</td>
                <td>${zobrazeniTabulek.webProp.nazev("tab_cena")}</td>
            </tr>

            <c:forEach var="products" items="${orderedProducts}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'lightBlue'}">
                    <td width="120">${fn:substring(products.akce.akceCislo,0,2)} - ${fn:substring(products.akce.akceCislo,2,6)} - ${fn:substring(products.akce.akceCislo,6,8)}</td>
                    <td width="200">
                        ${products.osoba.jmeno} ${products.osoba.prijmeni}                             
                    </td>
                    <td width="300">                                
                        ${products.akce.terminObecny}
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

        <%-- <table id="orderSummaryTable" class="detailsTable">
             <tr class="header">
                 <th colspan="3">Shrnuti rezervace</th>
             </tr>

            <tr class="tableHeading">
                <td>akcet</td>
                <td>termin</td>
                <td>cena</td>
            </tr>

            <c:forEach var="products" items="${orderedProducts}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>${products.akce.nazev}</td>
                    <td class="datumRezervace">
                        ${products.akce.terminObecny}
                    </td>
                    <td class="confirmationPriceColumn">
                        <p class="cenaTabulka"><fmt:formatNumber value="${products.akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>   
                </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>Celkova cena:</strong></td>
                <td id="totalCellRight">${total} Kc</td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow"><strong>date processed:</strong>
                    ${product.dateCreated}
                </td>
            </tr>
        </table>--%>       

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
        <div id="shrnutiObjednavky">
            <p class="shrnutiObjednavkyText">${zobrazeniTabulek.webProp.nazev("shrnuti_objednavky_odeslano")}</p>   
        </div>
        <div id="odkazMain">
            <a href="${pageContext.request.contextPath}/index.jsp">${zobrazeniTabulek.webProp.nazev("pokracovat_main_page")}</a>
        </div>
    </div>    
</div>