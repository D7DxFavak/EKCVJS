<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">

    var list;
    var listValue;

    function changeFunc(katorgID) {
        if (katorgID == 1) {
            list = new Array("Základní škola", "Základní a mateřská škola", "Základní umělecká škola", "Speciální škola",
                    "Mateřská škola", "Speciální MŠ", "Střední škola", "Jazyková škola", "Ostatní");
            listValue = new Array(1, 2, 3, 4, 5, 6, 7, 8, 999);
        }
        if (katorgID == 2) {
            list = new Array("Pedagogické centrum", "PP poradna", "Dům dětí a mládeže", "Občanské sdružení", "Diagnostický ústav",
                    "Školní statek", "Školní jídelna", "Dětský domov", "Ochranné zařízení", "Ostatní");
            listValue = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 999);
        }
        if (katorgID == 3) {
            list = new Array("Ministerstvo", "Obce s rozšířenou působností - školství", "Ostatní");
            listValue = new Array(1, 2, 999);
        }
        if (katorgID == 4) {
            list = new Array("Všechny");
            listValue = new Array(1);
        }
        if (katorgID == 5) {
            list = new Array("Všechny");
            listValue = new Array(1);
        }
        if (katorgID == 6) {
            list = new Array("Všechny");
            listValue = new Array(1);
        }
        if (katorgID == 999) {
            list = new Array("Ostatní");
            listValue = new Array(999);
        }

        for (var i = 0; i < document.organizaceRegistraceForm.vyberTypOrg.length; i++) { //Clear the 2nd menu
            document.organizaceRegistraceForm.vyberTypOrgPol.options[i] = null;
        }

        for (var i = 0; i < list.length; i++) { //Repopulate 2nd menu
            document.organizaceRegistraceForm.vyberTypOrgPol.options[i] = new Option(list[i], listValue[i], 0, 0);
        }
    }

</script>

