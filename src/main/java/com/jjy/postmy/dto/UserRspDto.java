package com.jjy.postmy.dto;

import com.jjy.postmy.vo.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRspDto {

    private String pinNo;
    private String userNo;
    private String id;

    public UserRspDto() {
    }

    public void VoToDto(User user) {
        this.id = user.getId();
    }
}
