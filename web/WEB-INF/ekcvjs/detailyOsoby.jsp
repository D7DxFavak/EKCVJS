<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='view' value='/detailyOsoby' scope='session' />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <div class="wrapperPrihlaskyNadpis">
            <p>${zobrazeniTabulek.webProp.nazev("detaily_osoby")}</p>
        </div>
        <div id="wrapperPrihlaskyContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=1">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("vybrana_osoba")}</span>                                
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
            <div id ="panelUdajeOsobaInfo">
                <div id="panelUdajeOsobaNadpis">
                    <p>${zobrazeniTabulek.webProp.nazev("detaily_osoby")}: </p>
                    <p>${klientPrihlaseni.titulPred} ${klientPrihlaseni.jmeno} ${klientPrihlaseni.prijmeni} ${klientPrihlaseni.titulZa}</p>
                </div>
                <div id="panelUdajeOsobaOdkazy">
                    <c:choose>
                        <c:when test="${zobrazeniTabulek.zobrazitTabulku == 1}">
                            <a class="activeHref" href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=1">${zobrazeniTabulek.webProp.nazev("detaily_osoby_info")}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=1">${zobrazeniTabulek.webProp.nazev("detaily_osoby_info")}</a>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${zobrazeniTabulek.zobrazitTabulku == 2}">
                            <a class="activeHref" href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=2">${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=2">${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}</a>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${zobrazeniTabulek.zobrazitTabulku == 3}">
                            <a class="activeHref" href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=3">${zobrazeniTabulek.webProp.nazev("absolvovane_akce")}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=3">${zobrazeniTabulek.webProp.nazev("absolvovane_akce")}</a>
                        </c:otherwise>
                    </c:choose>                   
                </div>
            </div>


            <c:choose>
                <c:when test="${zobrazeniTabulek.zobrazitTabulku == 1}">
                    <div id="panelUdajeOsobaLeft">
                        <div id="offsetOsoba">
                            <form action="potvrzeniOsoby" method="post" id="klientInfoForm">                   
                                <label for="titulpred">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_pred")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="titulpred"
                                       name="titulpred"
                                       value="${klientPrihlaseni.titulPred}">
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdneJmeno'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_jmeno")}</p>
                                </c:if> 
                                <label for="jmeno">${zobrazeniTabulek.webProp.nazev("uzivatel_jmeno")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="name"
                                       name="jmeno"
                                       value="${klientPrihlaseni.jmeno}">
                                <br>
                                <c:if test="${chybaRegistrace eq 'prazdnePrijmeni'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("prazdne_prijmeni")}</p>
                                </c:if> 
                                <label for="prijmeni">${zobrazeniTabulek.webProp.nazev("uzivatel_prijmeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="surname"
                                       name="prijmeni"
                                       value="${klientPrihlaseni.prijmeni}">
                                <br>
                                <label for="titulza">${zobrazeniTabulek.webProp.nazev("uzivatel_titul_za")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="titulza"
                                       name="titulza"
                                       value="${klientPrihlaseni.titulZa}">
                                <br>
                                <br>
                                <c:if test="${chybaRegistrace eq 'neniRodneCislo'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_rodne_cislo")}</p>
                                </c:if> 
                                <c:if test="${chybaRegistrace eq 'spatneRC'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("neplatne_rodne_cislo")}</p>
                                </c:if> 
                                <label for="rodnecislo">${zobrazeniTabulek.webProp.nazev("uzivatel_rodne_cislo")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="rodnecislo"
                                       name="rodnecislo"
                                       value="${klientPrihlaseni.rodneCislo}">
                                <br>
                                <label for="datumnarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_datum_narozeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="datumnarozeni"
                                       name="datumnarozeni"                       
                                       value="<fmt:formatDate value="${klientPrihlaseni.datumNarozeni}" pattern="d.M.yyyy"/>  ">
                                <br>
                                <label for="mistonarozeni">${zobrazeniTabulek.webProp.nazev("uzivatel_misto_narozeni")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="19"
                                       id="mistonarozeni"
                                       name="mistonarozeni"
                                       value="${klientPrihlaseni.mistoNarozeni}">
                                <br>
                                <div id="narodnostInfoDiv">
                                    <p class="detailyNarodnostP">${zobrazeniTabulek.webProp.nazev("uzivatel_narodnost")}:</p>
                                    <select class="detailyNarodnostSelect" name="vyberNarodnost" size="1">
                                        <c:forEach var="narodnost" items="${narodnosti}">       
                                            <c:choose>
                                                <c:when test="${narodnost.narodnostNazev eq klientPrihlaseni.narodnost}">
                                                    <option selected value="${narodnost.narodnostNazev}">${narodnost.narodnostNazev}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${narodnost.narodnostNazev}">${narodnost.narodnostNazev}</option>
                                                </c:otherwise>
                                            </c:choose> 
                                        </c:forEach>
                                    </select>
                                    <br>
                                </div>
                                <div id="prislusnostInfoDiv">
                                    <p class="detailyPrislusnostP">${zobrazeniTabulek.webProp.nazev("uzivatel_prislusnost")}:</p>
                                    <select class="detailyPrislusnostSelect" name="vyberPrislusnost" size="1">
                                        <c:forEach var="prislusnost" items="${statPrislusnosti}">       
                                            <c:choose>
                                                <c:when test="${prislusnost.statniPrislusnostNazev eq klientPrihlaseni.statniPrislusnost}">                                                          orgTypPol.katOrgPolozkyPK.katorgpolId == vyberKatOrgDruh}">
                                                    <option selected value="${prislusnost.statniPrislusnostNazev}">${prislusnost.statniPrislusnostNazev}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${prislusnost.statniPrislusnostNazev}">${prislusnost.statniPrislusnostNazev}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>                            
                                    <br>
                                </div>
                                <%--<label for="narodnost">${zobrazeniTabulek.webProp.nazev("uzivatel_narodnost")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="narodnost"
                                       name="narodnost"
                                       value="${klientPrihlaseni.narodnost}">  
                                <br>
                                <label for="prislusnost">${zobrazeniTabulek.webProp.nazev("uzivatel_prislusnost")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="prislusnost"
                                       name="prislusnost"
                                       value="${klientPrihlaseni.statniPrislusnost}">
                                <br>--%>
                                <br>                  
                                <c:if test="${chybaRegistrace eq 'chybiAdresyUdaje'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("zadejte_kompletni_adresu")}</p>
                                </c:if> 
                                <label for="adresa">${zobrazeniTabulek.webProp.nazev("uzivatel_adresa")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="adresa"
                                       name="adresa"
                                       value="${klientPrihlaseni.adresa}">           
                                <br>                           
                                <label for="mesto">${zobrazeniTabulek.webProp.nazev("uzivatel_mesto")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="mesto"
                                       name="mesto"
                                       value="${klientPrihlaseni.mesto}">    
                                <br>
                                <label for="psc">${zobrazeniTabulek.webProp.nazev("uzivatel_psc")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="psc"
                                       name="psc"
                                       value="${klientPrihlaseni.psc}"> 
                                <br>
                                <c:if test="${chybaRegistrace eq 'chybiEmail'}">
                                    <p class="loginError" >${zobrazeniTabulek.webProp.nazev("chybi_email")}</p>
                                </c:if> 
                                <br>                            
                                <label for="email">${zobrazeniTabulek.webProp.nazev("uzivatel_email")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="45"
                                       id="email"
                                       name="email"
                                       value="${klientPrihlaseni.EMail}">
                                <br>
                                <label for="telefon">${zobrazeniTabulek.webProp.nazev("uzivatel_telefon")}:</label>
                                <input type="text"
                                       size="31"
                                       maxlength="16"
                                       id="telefon"
                                       name="telefon"
                                       value="${klientPrihlaseni.telefon}">
                                <br>
                                <input type="hidden"
                                       name="osobaId"
                                       value="${klientPrihlaseni.osobaId}">
                                <input type="submit" value="Potvrdit" id="submitOsobaUdaje"/>                 
                            </form>
                        </div>
                    </div>                                    
                </c:when>
                <c:when test="${zobrazeniTabulek.zobrazitTabulku == 2}">
                    <div id="panelUdajeOsobaAkce">
                        <%--<div id="tableHeaderProgramy">
                            <div id ="headerCisloAkce">
                                <a href="ekcvjs?prihlaskyAkce.jsp&sort=0">                
                                    <c:choose>
                                        <c:when test="${sortCislo == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>
                                        
                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>
                                       
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerNazevAkce">
                                <a href="ekcvjs?prihlaskyAkce.jsp&sort=1">        
                                    <c:choose>
                                        <c:when test="${sortNazev == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>
                                          
                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>
                                   
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerTerminAkce">
                                <a href="ekcvjs?prihlaskyAkce.jsp&sort=2">         
                                    <c:choose>
                                        <c:when test="${sortTermin == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_termin")}</p>
                                          
                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_termin")}</p>
                               
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerCenaAkce">
                                <a href="ekcvjs?prihlaskyAkce.jsp&sort=3">                
                                    <c:choose>
                                        <c:when test="${sortCena == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cena")}</p>
                                          
                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cena")}</p>
                                      
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                        </div>    --%>

                        <div id="wrapper">
                            <div id="wrapperCenter">
                                <div id ="navigaceTop">
                                    <%--<div id ="razeniCisla">
                                        <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=10">10</a>
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=20">20</a>
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=50">50</a>             
                                    </div>--%>
                                    <div id="strana">
                                        <c:forEach var="strana" items="${strany}" varStatus="iter">
                                            <c:choose>
                                                <c:when test="${strana.cislo == -1}">
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:when>
                                                <c:when test="${strana.cislo == -2}">
                                                    <span>...</span>
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:otherwise>
                                            </c:choose>                      
                                        </c:forEach>                                 
                                    </div>
                                </div>           

                                <div id="divSeznamKurzu">
                                    <ul class="listSeznamKurzu">
                                        <c:forEach var="prihlaska" items="${prihlaskyAkce}" varStatus="iter">
                                            <c:set var="akce" value="${prihlaska.akce}"/> 
                                            <li class="itemSeznamKurzu">
                                                <div class="kurzCisloAkce">
                                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">
                                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                                    </a>
                                                </div>
                                                <div class="kurzNazevTerminAkce">
                                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
                                                    <p>${akce.terminObecny}, ${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin}</span>
                                                </div>
                                                <div class="kurzVolnoCenaAkce">                              
                                                    <c:choose>
                                                        <c:when test="${akce.volno == false}">
                                                            <p class="obsazenoText">
                                                                ${zobrazeniTabulek.webProp.nazev("tab_obsazeno")}
                                                            </p>        
                                                        </c:when>
                                                        <c:otherwise>
                                                            <p class="volnoText">
                                                                ${zobrazeniTabulek.webProp.nazev("tab_volno")}
                                                            </p>                                   
                                                        </c:otherwise>
                                                    </c:choose>   
                                                    <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>

                                                </div>
                                                <c:if test = "${zobrazeniTabulek.idAkce == akce.akceId}">
                                                    <div class ="detailAkceInfo">
                                                        <c:if test= "${prihlaseneOsoby != null}">
                                                            <div id="divPrihlaseniShop">                                       
                                                                <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_prihlaseni")}</p>                                    
                                                                <c:forEach var="osoba" items="${prihlaseneOsoby}" varStatus="iter">
                                                                    <ul class="tabPrihlaseniShop">
                                                                        <li>
                                                                            <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${osoba.osobaId}">
                                                                                ${osoba.titulPred} ${osoba.jmeno} ${osoba.prijmeni} ${osoba.titulZa}${not iter.last ? ',&nbsp ' : ' '} 
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </c:forEach>
                                                            </div>                                    
                                                        </c:if>
                                                        <div id="divCharShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_charakteristika")}</p>           

                                                            <p class="tabCharakteristikaShop">${akce.charakteristika}</p>
                                                        </div>

                                                        <div id="divDoporucenoShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_doporuceno")}</p>                                  
                                                            <p class="tabDoporucenoShop">${akce.doporuceno}</p>
                                                        </div>
                                                        <div id="divLektorShop">                                   
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_lektor")}</p>                                  
                                                            <ul>
                                                                <c:forEach var="lektor" items="${akce.akceLektoriCollection}" varStatus="iter">
                                                                    <li>
                                                                        ${lektor.osoby.titulPred} ${lektor.osoby.jmeno} ${lektor.osoby.prijmeni} ${lektor.osoby.titulZa}${not iter.last ? ',&nbsp' : '&nbsp'}  
                                                                    </li>
                                                                </c:forEach>
                                                                <li>
                                                                    ${akce.lektoriText}
                                                                </li>
                                                            </ul>
                                                        </div> 
                                                        <div id="divPocetHodinShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_rozsah")}</p>                                  
                                                            <p class="tabPocetHodinShop">${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin}, ${zobrazeniTabulek.webProp.nazev("tab_detail_typ_hodiny")} : ${akce.typHodiny.nazev}</p>
                                                        </div>
                                                        <div id="divMistoShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_misto_konani")}</p>                                
                                                            <p class="tabMistoShop">${akce.mistokonaniObecne}</p> 
                                                        </div> 
                                                        <div id="divGarantShop">                                   
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_garant")}</p>                                  
                                                            <p class="tabGarantShop">${akce.primObor.hlavniGarant.titulPred} ${akce.primObor.hlavniGarant.jmeno} ${akce.primObor.hlavniGarant.prijmeni} ${akce.primObor.hlavniGarant.titulZa}</p>
                                                        </div>                                  
                                                        <div id="divDokumentyShop">                                
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_dokumenty")}</p>                             
                                                            <ul>
                                                                <c:forEach var="dokument" items="${akce.vazbaAkceUlozisteDataCollection}" varStatus="iter">
                                                                    <c:if test="${dokument.ulozisteData.ulozisteDataDruhId.ulozisteDataDruhyId == 21 || dokument.ulozisteData.ulozisteDataDruhId.ulozisteDataDruhyId == 22}">
                                                                        <li>
                                                                            <a class="tabDokumentyShop" href="pdf?uloziste=${dokument.ulozisteData.ulozisteDataId}">                                       
                                                                                <c:choose>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'pdf'}">
                                                                                        <img src="img/pdf.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'doc'}">
                                                                                        <img src="img/word.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'docx'}">
                                                                                        <img src="img/word.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'xlsx'}">
                                                                                        <img src="img/excel.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'xls'}">
                                                                                        <img src="img/excel.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'ppt'}">
                                                                                        <img src="img/ppt.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'pptx'}">
                                                                                        <img src="img/ppt.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'rar'}">
                                                                                        <img src="img/rar.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'zip'}">
                                                                                        <img src="img/zip.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <img src="img/dlIcon.png" id="logoPDF" alt="dlIcon logo">
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                                <span>${dokument.ulozisteData.ulozisteDataNazev}</span>
                                                                            </a>   
                                                                        </li>
                                                                    </c:if>
                                                                </c:forEach>                                             
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </c:if>    
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>

                            </div>
                        </div>


                        <%--    <table id="prihlaseniTable">               
                                <c:forEach var="prihlaska" items="${prihlaskyAkce}" varStatus="iter">                
                                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                        <c:set var="akce" value="${prihlaska.akce}"/>                    
                                        <td width="80">
                                            <a href="index?akceHlavni.jsp&idAkce=${akce.akceId}">
                                                ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                            </a>                                                
                                        </td>
                                        <td width="495">
                                            <div id="divNazev">
                                                <a href="index?akceHlavni.jsp&idAkce=${akce.akceId}">${akce.nazev}</a>
                                            </div>                                
                                        </td>
                                        <td width="110">
                                            ${akce.terminObecny}
                                            <br>
                                            <span class="smallText">(${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin})</span>
                                        </td>
                                        <td width="75">
                                            <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>   
                                        </td>               
                                    </tr>
                                </c:forEach>
                            </table>
                            <div id ="navigace">
                                <div id="zobrZaznam">
                                    <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                                    <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=10">10</a>
                                    <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=20">20</a>
                                    <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=50">50</a>             
                                </div>
                                <div id="strana">
                                    <c:forEach var="strana" items="${strany}" varStatus="iter">
                                        <c:choose>
                                            <c:when test="${strana.cislo == -1}">
                                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                            </c:when>
                                            <c:when test="${strana.cislo == -2}">
                                                <span>...</span>
                                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                            </c:otherwise>
                                        </c:choose>                      
                                    </c:forEach>                                 
                                </div>
                            </div>--%>
                    </div>
                </c:when>
                <c:otherwise>           
                    <div id="panelUdajeOsobaAkce">
                        <div id="wrapper">
                            <div id="wrapperCenter">
                                <div id ="navigaceTop">
                                    <%--<div id ="razeniCisla">
                                        <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=10">10</a>
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=20">20</a>
                                        <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=50">50</a>             
                                    </div>--%>
                                    <div id="strana">
                                        <c:forEach var="strana" items="${strany}" varStatus="iter">
                                            <c:choose>
                                                <c:when test="${strana.cislo == -1}">
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:when>
                                                <c:when test="${strana.cislo == -2}">
                                                    <span>...</span>
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                                </c:otherwise>
                                            </c:choose>                      
                                        </c:forEach>                                 
                                    </div>
                                </div>           

                                <div id="divSeznamKurzu">
                                    <ul class="listSeznamKurzu">
                                        <c:forEach var="prihlaska" items="${prihlaskyAkce}" varStatus="iter">
                                            <c:set var="akce" value="${prihlaska.akce}"/> 
                                            <li class="itemSeznamKurzu">
                                                <div class="kurzCisloAkce">
                                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">
                                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                                    </a>
                                                </div>
                                                <div class="kurzNazevTerminAkce">
                                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
                                                    <p>${akce.terminObecny}, ${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin}</span>
                                                </div>
                                                <div class="kurzVolnoCenaAkce">                              
                                                    <c:choose>
                                                        <c:when test="${akce.volno == false}">
                                                            <p class="obsazenoText">
                                                                ${zobrazeniTabulek.webProp.nazev("tab_obsazeno")}
                                                            </p>        
                                                        </c:when>
                                                        <c:otherwise>
                                                            <p class="volnoText">
                                                                ${zobrazeniTabulek.webProp.nazev("tab_volno")}
                                                            </p>                                   
                                                        </c:otherwise>
                                                    </c:choose>   
                                                    <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>

                                                </div>
                                                <c:if test = "${zobrazeniTabulek.idAkce == akce.akceId}">
                                                    <div class ="detailAkceInfo">
                                                        <c:if test= "${prihlaseneOsoby != null}">
                                                            <div id="divPrihlaseniShop">                                       
                                                                <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_prihlaseni")}</p>                                    
                                                                <c:forEach var="osoba" items="${prihlaseneOsoby}" varStatus="iter">
                                                                    <ul class="tabPrihlaseniShop">
                                                                        <li>
                                                                            <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${osoba.osobaId}">
                                                                                ${osoba.titulPred} ${osoba.jmeno} ${osoba.prijmeni} ${osoba.titulZa}${not iter.last ? ',&nbsp ' : ' '} 
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                </c:forEach>
                                                            </div>                                    
                                                        </c:if>
                                                        <div id="divCharShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_charakteristika")}</p>           

                                                            <p class="tabCharakteristikaShop">${akce.charakteristika}</p>
                                                        </div>

                                                        <div id="divDoporucenoShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_doporuceno")}</p>                                  
                                                            <p class="tabDoporucenoShop">${akce.doporuceno}</p>
                                                        </div>
                                                        <div id="divLektorShop">                                   
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_lektor")}</p>                                  
                                                            <ul>
                                                                <c:forEach var="lektor" items="${akce.akceLektoriCollection}" varStatus="iter">
                                                                    <li>
                                                                        ${lektor.osoby.titulPred} ${lektor.osoby.jmeno} ${lektor.osoby.prijmeni} ${lektor.osoby.titulZa}${not iter.last ? ',&nbsp' : '&nbsp'}  
                                                                    </li>
                                                                </c:forEach>
                                                                <li>
                                                                    ${akce.lektoriText}
                                                                </li>
                                                            </ul>
                                                        </div> 
                                                        <div id="divPocetHodinShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_rozsah")}</p>                                  
                                                            <p class="tabPocetHodinShop">${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin}, ${zobrazeniTabulek.webProp.nazev("tab_detail_typ_hodiny")} : ${akce.typHodiny.nazev}</p>
                                                        </div>
                                                        <div id="divMistoShop">                                    
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_misto_konani")}</p>                                
                                                            <p class="tabMistoShop">${akce.mistokonaniObecne}</p> 
                                                        </div> 
                                                        <div id="divGarantShop">                                   
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_garant")}</p>                                  
                                                            <p class="tabGarantShop">${akce.primObor.hlavniGarant.titulPred} ${akce.primObor.hlavniGarant.jmeno} ${akce.primObor.hlavniGarant.prijmeni} ${akce.primObor.hlavniGarant.titulZa}</p>
                                                        </div>                                  
                                                        <div id="divDokumentyShop">                                
                                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_dokumenty")}</p>                             
                                                            <ul>
                                                                <c:forEach var="dokument" items="${akce.vazbaAkceUlozisteDataCollection}" varStatus="iter">
                                                                    <c:if test="${dokument.ulozisteData.ulozisteDataDruhId.ulozisteDataDruhyId == 21 || dokument.ulozisteData.ulozisteDataDruhId.ulozisteDataDruhyId == 22}">
                                                                        <li>
                                                                            <a class="tabDokumentyShop" href="pdf?uloziste=${dokument.ulozisteData.ulozisteDataId}">                                       
                                                                                <c:choose>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'pdf'}">
                                                                                        <img src="img/pdf.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'doc'}">
                                                                                        <img src="img/word.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'docx'}">
                                                                                        <img src="img/word.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'xlsx'}">
                                                                                        <img src="img/excel.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'xls'}">
                                                                                        <img src="img/excel.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'ppt'}">
                                                                                        <img src="img/ppt.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'pptx'}">
                                                                                        <img src="img/ppt.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'rar'}">
                                                                                        <img src="img/rar.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:when test = "${dokument.ulozisteData.ulozisteDataTyp eq 'zip'}">
                                                                                        <img src="img/zip.png" id="logoPDF" alt="dlIcon logo">   
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <img src="img/dlIcon.png" id="logoPDF" alt="dlIcon logo">
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                                <span>${dokument.ulozisteData.ulozisteDataNazev}</span>
                                                                            </a>   
                                                                        </li>
                                                                    </c:if>
                                                                </c:forEach>                                             
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </c:if>    
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <%--     <div id="tableHeaderProgramy">
                                 <div id ="headerCisloAkce">
                                     <a href="ekcvjs?absolvovaneAkce.jsp&sort=0">                
                                         <c:choose>
                                             <c:when test="${sortCislo == 0}">
                                                 <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>

                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>

                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerNazevAkce">
                                <a href="ekcvjs?absolvovaneAkce.jsp&sort=1">        
                                    <c:choose>
                                        <c:when test="${sortNazev == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>

                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>

                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerTerminAkce">
                                <a href="ekcvjs?absolvovaneAkce.jsp&sort=2">         
                                    <c:choose>
                                        <c:when test="${sortTermin == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cena")}</p>

                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("tab_cena")}</p>

                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                            <div id="headerCenaAkce">
                                <a href="ekcvjs?absolvovaneAkce.jsp&sort=3">                
                                    <c:choose>
                                        <c:when test="${sortCena == 0}">
                                            <p>${zobrazeniTabulek.webProp.nazev("certifikat_stahnout")}</p>

                                        </c:when>
                                        <c:otherwise>
                                            <p>${zobrazeniTabulek.webProp.nazev("certifikat_stahnout")}</p>

                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </div>
                        </div>     

                        <table id="prihlaseniTable">               
                            <c:forEach var="prihlaska" items="${prihlaskyAkce}" varStatus="iter">                
                                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                                    <c:set var="akce" value="${prihlaska.akce}"/>                    
                                    <td width="80">
                                        <a href="index?akceHlavni.jsp&idAkce=${akce.akceId}">
                                            ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                        </a>                                                
                                    </td>
                                    <td width="489">
                                        <div id="divNazev">
                                            <a href="index?akceHlavni.jsp&idAkce=${akce.akceId}">${akce.nazev}</a>
                                        </div>                                
                                    </td>
                                    <td width="110">
                                        <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>   
                                    </td>    
                                    <td width="73">
                                        <a class="tabDokumentyShop" href="pdf?polozka=${prihlaska.polozka}">                                       
                                            <img src="img/pdf.png" id="logoPDF" alt="pdf logo">   
                                        </a>
                                    </td>    
                                </tr>
                            </c:forEach>
                        </table>
                        <div id ="navigace">
                            <div id="zobrZaznam">
                                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=10">10</a>
                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=20">20</a>
                                <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&pocetStrana=50">50</a>             
                            </div>
                            <div id="strana">
                                <c:forEach var="strana" items="${strany}" varStatus="iter">
                                    <c:choose>
                                        <c:when test="${strana.cislo == -1}">
                                            <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                        </c:when>
                                        <c:when test="${strana.cislo == -2}">
                                            <span>...</span>
                                            <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="navClass" href="ekcvjs?novePrihlaseni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                                        </c:otherwise>
                                    </c:choose>                      
                                </c:forEach>                                 
                            </div>
                        </div>--%>
                    </div>                   
                </c:otherwise>
            </c:choose>            
        </div>
    </body>
