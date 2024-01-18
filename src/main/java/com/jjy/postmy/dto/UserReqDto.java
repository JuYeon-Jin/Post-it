package com.jjy.postmy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReqDto {

    private String pinNo;
    private String id;
    private String password;
    private String nickName;
    private String email;

}
