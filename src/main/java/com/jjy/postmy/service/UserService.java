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
    public void login(UserReqDto userReqDto) {
        User user = new User();
        user.UserDtoToVo(userReqDto);

        String pinNo = userDao.loginUser(user);
        user.PinNoToNickname(pinNo);
        String nickName = userDao.findNickName(user);

        // 로그인 성공/실패 분기 처리
        if (pinNo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("pinNo", pinNo);
            session.setAttribute("nickName", nickName);
        } else {
            throw new RuntimeException("로그인 실패");
        }
    }


}
