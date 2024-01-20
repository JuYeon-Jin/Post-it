package com.jjy.postmy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // 메인페이지 이동
    @GetMapping("/mainpage")
    public String mainPage() {
        return "mainpage";
    }

    // 회원가입 페이지 이동
    @GetMapping("/join-form")
    public String joinPage() { return "join-form"; }

    // 아이디 찾기 페이지 이동
    @GetMapping("/find-id")
    public String findIdPage() { return "findid"; }

    // 비밀번호 찾기 페이지 이동
    @GetMapping("/find-pw")
    public String findPwPage() { return "findpw"; }

    // 테스트 페이지 이동
    @GetMapping("/test")
    public String findTestPage() { return "test"; }
}
