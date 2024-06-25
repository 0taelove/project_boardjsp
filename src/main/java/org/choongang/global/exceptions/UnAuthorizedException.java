package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class UnAuthorizedException extends CommonException {
    // 기본 생성자
    public UnAuthorizedException() {
        super("접근 권한이 없습니다.", HttpServletResponse.SC_UNAUTHORIZED); // 401
    }
}
