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
        <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("osobni_udaje")}</p>
        </div>
        <div id="wrapperContainer">          
            <div id="panelOrganizaceOsoba">

                <h2>${zobrazeniTabulek.webProp.nazev("druh_uzivatel")} : ${zobrazeniTabulek.webProp.nazev("druh_uzivatele_organizace")}</h2>


                <form action="organizaceUdaje" method="post" id="organizaceInfoForm">               
                    <fieldset>
                        <legend></legend>
                        <label for="nazev">${zobrazeniTabulek.webProp.nazev("organizace_nazev")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"
                               id="nazev"
                               name="nazev"
                               <%--readonly="true"--%>
                               value="${klientPrihlaseni.nazev}">
                        <br>
                        <label for="nazevPlny1">${zobrazeniTabulek.webProp.nazev("organizace_nazevPlny1")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"
                               <%--readonly="true"--%>
                               id="nazevPlny1"
                               name="nazevPlny1"
                               value="${klientPrihlaseni.nazevPlny1}">
                        <br>         
                        <label for="ic">${zobrazeniTabulek.webProp.nazev("registrace_ic")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"                                       
                               id="ic"
                               name="ic"
                               value="${klientPrihlaseni.ico}">
                        <br>  
                        <label for="dic">${zobrazeniTabulek.webProp.nazev("registrace_dic")}:*</label>
                        <input type="text"
                               size="31"
                               maxlength="100"                                       
                               id="dic"
                               name="dic"
                               value="${klientPrihlaseni.dic}">
                        <br> 
                        <div id="katOrgTypy">
                            <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_typ_org")}</p>
                            <select name="vyberTypOrg" size="1" onchange="document.location.href = 'ekcvjs?organizaceUdaje.jsp&idTypOrg=' + this.value">
                                <c:forEach var="orgTyp" items="${katOrgTypy}">
                                    <c:choose>
                                        <c:when test="${orgTyp.katorgtypId == vyberKatOrgTyp}">
                                            <option selected value="${orgTyp.katorgtypId}" >${orgTyp.nazev}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${orgTyp.katorgtypId}">${orgTyp.nazev}</option>
                                        </c:otherwise>
                                    </c:choose>                 
                                </c:forEach>
                            </select>
                        </div>
                        <br> 
                        <div id="katOrgDruhy">
                            <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_druh_org")}</p>
                            <select name="vyberTypOrgPol" size="1" onchange="document.location.href = 'ekcvjs?organizaceUdaje.jsp&idDruhOrg=' + this.value">
                                <c:forEach var="orgTypPol" items="${katOrgPolozky}">       
                                    <c:choose>
                                        <c:when test="${orgTypPol.katOrgPolozkyPK.katorgtypId == vyberKatOrgTyp &&
                                                        orgTypPol.katOrgPolozkyPK.katorgpolId == vyberKatOrgDruh}">
                                                <option selected value="${orgTypPol.katOrgPolozkyPK.katorgpolId}">${orgTypPol.nazev}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${orgTypPol.katOrgPolozkyPK.katorgpolId}">${orgTypPol.nazev}</option>
                                        </c:otherwise>
                                    </c:choose> 

                                </c:forEach>
                            </select>
                        </div>
                        <br> 
                    </fieldset>
                    <fieldset>
                        <legend></legend>
                        <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"
                               id="adresa"
                               name="adresa"
                               value="${klientPrihlaseni.adresa}">           
                        <br>
                        <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"
                               id="mesto"
                               name="mesto"
                               value="${klientPrihlaseni.mesto}">    
                        <br>
                        <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="100"
                               id="psc"
                               name="psc"
                               value="${klientPrihlaseni.psc}"> 
                        <br>
                    </fieldset>
                    <fieldset>
                        <legend></legend>                        
                        <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="30"
                               id="telefon"
                               name="telefon"
                               value="${klientPrihlaseni.telefon}">
                        <br>
                        <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="email"
                               name="email"
                               value="${klientPrihlaseni.EMail}">
                        <br>
                        <label for="emailFakturace">${zobrazeniTabulek.webProp.nazev("uzivatel_email_fakturace")}:</label>
                        <input type="text"
                               size="31"
                               maxlength="45"
                               id="emailFakturace"
                               name="emailFakturace"
                               value="${klientPrihlaseni.eMailFakturace}">
                        <br>
                        <label for="fax">${zobrazeniTabulek.webProp.nazev("uzivatel_fax")}:*</label>
                        <input type="text"
                               size="31"
                               maxlength="30"
                               id="fax"
                               name="fax"
                               value="${klientPrihlaseni.fax}">
                        <br>                        
                        <label for="avizoPozvankyEmail">${zobrazeniTabulek.webProp.nazev("avizo_pozvanky")}:</label>
                        <input type="checkbox" id="avizoPozvankyEmail" name="avizoPozvankyEmail" <c:if test="${klientPrihlaseni.avizoEmailPozvanky eq true}">checked=checked</c:if> value="${klientPrihlaseni.avizoEmailPozvanky}"/>                            
                        <p id="nepovinneUdaje">${zobrazeniTabulek.webProp.nazev("nepovinne_udaje")}</p>
                        <br>
                        <input type="submit" value="Potvrdit" id="submitOrganizaceUdaje"/>     
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>