</html>

<%--  <div id="tableHeaderAkce">
                           <div id ="headerCisloAkce">
                               <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=${zobrazeniTabulek.zobrazitTabulku}&sort=0">                
                                   <c:choose>
                                       <c:when test="${sortCislo == 0}">
                                           <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>
                                         
                                       </c:when>
                                       <c:otherwise>
                                           <p>${zobrazeniTabulek.webProp.nazev("tab_cislo")}</p>
                           
                                       </c:otherwise>
                                   </c:choose>
                               </a>
                           </div>
                           <div id="headerNazevAkce">
                               <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=${zobrazeniTabulek.zobrazitTabulku}&sort=1">        
                                   <c:choose>
                                       <c:when test="${sortNazev == 0}">
                                           <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>
                                        
                                       </c:when>
                                       <c:otherwise>
                                           <p>${zobrazeniTabulek.webProp.nazev("tab_nazev")}</p>
                               
                                       </c:otherwise>
                                   </c:choose>
                               </a>
                           </div>
                           <div id="headerCenaAkce">
                               <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=${zobrazeniTabulek.zobrazitTabulku}&sort=3">                      
                                   <c:choose>
                                       <c:when test="${sortCena == 0}">
                                         
                                           ${zobrazeniTabulek.webProp.nazev("tab_cena")}
                                       </c:when>
                                       <c:otherwise>
                                          ${zobrazeniTabulek.webProp.nazev("tab_cena")}
                                       </c:otherwise>
                                   </c:choose>
                               </a>
                           </div>
                           <div id="headerDokumentAkce">
                               <a href="ekcvjs?detailyOsoby.jsp&detailOsobaId=${klientPrihlaseni.osobaId}&zobrazTabulku=${zobrazeniTabulek.zobrazitTabulku}&sort=4">                
                                   ${zobrazeniTabulek.webProp.nazev("tab_dokument")}
                               </a>
                           </div>
                       </div>  --%>
