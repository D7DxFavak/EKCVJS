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

<script type="text/javascript">
    function setFocus() {
         document.getElementById('focusedLi').scrollIntoView();
    }
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Výběr akcí přihlášení</title>      
    </head>
    <body onload="setFocus()">   
        <div class="wrapperPrihlaskyNadpis">
            <p>...${zobrazeniTabulek.webProp.nazev("nova_prihlaska")}</p>
        </div>
        <div id="navig">    
            <div id="vyberOboruPrihlasky">
                <c:choose>
                    <c:when test="${zobrazeniTabulek.idOborSkupina == 4}">
                        <div id="vyberVzdelavaniUcitelu">
                            <a class="navClassAktivni" href="ekcvjs?novePrihlaseni.jsp&idSkupina=4">${zobrazeniTabulek.webProp.nazev("ucitele")}</a>
                        </div>
                        <div id="vyberJazykovaSkola">
                            <a class="navClassNeaktivni" href="ekcvjs?novePrihlaseni.jsp&idSkupina=3">${zobrazeniTabulek.webProp.nazev("js")}</a>
                        </div>  
                    </c:when>
                    <c:otherwise>
                        <div id="vyberVzdelavaniUcitelu">
                            <a class="navClassNeaktivni" href="ekcvjs?novePrihlaseni.jsp&idSkupina=4">${zobrazeniTabulek.webProp.nazev("ucitele")}</a>
                        </div>
                        <div id="vyberJazykovaSkola">
                            <a class="navClassAktivni" href="ekcvjs?novePrihlaseni.jsp&idSkupina=3">${zobrazeniTabulek.webProp.nazev("js")}</a>
                        </div>  
                    </c:otherwise>
                </c:choose>                 

            </div>
            <div id="fulltextSearch">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("hledat_akci")}</p>
                <form id="fulltextSearchForm" method="post"  action="fulltextHledani">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="hledanyText"
                           name="hledanyText"
                           value="${fulltextSearch}"
                           placeholder="${zobrazeniTabulek.webProp.nazev("hledat_akci")}">
                    
                </form>
            </div>
            <div id="Obory">
                <p class="wrapperP">${zobrazeniTabulek.webProp.nazev("filtr_obor")}</p>
                <select name="vyberObor" size="1" onchange="document.location.href = 'ekcvjs?novePrihlaseni.jsp&idObor=' + this.value + '&hledanyText=' + document.getElementById('hledanyText').value">
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
                <select name="vyberObdobi" size="1" onchange="document.location.href = 'ekcvjs?novePrihlaseni.jsp&idObdobi=' + this.value + '&hledanyText=' + document.getElementById('hledanyText').value">
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
                </div>               

                <div id="divSeznamKurzu">
                    <ul class="listSeznamKurzu">
                        <c:forEach var="akce" items="${akcePrihlaseni}" varStatus="iter">
                            <c:choose>
                                <c:when test = "${zobrazeniTabulek.idAkce == akce.akceId}">
                                    <li class="itemSeznamKurzu" id="focusedLi">
                                </c:when> 
                                <c:otherwise>
                                    <li class="itemSeznamKurzu">
                                </c:otherwise>
                            </c:choose>                            
                                <div class="kurzCisloAkce">
                                    <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">
                                        ${fn:substring(akce.akceCislo,0,2)} - ${fn:substring(akce.akceCislo,2,6)} - ${fn:substring(akce.akceCislo,6,8)}
                                    </a>
                                </div>
                                <div class="kurzNazevTerminAkce">
                                    <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
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
                                    <div class ="detailAkceInfo" id="focusedDiv">
                                        <div id="divCharShop">                                    
                                            <p class="tabDetailShop">${zobrazeniTabulek.webProp.nazev("tab_detail_charakteristika")}</p>            
                                            <div id="divObjednatShop">
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
                                                                           value="${zobrazeniTabulek.webProp.nazev("objednat")}">
                                                                   </c:when>
                                                                   <c:otherwise>
                                                                       value="${zobrazeniTabulek.webProp.nazev("tab_rezervovat")}">
                                                                   </c:otherwise>
                                                            </c:choose> 
                                                        </div> 
                                                    </c:if> 
                                                </form>
                                            </div>
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
            <%--<table id="prihlaseniTable">                                 
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
                                    <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">
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
                                        <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
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
                                                               value="${zobrazeniTabulek.webProp.nazev("objednat")}">
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
                                    <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">
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
                                        <a href="ekcvjs?novePrihlaseni.jsp&akceIdDetail=${akce.akceId}">${akce.nazev}</a>
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
                                                               value="${zobrazeniTabulek.webProp.nazev("objednat")}">
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
            </table>--%>
        </div>

    </div>
</body>
</html>
