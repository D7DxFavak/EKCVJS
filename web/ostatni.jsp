<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:set var='view' value='/category' scope='session' />



<div id="indexTopColumn">
    <ul>
        <li class="topListItemCategory10">
            <a href="index.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='home'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyHomeData}">                    
                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>                    
                </c:forEach>
            </ul>
        </li>
        <li class="topListItemCategory20">
            <a href="ucitele.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='ucitele'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyUciteleData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>                
                </c:forEach>
            </ul>
        </li>
        <li class="topListItemCategory30">
            <a href="js.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='js'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyJsData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>

                </c:forEach>
            </ul>
        </li>
        <li class="topListItemCategory40">
            <a href="dvpp.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='dvpp'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyDvppData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>

                </c:forEach>
            </ul>
        </li>
        <%--<li class="topListItemCategory50">
            <a href="projekty.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText">PROJEKTY</span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyProjektyData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>

                </c:forEach>
            </ul>
        </li>--%>
        <li class="topListItemCategory60">
            <a href="ostatni.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='ostatni'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyOstatniData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>

                </c:forEach>
            </ul>
        </li>
        <li class="topListItemCategory70">
            <a href="ekcvjs.jsp">
                <span class="categoryLabel"></span>
                <span class="categoryLabelText"><fmt:message key='ekcvjs'/></span>                   
            </a>
            <ul>
                <c:forEach var="odkazDetail" items ="${panelyEkcvjsData}">

                    <li>
                        <a href="detaily?${odkazDetail.webPanelyOdkaz}">
                            <span class="catDetailLabel"></span>
                            <span class="catDetailLabelText">${odkazDetail.webPanelyNazev}</span>                                
                        </a>
                    </li>

                </c:forEach>
            </ul>
        </li>
    </ul>  
</div>

<div id="container60">

    <div id="panelLeftColumn">
        <div id="leftColumnUl1">
            <ul>
                <c:forEach var="panely" items="${panelyOstatniData}">     
                    <li> 
                        <a href="detaily?${panely.webPanelyOdkaz}" class="panelButton">
                            <span class="panelText">
                                ${panely.webPanelyNazev}
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
                <jsp:include page="WEB-INF/view/zakladniInfoOstatni.jsp"/>
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
                    </div>
    </div>
</div>