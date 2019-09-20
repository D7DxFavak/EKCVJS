<%--
    Document   : checkout
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var='view' value='/checkoutOs' scope='session' />

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
</head>
<body>

    <div id="singleColumn">

        <h2>${zobrazeniTabulek.webProp.nazev("shrnuti_rezervace")}</h2>

        <p class="rezervaceWarning">${zobrazeniTabulek.webProp.nazev(fakturaWarn)}</p>

        <p>${zobrazeniTabulek.webProp.nazev("kontrola_udaju")}</p>

        <c:if test="${zamestnavatele.size() > 0}">
            <select id="vyberFakturace" name="vyberZamestnavatele" size="1" onchange="document.location.href = 'checkoutOs?idOrganizace=' + this.value">
                <c:choose>
                    <c:when test="${organizaceFakturace !=null}">
                        <option value="null">${klientPrihlaseni.jmeno} ${klientPrihlaseni.prijmeni}</option>
                    </c:when>
                    <c:otherwise>
                        <option selected value="null">${klientPrihlaseni.jmeno} ${klientPrihlaseni.prijmeni}</option>
                    </c:otherwise>
                </c:choose>

                <c:forEach var="zamestnavatel" items="${zamestnavatele}">           
                    <c:choose>
                        <c:when test="${organizaceFakturace !=null}">
                            <option selected value="${zamestnavatel.webOrgOsOrganizace.organizaceId}">${zamestnavatel.webOrgOsOrganizace.nazev}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${zamestnavatel.webOrgOsOrganizace.organizaceId}">${zamestnavatel.webOrgOsOrganizace.nazev}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>                         
            </select>  
        </c:if>

        <c:choose>
            <c:when test="${organizaceFakturace !=null}">

                <p>Faktura bude vystavena na Vašeho zaměstnavatele :</p>

                <form action="potvrzeniOsOrg" method="post">
                    <table id="checkoutTable2">
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("organizace_nazev")}:</td>
                            <td>${organizaceFakturace.nazev}</td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("organizace_ico")}:</td>
                            <td>${organizaceFakturace.ico}
                            </td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("organizace_email")}:</td>
                            <td>${organizaceFakturace.EMail}
                            </td>
                        </tr>                       
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("organizace_adresa")}:</td>
                            <td>${organizaceFakturace.adresa}, ${organizaceFakturace.psc} ${organizaceFakturace.mesto}                   
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

                    <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit_objednavku")}">
                </form> 
            </c:when>

            <c:otherwise>
                <form action="potvrzeni" method="post">
                    <table id="checkoutTable2">
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</td>
                            <td>${klientPrihlaseni.jmeno}</td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</td>
                            <td>${klientPrihlaseni.prijmeni}
                            </td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</td>
                            <td>${klientPrihlaseni.EMail}
                            </td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</td>
                            <td>${klientPrihlaseni.telefon}
                            </td>
                        </tr>
                        <tr>
                            <td>${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</td>
                            <td>${klientPrihlaseni.adresa}, ${klientPrihlaseni.psc} ${klientPrihlaseni.mesto}                   
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

                    <input type="submit" value="${zobrazeniTabulek.webProp.nazev("potvrdit_rezervaci")}">
                </form>        
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>