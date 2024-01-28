package com.jjy.postmy.vo;

import com.jjy.postmy.dto.PostReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Post {

    private int postNo;
    private String pinNo;
    private String title;
    private String content;
    private String dueDate;
    private String postDate;

    // 기본 생성자
    public Post() {
    }

    public void dtoToPost(PostReqDto postReqDto, String sessionPinNo) {
        this.pinNo = sessionPinNo;
        this.title = postReqDto.getTitle();
        this.content = postReqDto.getContent();
        this.dueDate = postReqDto.getDueDate();
    }

    public void postNoStrToInt(String postNo, String pinNo) {
        this.postNo = Integer.parseInt(postNo);
        this.pinNo = pinNo;
    }
}
