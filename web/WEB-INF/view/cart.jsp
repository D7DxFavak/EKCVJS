<%--
    Document   : cart
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='view' value='/cart' scope='session' />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>       
        <div id="wrapperPrihlaskyContainer">

            <div id="cartLeft">
                <div id="actionBar">

                    <%-- checkout widget --%>
                    <c:set var="value">
                        <c:choose>
                            <%-- if 'selectedCategory' session object exists, send user to previously viewed category --%>
                            <c:when test="${!empty selectedCategory}">
                                category
                            </c:when>
                            <%-- otherwise send user to welcome page --%>
                            <c:otherwise>
                                index.jsp
                            </c:otherwise>
                        </c:choose>
                    </c:set>

                    <%--<a href="${value}" class="bubble hMargin">continue shopping</a>--%>
                    <a href="ekcvjs?novePrihlaseni.jsp" class="bubble hMargin">${zobrazeniTabulek.webProp.nazev("pokracovat_ve_vyberu")}</a>

                    <%-- clear cart widget --%>
                    <c:if test="${!empty cart && cart.numberOfItems != 0}">
                        <c:url var="url" value="viewCart">
                            <c:param name="clear" value="true"/>
                        </c:url>
                        <c:choose>
                            <c:when test="${typKlient == 2}">
                                <a href="${url}" class="bubble hMargin">${zobrazeniTabulek.webProp.nazev("zrusit_rezervace")}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="${url}" class="bubble hMargin">${zobrazeniTabulek.webProp.nazev("zrusit_objednavky")}</a>
                            </c:otherwise>
                        </c:choose> 

                    </c:if>

                    <c:if test="${empty cart || cart.numberOfItems == 0}">
                        <p id="prazdnyKosikPopis">Nemáte vybranou žádnou akci</p>
                    </c:if>

                </div>

                <c:if test="${fn:length(chybneOsoby) > 0}">
                    <div id="chybneOsoby">
                        <table id="osobyOrgTableChyba">
                            <tr class="hlavniHeaderChyba">
                                <th colspan="4">
                                    ${zobrazeniTabulek.webProp.nazev("chybne_zadane_osoby")}
                                </th>
                            </tr>
                            <tr class="header">
                                <th>
                                    ${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}
                                </th>
                                <th>
                                    ${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}
                                </th>                                                     
                                <th>
                                    ${zobrazeniTabulek.webProp.nazev("tab_upravit")}
                                </th>
                            </tr>

                            <c:forEach var="prihlaseni" items="${chybneOsoby}" varStatus="iter">

                                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">

                                    <td width="150">
                                        ${prihlaseni.jmeno}               
                                    </td>
                                    <td width="180">
                                        ${prihlaseni.prijmeni}                           
                                    </td>                                              
                                    <td width="150">
                                        <form action="upravitOsobu" method="post">
                                            <input type="hidden"
                                                   name="osobaId"
                                                   id="osobaId"
                                                   value="${prihlaseni.osobaId}">
                                            <input type="submit"
                                                   name="submit"
                                                   class="cartTlacitkoOdebrat"
                                                   value="${zobrazeniTabulek.webProp.nazev("upravit")}">
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </table>  
                    </div>
                </c:if>            


                <c:if test="${!empty cart && cart.numberOfProducts != 0}">
                    <ul>
                        <c:forEach var="cartItem" items="${cart.items}" varStatus="iterKosik">         

                            <c:set var="product" value="${cartItem.product}"/>

                            <li>          
                                <p class="kosikCisloAkce">${zobrazeniTabulek.webProp.nazev("vybrana_akce")}: ${fn:substring(product.akceCislo,0,2)} - ${fn:substring(product.akceCislo,2,6)} - ${fn:substring(product.akceCislo,6,8)}
                                </p>
                                <c:if test="${typKlient == 2}">
                                    <form class="formPridatOsobu" action="pridatZamestnance" method="post">
                                        <input type="hidden"
                                               name="akceId"
                                               value="${product.akceId}">                                   
                                        <input type="submit"
                                               name="submit"
                                               class="tlacitkoPridatOsobu"
                                               value="${zobrazeniTabulek.webProp.nazev("pridatOsobu")}">                                  
                                    </form>
                                </c:if>
                                <form class="kosikOdebratAkce" action="odebratAkcezKosiku" method="post" >
                                    <input type="hidden"
                                           name="akceId"
                                           id="akceId"
                                           value="${product.akceId}">
                                    <input type="submit"
                                           name="submit"
                                           class="cartTlacitkoOdebratAkce"
                                           value="${zobrazeniTabulek.webProp.nazev("X")}">
                                </form>  
                                <p class="kosikNazevAkce">${product.nazev}</p>
                                <c:if test="${cartItem.prihlaseni != null}">
                                    <table id="osobyOrgTable">
                                        <tr class="hlavniHeader">
                                            <th colspan="4">
                                                ${zobrazeniTabulek.webProp.nazev("prihlasene_osoby")}
                                            </th>
                                        </tr>
                                        <tr class="header">
                                            <th>
                                                ${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}
                                            </th>
                                            <th>
                                                ${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}
                                            </th>
                                            <th>
                                                ${zobrazeniTabulek.webProp.nazev("uzivatel_zpusob_placeni")}
                                            </th>                        
                                            <th>
                                                ${zobrazeniTabulek.webProp.nazev("tab_odebrat")}
                                            </th>
                                        </tr>

                                        <c:forEach var="prihlaseni" items="${cartItem.prihlaseni}" varStatus="iter">

                                            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">

                                                <td width="130">
                                                    ${prihlaseni.jmeno}               
                                                </td>
                                                <td width="140">
                                                    ${prihlaseni.prijmeni}                           
                                                </td>
                                                <td width="150">
                                                    <%--onchange="document.location.href='viewCart?idOsoba='+&idDruhPrihl='+this.value'"--%>
                                                    <%--<fmt:formatDate value="${prihlaseni.datumNarozeni}" pattern="d.M.yyyy"/> --%>
                                                    <select id="placeniSelect" name="vyberDruhPrihlasky" size="1" onchange="document.location.href = 'viewCart?idDruhPrihl=${iterKosik.index}x${iter.index}x' + this.value">
                                                        <c:forEach var="druhPrihl" items="${druhyPrihlOrg}">       
                                                            <c:choose>
                                                                <c:when test="${cartItem.getDruhPrihlaskyAktualni(iter.index).druhPrihlId == druhPrihl.druhPrihlId}">
                                                                    <option selected value="${druhPrihl.druhPrihlId}">
                                                                        ${druhPrihl.nazev}
                                                                    </option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${druhPrihl.druhPrihlId}">
                                                                        ${druhPrihl.nazev}
                                                                    </option>
                                                                </c:otherwise>
                                                            </c:choose> 
                                                        </c:forEach>
                                                    </select>
                                                </td>                               
                                                <td width="100">
                                                    <form action="odebratLidizKosiku" method="post">
                                                        <input type="hidden"
                                                               name="osobaAkceId"
                                                               id="osobaAkceId"
                                                               value="${prihlaseni.osobaId}x${product.akceId}">
                                                        <input type="submit"
                                                               name="submit"
                                                               class="cartTlacitkoOdebrat"
                                                               value="${zobrazeniTabulek.webProp.nazev("odebrat")}">
                                                    </form>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                    </table>  
                                </c:if>

                                <div id="kosikCenaAkce">
                                    <span>${zobrazeniTabulek.webProp.nazev("cena_akce")}:</span>
                                    <span><fmt:formatNumber value="${cartItem.total}" pattern="######"/> ${zobrazeniTabulek.webProp.nazev("mena_czk")}</span>
                                </div>                                
                            </li>                        
                        </c:forEach>
                    </ul>
                    <div id="subtotal">
                        <p class="cenaObjs"> ${zobrazeniTabulek.webProp.nazev("cena_celkem")}: </p>
                        <p class="cenaSum"><fmt:formatNumber value="${cart.subtotal}" pattern="######"/> ${zobrazeniTabulek.webProp.nazev("mena_czk")}</p>
                    </div>
                </c:if>
                <c:if test="${!empty cart && cart.numberOfItems != 0}">
                    <c:choose>
                        <c:when test="${typKlient == 2}">
                            <a class="objednatOdkaz" href="checkout" >${zobrazeniTabulek.webProp.nazev("objednat")}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="objednatOdkaz" href="checkout" >${zobrazeniTabulek.webProp.nazev("rezervovat")}</a>
                        </c:otherwise>
                    </c:choose> 

                </c:if>
            </div> 
            <div id="cartRight">
                <ul>
                    <c:forEach var="panelyData" items ="${panelyData}">                        
                        <li class="statickeInfoListHelp">          
                            <p class="statickeInfoNazev">${panelyData.getNazev(zobrazeniTabulek.webProp.lang)}</p>
                            <div class="statickeInfoDiv">
                                <c:forEach var="vazbaPanelyData" items ="${panelyData.vazbaPanelyDataUlozisteCollection}">  
                                    <div>
                                        <img align="left" src="index?ulozisteData=${vazbaPanelyData.ulozisteData.ulozisteDataId}" name="fotoStat" alt="fotoStat">
                                    </div>
                                </c:forEach>
                                ${panelyData.getPopis(zobrazeniTabulek.webProp.lang)} 
                            </div>            
                        </li>                        
                    </c:forEach>
                </ul>
            </div>


        </div>

    </body>
</html>