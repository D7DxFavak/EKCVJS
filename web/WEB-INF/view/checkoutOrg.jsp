<%--
    Document   : checkout
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var='view' value='/checkoutOrg' scope='session' />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>
        <div id="singleColumn">                       
            <h2>${zobrazeniTabulek.webProp.nazev("shrnuti_objednavka")}</h2>       
            <p>${zobrazeniTabulek.webProp.nazev("kontrola_udaju")}</p>
            <form action="potvrzeniOrg" method="post">
                <table id="checkoutTable2">
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("organizace_nazev")}:</td>
                        <td>${klientPrihlaseni.nazev}                            
                        </td>
                    </tr>
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</td>
                        <td>${klientPrihlaseni.adresa}
                        </td>
                    </tr>
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</td>
                        <td>${klientPrihlaseni.mesto}
                        </td>
                    </tr>
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</td>
                        <td>${klientPrihlaseni.psc}
                        </td>
                    </tr>    
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</td>
                        <td>${klientPrihlaseni.telefon}
                        </td>
                    </tr>  
                    <tr>
                        <td>${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</td>
                        <td>${klientPrihlaseni.EMail}
                        </td>
                    </tr>  
                </table>

                <p>${zobrazeniTabulek.webProp.nazev("objednane_akce")}</p>

                <c:if test="${!empty cart && cart.numberOfProducts != 0}">
                    <ul id="checkoutSumList">
                        <c:forEach var="cartItem" items="${cart.items}">         

                            <c:set var="product" value="${cartItem.product}"/>
                            <li>          
                                <p>${fn:substring(product.akceCislo,0,2)} - ${fn:substring(product.akceCislo,2,6)} - ${fn:substring(product.akceCislo,6,8)} : ${product.nazev}</p>                                                            
                                <p>${zobrazeniTabulek.webProp.nazev("cena_akce")} : <fmt:formatNumber value="${cartItem.total}" pattern="######"/> ${zobrazeniTabulek.webProp.nazev("mena_czk")}</p>
                            </li>                        
                        </c:forEach>
                    </ul>
                </c:if>            

                <div id="subtotal2">
                    <p class="cenaObjs2"> ${zobrazeniTabulek.webProp.nazev("cena_celkem")}: </p>
                    <p class="cenaSum2"><fmt:formatNumber value="${cart.total}" pattern="######"/> ${zobrazeniTabulek.webProp.nazev("mena_czk")}</p>
                </div>

                <%-- <div id="infoBox">
                     <table id="priceBox">
                         <tr>
                             <td class="total">${zobrazeniTabulek.webProp.nazev("cena_celkem")}:</td>
                             <td class="total checkoutPriceColumn">
                                 ${cart.total} ${zobrazeniTabulek.webProp.nazev("CZK")}</td>
                         </tr>
                     </table>
                 </div>--%>
                <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit_objednavku")}">
            </form>
        </div>
    </body>
</html>