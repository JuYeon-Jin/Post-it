package com.jjy.postmy.controller;

import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인
    @PostMapping("/login")
    public String login(UserReqDto userReqDto) {
        String result = userService.login(userReqDto);
        return result;
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "/mainpage";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(UserReqDto userReqDto) {
        String result = userService.join(userReqDto);
        return result;
    }

    // 탈퇴
}
