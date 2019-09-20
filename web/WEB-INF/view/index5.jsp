<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/index' scope='session' />
<%--<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>--%>

<%--<div id="indexLeftColumn">
    <div id="welcomeText">
        <p style="font-size: larger"><fmt:message key='greeting'/></p>
        <p><fmt:message key='introText'/></p>       
    </div>
</div>--%>

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
                        <ul>
                            <c:forEach var="catDetail" items ="${categoriesDetail}">
                                <c:if test="${catDetail.webKategorieDetailyPK.webKategorieDetailyKategorie == 10}">
                                    <li>
                                        <a href="detaily?${catDetail.webKategorieDetailyOdkaz}">
                                            <span class="catDetailLabel"></span>
                                            <span class="catDetailLabelText">${catDetail.webKategorieDetailyNazev}</span>

                                            <%-- <img src="${initParam.categoryImagePath}${category.webKategorieZakladniId}.jpg"
                                                  alt="${category.webKategorieZakladniNazev}" class="categoryImage">--%>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <a href="category?${category.webKategorieZakladniId}">
                            <span class="categoryLabel"></span>
                            <span class="categoryLabelText">${category.webKategorieZakladniNazev}</span>                   
                        </a>
                        <ul>
                            <c:forEach var="catDetail" items ="${categoriesDetail}">
                                <c:if test="${catDetail.webKategorieDetailyPK.webKategorieDetailyKategorie == category.webKategorieZakladniId}">
                                    <li>
                                        <a href="detaily?${catDetail.webKategorieDetailyOdkaz}">
                                            <span class="catDetailLabel"></span>
                                            <span class="catDetailLabelText">${catDetail.webKategorieDetailyNazev}</span>

                                            <%-- <img src="${initParam.categoryImagePath}${category.webKategorieZakladniId}.jpg"
                                                  alt="${category.webKategorieZakladniNazev}" class="categoryImage">--%>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </c:otherwise>
                </c:choose>


            </li>
        </c:forEach>  
    </ul>  
</div>

<div id="panelLeftColumn">
    <div id="leftColumnUl1">
        <ul>
            <c:forEach var="panely" items="${panelyData}">     
                <li> 
                    <a href="detaily?${panely.webPanelyDataOdkaz}" class="panelButton">
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

<div id="wrapper">   
    <c:choose>
        <c:when test="${selectedCenter == null}">
            <jsp:include page="${selectedCategory.webKategorieZakladniOdkaz}"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="${selectedCenter}"/>
        </c:otherwise>
    </c:choose>
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