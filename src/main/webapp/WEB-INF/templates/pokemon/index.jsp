<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="searchUrl" value="/pokemon" />

<layout:main>
<section class="layout-width">
    <form id="frmSearch" name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
        <div class="inner">
            <div class='tit'>포켓몬 도감</div>
            <input type="text" name="skey" value="${param.skey}" placeholder="포켓몬 이름을 입력해주세요.">
            <button type="submit">검색</button>
        </div>
    </form>
    <ul class="pokemon-list">
        <c:if test="${items == null || items.isEmpty()}">
            <li class='no-data'>검색결과가 없습니다.
            <br>
            다른 키워드로 검색해주세요.</li>
        </c:if>
        <c:if test="${items != null && !items.isEmpty()}">
            <c:forEach var="item" items="${items}">
                <li>
                    <a href="<c:url value='/pokemon/${item.seq}' />" class="shiney-button">
                        <img src="${item.frontImage}" alt="${item.nameKr}">
                        <div class="p-seq">
                            No.000${item.seq}
                        </div>
                        <div class="p-name">
                            ${item.nameKr}
                        </div>
                        <div class="p-types">
                            <span class="type-${item.types1.toLowerCase()}">${item.types1}</span>
                            <c:if test="${not empty item.types2}">
                                <span class="type-${item.types2.toLowerCase()}">${item.types2}</span>
                            </c:if>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</section>
<util:pagination />
</layout:main>
