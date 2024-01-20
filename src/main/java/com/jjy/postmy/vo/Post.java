package com.jjy.postmy.vo;

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
}
