package com.jjy.postmy.vo;

import com.jjy.postmy.dto.UserReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private String pinNo;
    private String id;
    private String password;
    private String nickName;
    private String email;

    // 기본 생성자
    public User() {
    }

    // 닉네임 찾기
    public void PinNoToNickname(String pinNo) {
        this.pinNo = pinNo;
    }

    // 로그인
    public void UserDtoToVo(UserReqDto userReqDto) {
        this.id = userReqDto.getId();
        this.password = userReqDto.getPassword();
    }
}
