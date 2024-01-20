package com.jjy.postmy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostReqDto {

    private String pinNo;
    private String title;
    private String content;
    private String dueDate;

}
