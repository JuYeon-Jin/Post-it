package com.jjy.postmy.controller;

import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    // 회원가입 입력 검증
    @PostMapping("/beforeJoin")
    @ResponseBody
    public String beforeJoinCheck(@RequestBody UserReqDto userReqDto) {
        // 각 검증에 맞는 문장을 반환
        return userService.beforeCheck(userReqDto);
    }

    // 회원가입 전 최종 검증
    @PostMapping("/joinCheck")
    @ResponseBody
    public boolean joinCheck(@RequestBody UserReqDto userReqDto) {
        // 문제없으면 true 문제있으면 false
        return userService.joinCheck(userReqDto);
    }

    // 회원가입
    @PostMapping("/join")
    public String join(UserReqDto userReqDto) {
        userService.join(userReqDto);
        return "redirect:/welcomenew";
    }

    // 아이디 찾기
    @PostMapping("/findid")
    public ModelAndView findId(ModelAndView mav, UserReqDto userReqDto) {
        mav.setViewName("/user/found-id");
        mav.addObject("users", userService.findId(userReqDto));

        return mav;
    }

    // 비밀번호 찾기 1 (회원번호 찾아오기)
    @PostMapping("/findpw")
    public ModelAndView findPw(ModelAndView mav, UserReqDto userReqDto) {
        mav.setViewName("/user/updatepw-form");
        mav.addObject("userNo", userService.findUserNo(userReqDto));

        return mav;
    }

    // 비밀번호 찾기 2 (비밀번호 검증하기)
    @PostMapping("/pwCheck")
    @ResponseBody
    public boolean updatePwCheck(@RequestBody UserReqDto userReqDto) {
        // 문제없으면 true 문제있으면 false
        return userService.updateCheck_pw(userReqDto);
    }

    // 비밀번호 찾기 3 (비밀번호 변경하기)
    @PostMapping("/updatepw")
    public String updatePw(UserReqDto userReqDto) {
        System.out.println("userReqDto = " + userReqDto.getUserNo());
        System.out.println("userReqDto = " + userReqDto.getPassword());
        userService.updatePw(userReqDto);
        return "/user/updated-pw";
    }

    // 탈퇴
}
