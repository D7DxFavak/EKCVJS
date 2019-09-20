<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var='view' value='/prihlaskyAkce' scope='session' />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>       
         <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}</p>
        </div>
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
                        <c:forEach var="akce" items="${prihlaskyAkce}" varStatus="iter">
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
        <div id="wrapperPrihlaskyContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="ekcvjs?prihlaskyAkce.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("prihlasky_na_akce")}</span>                                
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
            </div>
            <div id="tableHeaderProgramy">
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
            </div>   --%>    



            <%--<table id="prihlaseniTable">          
             
                <c:forEach var="akce" items="${prihlaskyAkce}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">                       
                        <c:choose>
                            <c:when test = "${zobrazeniTabulek.idAkce == akce.akceId}">
                                <td width="80">
                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">
                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                    </a>                                            
                                </td>
                                <td width="495">
                                    <div id="divNazev">
                                        <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
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
                            <tr class="detailAkceShop">                           
                                <td colspan="5" width="625">     
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
                                            </c:forEach>                                             
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <td width="80">
                                <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">
                                    ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                </a>                                             
                            </td>
                            <td width="495">
                                <div id="divNazev">
                                    <a href="ekcvjs?prihlaskyAkce.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
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
                        </c:otherwise>
                    </c:choose>
                    </tr>
                </c:forEach>
            </table>--%>
            <%--<div id ="navigace">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&pocetStrana=10">10</a>
                <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&pocetStrana=20">20</a>
                <a class="navClass" href="ekcvjs?prihlaskyAkce.jsp&pocetStrana=50">50</a>             
            </div>
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
            </div>  --%>
        </div>
    </body>
</html>

