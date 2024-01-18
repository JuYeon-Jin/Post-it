package com.jjy.postmy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class IndexController {

    // 메인페이지 이동
    @GetMapping("/post-main")
    public String mainPage() {
        return "post-main";
    }

    // 회원가입 페이지 이동
    @GetMapping("/post-join")
    public String joinPage() { return "post-join"; }

    // 아이디 찾기 페이지 이동
    // 비밀번호 찾기 페이지 이동


}
