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
    public String joinPage() { return "/user/join-form"; }

    // 회원가입 완료 페이지
    @GetMapping("/welcomenew")
    public String completeJoin() { return "/user/completeJoin"; }

    // 아이디 찾기 페이지 이동
    @GetMapping("/findid-form")
    public String findIdPage() { return "/user/findid-form"; }

    // 비밀번호 찾기 페이지 이동
    @GetMapping("/findpw-form")
    public String findPwPage() { return "/user/findpw-form"; }

    // 테스트 페이지 이동
    @GetMapping("/test")
    public String findTestPage() { return "test"; }

    // 게시글 작성 페이지 이동
    @GetMapping("/popupThyme")
    public String popupPage() { return "/post/popup"; }
}
