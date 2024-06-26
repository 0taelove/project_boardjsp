package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
    private boolean saveEmail;
    private String redirectUrl; // 원래 하던 페이지로 이동하기 위한 객체
}
