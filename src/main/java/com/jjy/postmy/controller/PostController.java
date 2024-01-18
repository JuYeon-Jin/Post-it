package com.jjy.postmy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class PostController {

    // 포스트 페이지 이동
    @GetMapping("/my-posts")
    public String mainPage() {
        return "my-posts";
    }

}
