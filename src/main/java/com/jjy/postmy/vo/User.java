package com.jjy.postmy.vo;

import com.jjy.postmy.dto.UserReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private String pinNo;
    private String userNo;
    private String id;
    private String password;
    private String nickName;
    private String email;

    // 기본 생성자
    public User() {
    }

    // 로그인
    public void loginToDto(UserReqDto userReqDto) {
        this.id = userReqDto.getId();
        this.password = userReqDto.getPassword();
    }

    // 닉네임 찾기
    public void PinNoToNickname(String pinNo) {
        this.pinNo = pinNo;
    }

    // 회원가입
    public void joinToDto(UserReqDto userReqDto, String newPinNo) {
        this.id = userReqDto.getId();
        this.password = userReqDto.getPassword();
        this.nickName = userReqDto.getNickName();
        this.email = userReqDto.getEmail();
        this.pinNo = newPinNo;
    }

    public void dtoToVo(UserReqDto userReqDto) {
        this.id = userReqDto.getId();
        this.password = userReqDto.getPassword();
        this.userNo = userReqDto.getUserNo();
        this.nickName = userReqDto.getNickName();
        this.email = userReqDto.getEmail();
    }
}