<c:set var='view' value='/registrace' scope='session' />
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="$/css/affablebean2.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>         
        <div id="wrapperRegistrace">            
            <div id="panelRegistrace">
                <h2 class="registraceNadpis">${zobrazeniTabulek.webProp.nazev("zalozeni_uctu_ekcvjs")}</h2>
              
                <c:choose>
                    <c:when test="${zobrazeniTabulek.druhUzivatel == 1}">
                        <form action="registrace" method="post" id="registraceForm">
                            <fieldset>
                                <legend></legend>
                                <c:if test="${chybaRegistrace eq 'prazdnyLogin'}">
                                    <p class="loginError">${zobrazeniTabulek.webProp.nazev("prazdny_login")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'loginsmezerou'}">
                                    <p class="loginError">${zobrazeniTabulek.webProp.nazev("login_s_mezerou")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'loginsdiakritikou'}">
                                    <p class="loginError">${zobrazeniTabulek.webProp.nazev("login_s_diakritikou")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'existujiciLogin'}">
                                    <p class="loginError">${zobrazeniTabulek.webProp.nazev("existujici_login")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'jizRegistrovanaOsoba'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("jiz_registrovana_osoba")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'neplatneUdaje'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_udaje")}</p>
                                </c:if> 

                                <label for="loginJmeno">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="loginJmeno"
                                       name="loginJmeno"
                                       value="${param.loginJmeno}">


                                <c:if test="${chybaRegistrace eq 'spatnaHesla'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("ruzna_hesla")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'kratkeHeslo'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("kratka_hesla")}</p>
                                </c:if> 

                                <label for="hesloPrvni">${zobrazeniTabulek.webProp.nazev("zadejte_heslo")}:</label>
                                <input type="password"
                                       size="31"
                                       maxlength="45"
                                       id="hesloPrvni"
                                       name="hesloPrvni"
                                       value="${param.hesloPrvni}">
                                <br>
                                <label for="hesloZnovu">${zobrazeniTabulek.webProp.nazev("potvrdte_heslo")}:</label>
                                <input type="password"
                                       size="31"
                                       maxlength="45"
                                       id="hesloZnovu"
                                       name="hesloZnovu"
                                       value="${param.hesloZnovu}">
                                <br>                           
                            </fieldset>
                            <fieldset>
                                <legend></legend>
                                <label for="titulpred">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_pred")}:*</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="titulpred"
                                       name="titulpred"
                                       value="${param.titulpred}">
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdneJmeno'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_jmeno")}</p>
                                </c:if> 
                                <label for="jmeno">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="jmeno"
                                       name="jmeno"
                                       value="${param.jmeno}">
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdnePrijmeni'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_prijmeni")}</p>
                                </c:if> 
                                <label for="prijmeni">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="prijmeni"
                                       name="prijmeni"
                                       value="${param.prijmeni}">
                                <br>
                                <label for="titulza">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_za")}:*</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="titulza"
                                       name="titulza"
                                       value="${param.titulza}">
                                <br>
                            </fieldset>
                            <fieldset>
                                <legend></legend>
                                <div id="registraceRCCheck">
                                    <input type="checkbox" name="neexRodneCislo" value="${param.neexrodnecislo} "onclick="if (this.checked) {
                                                this.form.rodnecislo.disabled = 1
                                            } else {
                                                this.form.rodnecislo.disabled = 0
                                            }"/>
                                    <span>${zobrazeniTabulek.webProp.nazev("neexistuje_rodne_cislo")}</span>
                                </div>
                                <div id="registraceNezletilostCheck">
                                    <input type="checkbox" name="nezletilaOsoba" value="true" />
                                    <span>${zobrazeniTabulek.webProp.nazev("nezletila_osoba")}</span>
                                </div>
                                <c:if test="${chybaRegistrace eq 'neniRodneCislo'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_rodne_cislo")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'spatneRC'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_rodne_cislo")}</p>
                                </c:if> 
                                <label for="rodnecislo">${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}:*</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="rodnecislo"
                                       name="rodnecislo"
                                       value="${param.rodnecislo}">                               
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdneDatumNarozeni'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_datum_narozeni")}</p>
                                </c:if> 
                                <label for="datumnarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="datumnarozeni"
                                       name="datumnarozeni"
                                       value="${param.datumnarozeni}">
                                <br>
                                <label for="mistonarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_misto_narozeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="mistonarozeni"
                                       name="mistonarozeni"
                                       value="${param.mistonarozeni}">
                                <br>                                
                            </fieldset>
                            <fieldset>
                                <legend></legend>
                                <c:if test="${chybaRegistrace eq 'prazdnaAdresa'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdna_adresa")}</p>
                                </c:if> 
                                <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="adresa"
                                       name="adresa"
                                       value="${param.adresa}">           
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdneMesto'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_mesto")}</p>
                                </c:if> 
                                <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="mesto"
                                       name="mesto"
                                       value="${param.mesto}">    
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdnePSC'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_psc")}</p>
                                </c:if> 
                                <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="psc"
                                       name="psc"
                                       value="${param.psc}"> 
                                <br>
                                <br>
                                <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                                </c:if>
                                <c:if test="${chybaRegistrace eq 'duplicitniEmail'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("duplicitni_email")}</p>
                                </c:if>
                                <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="email"
                                       name="email"
                                       value="${param.email}">
                                <br>                                
                                <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="16"
                                       id="telefon"
                                       name="telefon"
                                       value="${param.telefon}">
                                <br>
                                <p id="nepovinneUdaje">${zobrazeniTabulek.webProp.nazev("nepovinne_udaje")}</p>                                                              
                                <c:choose>
                                    <c:when test="${zobrazeniTabulek.potvrzeni eq 'yes'}">            
                                        <div id="registracePotvrzeni">
                                            <input type="checkbox" name="souhlasPodminky" checked="${zobrazeniTabulek.potvrzeni}"                                                    />
                                            <span>${zobrazeniTabulek.webProp.nazev("souhlas_podminky")} (${zobrazeniTabulek.webProp.nazev("ke_stazeni")} 
                                                <a href="index?registrace.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a>)</span>
                                        </div>
                                        <input name="submitOsobaUdaje" type="submit" value="Potvrdit" id="submitOsobaUdaje"/> 
                                    </c:when>
                                    <c:otherwise>
                                        <div id="registracePotvrzeni">
                                            <input type="checkbox" name="souhlasPodminky" checked="checked"
                                                   onclick="if (this.checked) {
                                                               this.form.submitOsobaUdaje.disabled = 0
                                                           } else {
                                                               this.form.submitOsobaUdaje.disabled = 1
                                                           }"/>
                                            <span>${zobrazeniTabulek.webProp.nazev("souhlas_podminky")} (${zobrazeniTabulek.webProp.nazev("ke_stazeni")} 
                                                <%--<a href="index?registrace.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a>--%>
                                                <a href="pdf?kategorieDokument=73811">${zobrazeniTabulek.webProp.nazev("zde")}</a>
                                                ) </span>
                                        </div>
                                        <input name="submitOsobaUdaje" type="submit" value="Potvrdit" id="submitOsobaUdaje"/>   
                                    </c:otherwise>
                                </c:choose>


                            </fieldset>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="registrace" method="post" id="organizaceInfoForm" name="organizaceRegistraceForm">               
                            <fieldset>
                                <legend></legend>
                                <c:if test="${chybaRegistrace eq 'existujiciLogin'}">
                                    <p class="loginError">Existující uživatelske jmeno</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'jizRegistrovanaOsoba'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("jiz_registrovana_osoba")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'neplatneUdaje'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_udaje")}</p>
                                </c:if> 

                                <label for="loginJmeno">${zobrazeniTabulek.webProp.nazev("uzivatelske_jmeno")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="loginJmeno"
                                       name="loginJmeno"
                                       value="${param.loginJmeno}">


                                <c:if test="${chybaRegistrace eq 'spatnaHesla'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("ruzna_hesla")}</p>
                                </c:if> 

                                <label for="hesloPrvni">${zobrazeniTabulek.webProp.nazev("zadejte_heslo")}:</label>
                                <input type="password"
                                       size="31"
                                       maxlength="45"
                                       id="hesloPrvni"
                                       name="hesloPrvni"
                                       value="${param.hesloPrvni}">
                                <br>
                                <label for="hesloZnovu">${zobrazeniTabulek.webProp.nazev("potvrdte_heslo")}:</label>
                                <input type="password"
                                       size="31"
                                       maxlength="45"
                                       id="hesloZnovu"
                                       name="hesloZnovu"
                                       value="${param.hesloZnovu}">
                                <br>                           
                            </fieldset>
                            <fieldset>
                                <legend></legend>
                                <div id="katOrgTypy">
                                    <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_typ_org")}:</p>
                                    <select id="vyberTypOrg" name="vyberTypOrg" size="1" onchange="changeFunc(this.value)">
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
                                    <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_druh_org")}:</p>
                                    <select name="vyberTypOrgPol" size="1">
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
                                <label for="nazev">${zobrazeniTabulek.webProp.nazev("organizace_nazev")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="nazev"
                                       name="nazev"                                      
                                       value="${klientPrihlaseni.nazev}">
                                <br>
                                <label for="nazevPlny1">${zobrazeniTabulek.webProp.nazev("organizace_nazevPlny1")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"                                       
                                       id="nazevPlny1"
                                       name="nazevPlny1"
                                       value="${klientPrihlaseni.nazevPlny1}">
                                <br>  
                                <c:if test="${chybaRegistrace eq 'duplIC'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("dupl_IC")}</p>
                                </c:if> 
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

                            </fieldset>
                            <fieldset>
                                <legend></legend>
                                <c:if test="${chybaRegistrace eq 'chybiAdresa'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_adresa")}</p>
                                </c:if> 
                                <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="adresa"
                                       name="adresa"
                                       value="${klientPrihlaseni.adresa}">           
                                <br>
                                <c:if test="${chybaRegistrace eq 'chybiMesto'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_mesto")}</p>
                                </c:if> 
                                <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="100"
                                       id="mesto"
                                       name="mesto"
                                       value="${klientPrihlaseni.mesto}">    
                                <br>
                                <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                                </c:if> 
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
                                <c:if test="${chybaRegistrace eq 'chybiTelefon'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_telefon")}</p>
                                </c:if> 
                                <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="16"
                                       id="telefon"
                                       name="telefon"
                                       value="${klientPrihlaseni.telefon}">
                                <br>
                                <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                                </c:if> 
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
                                       id="email"
                                       name="emailFakturace"
                                       value="${klientPrihlaseni.EMailFakturace}">
                                <br>
                                <label for="fax">${zobrazeniTabulek.webProp.nazev("uzivatel_fax")}:*</label>
                                <input type="text"
                                       size="31"
                                       maxlength="16"
                                       id="fax"
                                       name="fax"
                                       value="${klientPrihlaseni.fax}">
                                <br>   
                                <p id="nepovinneUdaje">${zobrazeniTabulek.webProp.nazev("nepovinne_udaje")}</p>                                
                                <div id="registracePotvrzeni">
                                    <input type="checkbox" name="souhlasPodminky" checked="checked" onclick="if (this.checked) {
                                                this.form.submitOrganizaceUdaje.disabled = 0
                                            } else {
                                                this.form.submitOrganizaceUdaje.disabled = 1
                                            }" />
                                    <span>${zobrazeniTabulek.webProp.nazev("souhlas_podminky")} (${zobrazeniTabulek.webProp.nazev("ke_stazeni")} 
                                        <a href="index?registrace.jsp">${zobrazeniTabulek.webProp.nazev("zde")}</a>)</span>
                                </div>
                                <input name="submitOrganizaceUdaje" type="submit" value="Potvrdit" id="submitOrganizaceUdaje"/>     
                            </fieldset>
                        </form>
                    </c:otherwise>                                                                          
                </c:choose>
            </div>
        </div>
    </body>
</html>
