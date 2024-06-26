package org.choongang.global.exceptions;

// 알림을 띄우고 특정 페이지로 이동
public class AlertRedirectException extends AlertException {

    private String redirectUrl;
    private String target;

    public AlertRedirectException(String message, String redirectUrl, int status, String target) {
        super(message, status);
        this.redirectUrl = redirectUrl;
        this.target = target;
    }

    public AlertRedirectException(String message, String redirectUrl, int status) {
        this(message, redirectUrl, status, "self");
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getTarget() {
        return target;
    }
}
