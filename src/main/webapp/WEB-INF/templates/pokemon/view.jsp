<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>

<layout:main title="${data.nameKr}(${data.name})">
    <section class="pokemon-view">
        <div class="pokemon-container">
            <div class="pokemon-image">
                <img src="${data.frontImage}" alt="프론트">
            </div>
            <div class="pokemon-details">
                <div class="pd-seq">
                    No.000${data.seq}
                </div>
                <div class="pd-name">
                    ${data.nameKr}
                </div>
                <div class="p-desc">
                    ${fn:replace(data.description, '\\n', '<br>')}
                </div>
                <div class="pd-types">
                    타입 : ${data.types1} ${data.types2}
                </div>
                <div class="p-hei">
                    키 : ${String.format("%.1f", data.height * 0.1)}m
                </div>
                <div class="p-wei">
                    몸무게 : ${String.format("%.1f", data.weight * 0.1)}kg
                </div>
            </div>
        </div>
        <br><br>
    </section>
</layout:main>
