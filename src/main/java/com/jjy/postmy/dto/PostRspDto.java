package com.jjy.postmy.dto;

import com.jjy.postmy.vo.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRspDto {

    private String postNo;
    private String title;
    private String content;
    private String dueDate;
    private String postDate;

    // 기본 생성자
    public PostRspDto() {
    }

    public void VoToDto(Post post) {
        this.postNo = String.valueOf(post.getPostNo());
        this.title = post.getTitle();
        this.content = post.getContent();
        this.dueDate = post.getDueDate();
        this.postDate = post.getPostDate();
    }

}
