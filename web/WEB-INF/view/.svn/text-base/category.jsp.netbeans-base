<%--
    Document   : category
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero


<%--<c:forEach var="category" items="${categories}">

        <c:choose>
            <c:when test="${category.webKategorieZakladniId == pageContext.request.queryString}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.webKategorieZakladniNazev}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="category?${category.webKategorieZakladniId}" class="categoryButton">
                    <span class="categoryText">
                        ${category.webKategorieZakladniNazev}
                    </span>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>--%>




<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/category' scope='session' />



<div id="indexTopColumn">
    <ul>
        <c:forEach var="category" items="${categories}">
            <li class="topListItemCategory${category.webKategorieZakladniId}">
               
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
            </li>
        </c:forEach>  
    </ul>
</div>

<%out.print("<div id=\"container");%>${selectedCategory.webKategorieZakladniId}<%out.print("\">");%>

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

<%out.println("</div>");%>

<%--<div id="categoryRightColumn">
    <p>${selectedCategory.webKategorieZakladniId} </p>
    <p id="categoryTitle">
        <span style="background-color: #f5eabe; padding: 7px;">${selectedCategory.webKategorieZakladniNazev}</span>

    </p>

    <p id="categoryTitle">${selectedCategory.webKategorieZakladniNazev}</p> 

    <table id="productTable">

        <c:forEach var="product" items="${categoryProducts}" varStatus="iter">

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">                
                <td>
                    ${product.akceHlavni.nazev}
                    <br>
                    <span class="smallText">${product.akceHlavni.optimalniPocet}</span>
                </td>
                <td>
                    &euro; ${product.akceHlavni.ucastnickyPoplatek} / unit
                </td>
                <td>
                    <form action="<c:url value='addToCart'/>" method="post">
                        <input type="hidden"
                               name="productId"
                               value="${product.akceHlavni.akceId}">
                        <input type="submit"
                               name="submit"
                               value="add to cart">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>--%>