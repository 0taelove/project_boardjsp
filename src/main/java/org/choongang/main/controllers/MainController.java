package org.choongang.main.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

// 컨트롤러 객체로 관리되는 객체 정의
@Controller
@RequestMapping("/") // 기본값은 비어있는 형태
public class MainController {

    // 반환값이 보이는 형태
    @GetMapping
    public String index() {

        return "index";
    }
}
