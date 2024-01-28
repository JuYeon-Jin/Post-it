package com.jjy.postmy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostReqDto {

    private String postNo;
    private String pinNo;
    private String title;
    private String content;
    private String dueDate;

    public PostReqDto() {
    }

    public void postNoCon(String strPostNo) {
        this.postNo = strPostNo;
    }
}
