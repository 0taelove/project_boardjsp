package org.choongang.main.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("mainPage/mainPage"));
        return "main/index";
    }


}