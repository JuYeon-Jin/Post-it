package com.jjy.postmy.controller;

import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인
    @PostMapping("/login")
    public String login(UserReqDto userReqDto) {
        userService.login(userReqDto);
        return "redirect:/my/my-posts";
    }

    // 로그아웃
    // 탈퇴
}
