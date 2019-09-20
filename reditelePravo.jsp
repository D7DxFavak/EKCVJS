<%-- 
    Document   : keStazeni
    Created on : 3.11.2011, 9:07:24
    Author     : 7Data Gotzy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrapperContainer">
            <div id="navigaceTop">
                <ul class="navigaceList">
                    <li> 
                        <a href="${kategorieZakladniPopis}?${panelOdkaz}">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(panelNazev)}</span>                                
                        </a></li>
                    <li>
                        <div class="slash">></div>
                    </li>    
                    <li> 
                        <a href="${kategorieZakladniPopis}?${kategorieZakladniPopis}.jsp">
                            <span class="navigacePopis">${zobrazeniTabulek.webProp.nazev(kategorieZakladniPopis)}</span>                                
                        </a>
                    </li>               
                </ul>
            </div>

            <div id="tableHeaderDokumenty">
                <div id ="headerDokumentyNazev">
                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&sort=0">           
                        <p>${zobrazeniTabulek.webProp.nazev("dokument_nazev")}</p>
                        <img src="img/doubleArrow.png" id="logUp" alt="da">   
                    </a>
                </div>
                <div id ="headerDokumentDatumVlozeni">
                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&sort=1">      
                        <p>${zobrazeniTabulek.webProp.nazev("datum_vlozeni")}</p>
                        <img src="img/doubleArrow.png" id="logUp" alt="da"> 
                    </a>
                </div>
                <div id ="headerDokumentVelikost">
                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&sort=1">      
                        <p>${zobrazeniTabulek.webProp.nazev("dokument_velikost")}</p>                        
                    </a>
                </div>
                <div id="headerDokumentPopis">                
                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&sort=2"> 
                        <p>${zobrazeniTabulek.webProp.nazev("dokument_popis")}</p>
                    </a>
                </div>
                <div id="headerDokumentStahnout">
                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&sort=3">
                        <p>${zobrazeniTabulek.webProp.nazev("dokument_stahnout")}</p></a>        
                    </a>
                </div>
            </div>   

            <table id="dokumentyTable">               
                <c:forEach var="dokument" items="${seznamDokumentu}" varStatus="iter">                
                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">     
                        <c:choose>
                            <c:when test = "${zobrazeniTabulek.idUloziste == dokument.ulozisteData.ulozisteDataId}">
                                <td width="163">
                                    ${dokument.ulozisteData.ulozisteDataPopis}                                               
                                </td>
                                <td width="125">
                                    <fmt:formatDate value="${dokument.ulozisteData.ulozisteDataVlozeno}" pattern="d.M.yyyy"/>                              
                                </td>                    
                                <td width="95">
                                    ${dokument.ulozisteData.getVelikost()}                                
                                </td>
                                <td width="80">
                                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&ulozisteDataId=${dokument.ulozisteData.ulozisteDataId}">${zobrazeniTabulek.webProp.nazev("data_popis")}</a>                               
                                </td>
                                <td width="90">                        
                                    <a class="tabDokumentyShop" href="pdf?kategorieDokument=${dokument.ulozisteData.ulozisteDataId}">                                       
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
                                    </a>   
                                </td>
                            </tr>
                            <tr class="detailDokumentList">
                                <td colspan="5" width="425">
                                    <p> ${dokument.ulozisteData.ulozisteDataPoznamky} </p>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td width="163">
                                    ${dokument.ulozisteData.ulozisteDataPopis}                                               
                                </td>
                                <td width="125">
                                    <fmt:formatDate value="${dokument.ulozisteData.ulozisteDataVlozeno}" pattern="d.M.yyyy"/>                              
                                </td>                    
                                <td width="95">
                                    ${dokument.ulozisteData.getVelikost()}                                
                                </td>
                                <td width="80">
                                    <a href="${kategorieZakladniPopis}?keStazeni.jsp&ulozisteDataId=${dokument.ulozisteData.ulozisteDataId}">${zobrazeniTabulek.webProp.nazev("data_popis")}</a>                               
                                </td>
                                <td width="90">    
                                    <a class="tabDokumentyShop" href="pdf?kategorieDokument=${dokument.ulozisteData.ulozisteDataId}">
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
                                    </a> 
                                </td>

                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>   
            <div id ="navigace">
                <p>${zobrazeniTabulek.webProp.nazev("tab_zobrazit_zaznamu")} :</p>               
                <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&pocetStrana=10">10</a>
                <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&pocetStrana=20">20</a>
                <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&pocetStrana=50">50</a>             
            </div>
            <div id="strana">
                <c:forEach var="strana" items="${strany}" varStatus="iter">
                    <c:choose>
                        <c:when test="${strana.cislo == -1}">
                            <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:when test="${strana.cislo == -2}">
                            <span>...</span>
                            <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navClass" href="${kategorieZakladniPopis}?keStazeni.jsp&offset=${strana.cislo}">${strana.retez}</a>
                        </c:otherwise>
                    </c:choose>                      
                </c:forEach>                                 
            </div>   
        </div>
    </body>
</html>
