<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="${data.nameKr}(${data.name})">
    <section class="pokemon-view">
        <img src="${data.frontImage}" alt="프론트">
        <img src="${data.backImage}" alt="백">

        <div class="p-name">
            ${data.nameKr}(${data.name})
        </div>
        <div class="p-desc">
            ${fn:replace(data.description, '\\n', '<br>')}
        </div>
        <div class="p-hei">
            키 : ${String.format("%.1f", data.height * 0.1)}m
        </div>
        <div class="p-wei">
            몸무게 : ${String.format("%.1f", data.weight * 0.1)}kg
        </div>
    </section>

</layout:main>