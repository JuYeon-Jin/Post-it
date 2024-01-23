package com.jjy.postmy.service;

import com.jjy.postmy.dao.UserDao;
import com.jjy.postmy.dto.UserReqDto;
import com.jjy.postmy.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Objects;

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
    public boolean joinCheck(UserReqDto userReqDto) {
        boolean result = false;

        if (beforeCheck_id(userReqDto).equals("사용가능한 아이디입니다.")
            && beforeCheck_pw(userReqDto).equals("사용가능한 비밀번호입니다.")
            && beforeCheck_nickName(userReqDto).equals("사용가능한 닉네임입니다.")
            && beforeCheck_email(userReqDto)) {
            result = true;
        }

        return result;
    }

    // 아이디: 회원가입 예외처리
    public String beforeCheck_id(UserReqDto userReqDto) {
        String result = "사용가능한 아이디입니다.";
        String userId = userReqDto.getId();

        if (emptyCheck(userId)) {
            // 빈칸 불가
            result = "아이디를 입력해주세요.";
        } else if(!enCheck(userId) || lengthCheck(userId) < 4 || lengthCheck(userId) > 12) {
            // 문자 길이, 문자 종류(영문 소문자, 숫자) 체크
            result = "아이디: 4~12자의 영문 소문자, 숫자";
        } else if (idDuplicated(userId)) {
            // 중복 아이디
            result = "이미 사용중인 아이디입니다.";
        }

        return result;
    }

    // 비밀번호: 회원가입 예외처리
    public String beforeCheck_pw(UserReqDto userReqDto) {
        String result = "사용가능한 비밀번호입니다.";
        String userPw = userReqDto.getPassword();

        if (emptyCheck(userPw)) {
            // 빈칸 불가
            result = "비밀번호를 입력해주세요.";
        } else if(!enCheck(userPw) || lengthCheck(userPw) < 4 || lengthCheck(userPw) > 12) {
            // 문자 길이, 문자 종류(영문 소문자, 숫자) 체크
            result = "비밀번호: 4~12자의 영문 소문자, 숫자";
        }

        return result;
    }

    // 닉네임: 회원가입 예외처리
    public String beforeCheck_nickName(UserReqDto userReqDto) {
        String result = "사용가능한 닉네임입니다.";
        String userNn = userReqDto.getNickName();

        if (emptyCheck(userNn)) {
            // 빈칸 불가
            result = "닉네임을 입력해주세요.";
        } else if(!krCheck(userNn) || lengthCheck(userNn) < 2 || lengthCheck(userNn) > 8) {
            // 문자 길이, 문자 종류(영문 소문자, 숫자) 체크
            result = "닉네임: 2~8자의 영문자, 한글, 숫자";
        }

        return result;
    }

    // 공백 체크
    public boolean emptyCheck(String str) { return Objects.equals(str.trim(), ""); }

    // 단순 길이 계산
    public int lengthCheck(String str) { return str.toCharArray().length; }

    // 영소문자, 숫자 체크 (부합하면 true)
    public boolean enCheck(String str) {
        String regex = "^[a-z0-9]+$";
        // 대문자 포함: String regex = "^[a-zA-Z0-9]+$";
        // 한글 포함: String regex = ".*[가-힣]+.*";
        return str.matches(regex);
    }

    // 영어, 숫자, 한국어 체크 (부합하면 true)
    public boolean krCheck(String str) {
        String regex = "^[a-zA-Z0-9가-힣]+$";
        return str.matches(regex);
    }

    // 아이디 중복 체크
    public boolean idDuplicated(String id) {
        return userDao.countId(id) > 0;
    }

    // 이메일 형식 체크
    public boolean beforeCheck_email(UserReqDto userReqDto) {
        boolean result = true;
        String userEmail = userReqDto.getEmail();
        String regex =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!emptyCheck(userEmail)) {
            if (!userEmail.matches(regex)) {
                result = false;
            }
        }
        return result;
    }
}