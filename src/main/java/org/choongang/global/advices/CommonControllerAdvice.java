package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.exceptions.*;

@ControllerAdvice("org.choongang")
public class CommonControllerAdvice {

    @ModelAttribute("commonValue2")
    public String commonValue() {
        return "공통 값 속성 추가 테스트";
    }

    /**
     * 공통 에러 페이지 처리
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {

        e.printStackTrace();

        // 정의한 예외
        if (e instanceof CommonException commonException) {

            // 응답 코드
            int status = commonException.getStatus();
            response.setStatus(status);

            StringBuffer sb = new StringBuffer(1000);
            // 자바 스크립트 형태로 얼러트 띄워줌
            if (e instanceof AlertException alertException) {
                sb.append(String.format("alert('');", e.getMessage()));
            }

            if (e instanceof AlertBackException alertBackException) {
                String target = alertBackException.getTarget();
                sb.append(String.format("%s.history.back();", target));
            }

            if (e instanceof AlertRedirectException alertRedirectException) {
                // 타겟과 주소까지도 변경 가능
                String target = alertRedirectException.getTarget();
                String url = alertRedirectException.getRedirectUrl();

                sb.append(String.format("%s.location.replace('%s');", target, url));
            }

            // 스크립트를 실행할 수 있는 전용 html 태그
            if (!sb.isEmpty()) {
                request.setAttribute("script", sb.toString());
                return "commons/execute_script";
            }
        } else {
            // CommonException으로 정의한 예외가 아닌 경우 - 응답 코드 500
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        return "errors/error";
    }
}