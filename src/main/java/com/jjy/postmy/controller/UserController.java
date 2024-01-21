package com.jjy.postmy.controller;

import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "redirect:" + result;
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/mainpage";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(UserReqDto userReqDto) {
        String result = userService.join(userReqDto);
        return result;
    }

    // 아이디 찾기
    @PostMapping("/findid")
    public String findid(UserReqDto userReqDto) {
        String result = "#";
        return result;
    }

    // 비밀번호 찾기
    @PostMapping("/findpw")
    public String findpw(UserReqDto userReqDto) {
        String result = "#";
        return result;
    }

    // 탈퇴
}
