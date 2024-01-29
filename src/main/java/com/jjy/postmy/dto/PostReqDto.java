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

    // 기본생성자를 넣으면 게시물 생성이 불가함
    /*
    public PostReqDto() {
    }
    */

    public void postNoCon(String strPostNo) {
        this.postNo = strPostNo;
    }
}
