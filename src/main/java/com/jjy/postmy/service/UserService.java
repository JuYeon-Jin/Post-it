package com.jjy.postmy.service;

import com.jjy.postmy.dao.UserDao;
import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;
    private HttpServletRequest request;

    // 디폴트 생성자
    public UserService() {
    }

    @Autowired
    public UserService(UserDao userDao, HttpServletRequest request) {
        this.userDao = userDao;
        this.request = request;
    }

    // 로그인
    public String login(UserReqDto userReqDto) {
        User user = new User();
        user.loginToDto(userReqDto);

        String pinNo = userDao.loginUser(user);
        user.PinNoToNickname(pinNo);
        String nickName = userDao.findNickName(user);

        // 로그인 성공/실패 분기 처리
        if (pinNo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("pinNo", pinNo);
            session.setAttribute("nickName", nickName);
            return "/my-posts";
        } else {
            return "/error";
        }
    }

    // 로그아웃
    public void logout() {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    // 회원가입
    public void join(UserReqDto userReqDto) {
        User user = new User();
        userDao.makePin();
        user.joinToDto(userReqDto, userDao.newPinNo());
        userDao.joinUser(user);
        userDao.setNickName(user);
    }

    // 회원가입 예외처리
    public String joinCheck() {
        return "정상";
    }
}
