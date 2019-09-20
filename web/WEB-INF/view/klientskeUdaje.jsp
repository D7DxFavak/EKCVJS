<%-- 
    Document   : klientskeUdaje
    Created on : 26.10.2011, 13:28:58
    Author     : 7Data Gotzy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/category' scope='session' />

<div id="indexTopColumn">
    <ul>
        <c:forEach var="category" items="${categories}">
            <li>
                <c:choose>
                    <c:when test="${category.webKategorieZakladniId == 10}">
                        <a href="index.jsp">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.webKategorieZakladniNazev}</span>                   
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="category?${category.webKategorieZakladniId}">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.webKategorieZakladniNazev}</span>                   
                        </a>
                    </c:otherwise>
                </c:choose>

                <ul>
                    <c:forEach var="catDetail" items ="${categoriesDetail}">
                        <c:if test="${catDetail.webKategorieDetailyPK.webKategorieDetailyKategorie == category.webKategorieZakladniId}">
                            <li>
                                <a href="detaily?${catDetail.webKategorieDetailyPK.webKategorieDetailyId}">
                                    <span class="catDetailLabel"></span>
                                    <span class="catDetailLabelText">${catDetail.webKategorieDetailyNazev}</span>                                   
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>  
    </ul>
</div>

<div id="panelLeftColumn">
    <div id="leftColumnUl1">
        <ul>
            <c:forEach var="panely" items="${panelyData}">     
                <li> 
                    <a href="category?${panely.webPanelyDataPK.webPanelyDataId}" class="panelButton">
                        <span class="panelText">
                            ${panely.webPanelyDataNazev}
                        </span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div id="leftColumnUl2">
        <ul></ul>
    </div>
    <div id="leftColumnUl3">
        <ul></ul>
    </div>
</div>

<div id="panelRightColumn">
    <div id="rightColumnUl1">
        <ul>
            <c:forEach var="aktuality" items ="${aktualitySouhrn}">                        
                <li>
                    <p class="datumAktuality">${aktuality.webAktualityDatumVlozeni}</p>
                    <a href="aktuality?${aktuality.webAktualityPK.webAktualityId}">
                        <span class="aktualityLabel"></span>
                        <span class="aktualityLabelText">${aktuality.webAktualityNazev}</span>

                        <%-- <img src="${initParam.categoryImagePath}${category.webKategorieZakladniId}.jpg"
                              alt="${category.webKategorieZakladniNazev}" class="categoryImage">--%>
                    </a>
                </li>                        
            </c:forEach>
        </ul>
    </div>
    <div id="rightColumnUl2">
        <ul></ul>
    </div>
    <div id="rightColumnUl3">
        <div id="footerEsf">
            <a href="http://http://www.strukturalni-fondy.cz/">
                <img src="img/logoesf.jpg" id="logo" alt="ESF logo">
            </a>
        </div>
    </div>
</div>
