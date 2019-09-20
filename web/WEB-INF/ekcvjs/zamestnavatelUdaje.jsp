<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/klientskeUdaje' scope='session' />
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
                        <a href="ekcvjs?klientskeUdaje.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("zamestnavatel_udaje")}</span>                                
                        </a></li>
                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="ekcvjs?ekcvjs.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("ekcvjs")}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>--%>
            <div id="panelOrganizaceOsoba">
                <c:choose>
                    <c:when test="${registraceOK == true}">
                        <ul>
                            <li>
                                <p class="statickeInfoNazev">Zaslání registrace zaměstnavateli</p>                        
                                <div class="statickeInfoDiv">
                                    Právě jste zalsali žádost o registraci k Vašemu zaměnstavateli. Po schválení žádosti Vám bude umožněno objednávat si vzdělávací kurzy s možností jejich hrazení Vaším zaměstnavatelem.
                                </div>
                            </li>
                            <li>
                                <p class="statickeInfoNazev">Jak dlouho registrace trvá?</p>                        
                                <div class="statickeInfoDiv">
                                    Pokud jste již vyplnili předchozí registrační formulář, záleží rychlost registrace pouze na Vašem zaměstnavateli, aby Vás ve svém účtu eKCVJŠ přidal ke svým zaměstnancům a umožnil Vám nechat si proplácet navštěvované vzdělávací kurzy. 
                                    Pokud by Váš zaměstnavatel neobdržel informační e-mail o Vaší registraci, ať nás informuje a my zajistíme nápravu.
                                </div> 
                            </li>
                        </ul>   
                    </c:when>
                    <c:otherwise>
                        <ul>
                            <li>
                                <p class="statickeInfoNazev">Proč chceme informace o Vašem zaměstnavateli?</p>                        
                                <div class="statickeInfoDiv">
                                    Zde máte možnost zaregistrovat se k účtu Vašeho zaměstnavatele, což Vám umožní přihlašovat se na naše kurzy a Váš zaměstnavatel bude kurzy platit. 
                                    Jedinou podmínkou je, aby měl zaměstnavatel uzavřenou smlouvu s naší vzdělávací organizací. 
                                </div>
                            </li>
                            <li>
                                <p class="statickeInfoNazev">Jak registrace k účtu zaměsntavatele probíhá?</p>                        
                                <div class="statickeInfoDiv">
                                    Pokud ještě nemáte registraci hotovou, a formulář na této stránce je prázdný, nebo jste měnili zaměstnání, stačí do pole "Najít zaměstnavatele" zadat IČ 
                                    a po vyhledání výsledků stisknout tlačítko "zaregistrovat". Váš zaměstnavatel dostane upozornění e-mailem a poté, co Vás autorizuje, 
                                    můžete se přihlašovat na kurzy hrazenéVaším zaměstnavatelem. 
                                </div> 
                            </li>
                        </ul>         
                        
                        <c:if test="${vybranyZam == null && registrace==true}" >
                            <ul>
                            <li>
                                <p class="statickeInfoNazev">Hledání nebylo úspěšné</p>                        
                                <div class="statickeInfoDiv">
                                    Vámi zadané identifikační číslo (IČ) nebylo nalezeno v naší databázi. Buď bylo IČ špatně zadáno, nebo Váš zaměstnavatel není registrovaný u naší organizace.
                                </div>
                            </li>                           
                        </ul>        
                        </c:if>

                        <div id="hledatZamestnavatele">
                            <form action="najitZamestnavatele" method="post" id="hledatZamestnavateleForm">              
                                <label for="zamestnavatel_ic">${zobrazeniTabulek.webProp.nazev("najit_zamestnavatele")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="zamestnavatel_ic"
                                       name="zamestnavatel_ic"
                                       value="">
                                <input type="submit" value="Hledat" id="submitHledatZamestnavatel"/>                 
                            </form>

                            <c:if test="${zamestnavatele.size() > 0}">
                                <select id="vyberZamestnavatele" name="vyberZamestnavatele" size="1" onchange="document.location.href = 'ekcvjs?zamestnavatelUdaje.jsp&idOrganizace=' + this.value">
                                    <c:forEach var="zamestnavatel" items="${zamestnavatele}">                       
                                        <option value="${zamestnavatel.webOrgOsOrganizace.organizaceId}">${zamestnavatel.webOrgOsOrganizace.nazev}</option>
                                    </c:forEach>                         
                                </select>  
                            </c:if>                                
                            <c:if test="${vybranyZam != null}">
                                
                            <form action="registrovatZamestnavatele" method="post" id="zamestnavatelInfoForm">      
                                <label for="nazev">${zobrazeniTabulek.webProp.nazev("organizace_nazev")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="nazev"                              
                                       name="nazev"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.nazev}">
                                <br>
                                <label for="ic">${zobrazeniTabulek.webProp.nazev("registrace_ic")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"                                       
                                       id="ic"
                                       name="ic"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.ico}">
                                <br>  
                                <label for="dic">${zobrazeniTabulek.webProp.nazev("registrace_dic")}:*</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"                                       
                                       id="dic"
                                       name="dic"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.dic}">
                                <br> 

                                <legend></legend>
                                <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="adresa"
                                       name="adresa"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.adresa}">           
                                <br>
                                <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="mesto"
                                       name="mesto"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.mesto}">    
                                <br>
                                <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="psc"
                                       name="psc"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.psc}"> 
                                <br>
                                <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="30"
                                       id="telefon"
                                       name="telefon"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.telefon}">
                                <br>
                                <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="email"
                                       name="email"
                                       readonly="true"
                                       class="zamestnavatelInfoInput"
                                       value="${vybranyZam.EMail}">
                                <br>
                                <c:if test="${registrace == true}">
                                    <input type="submit" value="Registrovat" id="submitOsobaUdaje"/> 
                                </c:if>                                    
                            </form>                                
                            </c:if>                           
                        </div>
                    </c:otherwise>                  
                </c:choose>



            </div>
        </div>
    </body>
</html>
