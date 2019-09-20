<%-- 
    Document   : novePrihlaseni
    Created on : 5.11.2011, 12:46:05
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Výběr akcí přihlášení</title>      
    </head>
    <body>   
        <div id="wrapperPrihlaskyContainer">
            <%--<div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="index?index.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("vzdelavaci_programy")}</span>                                
                        </a>
                    </li>  
                    <li>
                        <div class="slash">></div>
                    </li>  
                    <li> 
                        <a href="index?vzdProgramy.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev("index")}</span>                                
                        </a>
                    </li> 
                </ul>
            </div>--%>
            <div id="skupinaOboru">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_skupina_oboru")}</p>
                <select name="vyberSkupinaOboru" size="1" onchange="document.location.href='index?vzdProgramy.jsp&idSkupina='+this.value">
                    <c:forEach var="skupina" items="${oborySkupiny}">
                        <c:choose>
                            <c:when test="${zobrazeniTabulek.idOborSkupina == skupina.oborySkupinyId}">
                                <option selected value="${skupina.oborySkupinyId}" >${skupina.oborySkupinyPopis}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${skupina.oborySkupinyId}">${skupina.oborySkupinyPopis}</option>
                            </c:otherwise>
                        </c:choose>                 
                    </c:forEach>
                </select>
            </div>
            <div id="Obory">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_obor")}</p>
                <select name="vyberObor" size="1" onchange="document.location.href='index?vzdProgramy.jsp&idObor='+this.value">
                    <c:forEach var="oborSkupina" items="${vybraneOborySkupiny}">       
                        <c:choose>
                            <c:when test="${zobrazeniTabulek.idObor == oborSkupina.obory.oborId}">
                                <option selected value="${oborSkupina.obory.oborId}"><c:if test="${oborSkupina.obory.oborId  > 0}">
                                        ${oborSkupina.obory.oborId} -
                                    </c:if>${oborSkupina.obory.nazev}
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${oborSkupina.obory.oborId}">
                                    <c:if test="${oborSkupina.obory.oborId  > 0}">
                                        ${oborSkupina.obory.oborId} -
                                    </c:if>${oborSkupina.obory.nazev}
                                </option>
                            </c:otherwise>
                        </c:choose> 
                    </c:forEach>
                </select>
            </div>
            <div id="obdobi">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_obdobi")}</p>
                <select name="vyberObdobi" size="1" onchange="document.location.href='index?vzdProgramy.jsp&idObdobi='+this.value">
                    <c:forEach var="obdobi" items="${obdobiSet}">
                        <c:choose>
                            <c:when test="${zobrazeniTabulek.idObdobi == obdobi.obdobiId}">
                                <option selected value="${obdobi.obdobiId}">${obdobi.nazev}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${obdobi.obdobiId}">${obdobi.nazev}</option>
                            </c:otherwise>
                        </c:choose> 

                    </c:forEach>
                </select>
            </div>

            <div id="tableHeaderAkce">
                <div id ="headerVolnoAkce">
                    <a href="dvpp?vzdProgramy.jsp&sort=5">                
                      
                    </a>
                </div>
                <div id ="headerCisloAkce">
                    <a href="ekcvjs?novePrihlaseni.jsp&sort=0">                
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
                    <a href="ekcvjs?novePrihlaseni.jsp&sort=1">        
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
                    <a href="ekcvjs?novePrihlaseni.jsp&sort=2">         
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
                    <a href="ekcvjs?novePrihlaseni.jsp&sort=3">                
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
            </div>
            <table id="prihlaseniTable">                                 
                <c:forEach var="akce" items="${akcePrihlaseni}" varStatus="iter">
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                        <c:choose>
                            <c:when test = "${zobrazeniTabulek.idAkce == akce.akceId}">
                                <td width="20">
                                    <c:choose>
                                        <c:when test="${akce.volno == false}">
                                            <img src="img/redDot.png" id="tabRedDot" alt="r">       
                                        </c:when>
                                        <c:otherwise>
                                            <img src="img/greenDot.png" id="tabGreenDot" alt="g">                                  
                                        </c:otherwise>
                                    </c:choose>  
                                </td>
                                <td width="90">
                                    <a href="index?vzdProgramy.jsp&akceIdDetail=${akce.akceId}">
                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                    </a>
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
                                </td>
                                <td width="370">
                                    <div id="divNazev">
                                        <a href="index?vzdProgramy.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
                                    </div>                            
                                </td>
                                <td width="140">
                                    ${akce.terminObecny}
                                    <br>
                                    <span class="smallText">(${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin})</span>
                                </td>
                                <td width="115">
                                    <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>                            
                                    <form action="<c:url value='pridatDoKosiku'/>" method="post">
                                        <input type="hidden"
                                               name="akceId"
                                               value="${akce.akceId}">
                                        <c:if test="${akce.volno == true}">
                                            <div>
                                                <input type="submit"
                                                       name="submit"
                                                       class="tlacitkoRezervace"
                                                       <c:choose>
                                                            <c:when test="${typKlient == 2}">
                                                               value="${zobrazeniTabulek.webProp.nazev("tab_objednat")}">
                                                            </c:when>
                                                            <c:otherwise>
                                                                value="${zobrazeniTabulek.webProp.nazev("tab_rezervovat")}">
                                                            </c:otherwise>
                                                        </c:choose>   
                                            </div> 
                                        </c:if> 
                                    </form>
                                </td>
                            </tr>
                            <tr class="detailAkceShop">

                                <td colspan="5" width="625">                               
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
                            </c:when>
                            <c:otherwise>
                                <td width="20">
                                    <c:choose>
                                        <c:when test="${akce.volno == false}">
                                            <img src="img/redDot.png" id="tabRedDot" alt="r">       
                                        </c:when>
                                        <c:otherwise>
                                            <img src="img/greenDot.png" id="tabGreenDot" alt="g">                                  
                                        </c:otherwise>
                                    </c:choose>  
                                </td>
                                <td width="90">
                                    <a href="index?vzdProgramy.jsp&akceIdDetail=${akce.akceId}">
                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                    </a>
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
                                </td>
                                <td width="370">
                                    <div id="divNazev">
                                        <a href="index?vzdProgramy.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
                                    </div>                               
                                </td>
                                <td width="140">
                                    ${akce.terminObecny}
                                    <br>
                                    <span class="smallText">(${zobrazeniTabulek.webProp.nazev("tab_pocet_hodin")} : ${akce.pocetHodin})</span>
                                </td>
                                <td width="115">
                                    <p class="cenaTabulka"><fmt:formatNumber value="${akce.ucastnickyPoplatek}" pattern="######"/> Kč</p>               
                                    <form action="<c:url value='pridatDoKosiku'/>" method="post">
                                        <input type="hidden"
                                               name="akceId"
                                               value="${akce.akceId}">
                                        <c:if test="${akce.volno == true}">
                                            <div>
                                                <input type="submit"
                                                       name="submit"
                                                       class="tlacitkoRezervace"
                                                       <c:choose>
                                                            <c:when test="${typKlient == 2}">
                                                               value="${zobrazeniTabulek.webProp.nazev("tab_objednat")}">
                                                            </c:when>
                                                            <c:otherwise>
                                                                value="${zobrazeniTabulek.webProp.nazev("tab_rezervovat")}">
                                                            </c:otherwise>
                                                        </c:choose> 
                                            </div> 
                                        </c:if> 
                                    </form>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>

            <div id ="navigace">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClass" href="index?vzdProgramy.jsp&pocetStrana=10">10</a>
                <a class="navClass" href="index?vzdProgramy.jsp&pocetStrana=20">20</a>
                <a class="navClass" href="index?vzdProgramy.jsp&pocetStrana=50">50</a>             
            </div>
            <div id="strana">
                <c:forEach var="strana" items="${strany}" varStatus="iter">
                    <c:choose>
                        <c:when test="${strana.cislo == -1}">
                            <a class="navClass" href="index?vzdProgramy.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:when test="${strana.cislo == -2}">
                            <span>...</span>
                            <a class="navClass" href="index?vzdProgramy.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navClass" href="index?vzdProgramy.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:otherwise>
                    </c:choose>                      
                </c:forEach>                                 
            </div>
        </div>
    </body>
</html>
