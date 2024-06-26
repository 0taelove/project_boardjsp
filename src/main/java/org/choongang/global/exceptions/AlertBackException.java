package org.choongang.global.exceptions;

// 알림을 띄우고 이전 페이지로 이동
public class AlertBackException extends AlertException {
    private String target;

    public AlertBackException(String message, int status, String target) {
        super(message, status);
        this.target = target;
    }

    public AlertBackException(String message, int status) {
        this(message, status, "self");

    }
    public String getTarget() {
        return target;
    }
}
