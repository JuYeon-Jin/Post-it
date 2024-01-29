package com.jjy.postmy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jjy.postmy.dto.PostReqDto;
import com.jjy.postmy.dto.PostRspDto;
import com.jjy.postmy.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 로그인 후 포스트 페이지 이동
    @GetMapping("/my-posts")
    public ModelAndView myPost(ModelAndView mav) {
        mav.setViewName("/post/my-posts");
        mav.addObject("posts",postService.allPosts());

        return mav;
    }

    // 글 작성하기
    @PostMapping("/insertPost")
    public String insertPost(PostReqDto postReqDto) {
        postService.insertPost(postReqDto);
        return "redirect:/my-posts";
    }

    // 게시글 조회 페이지 이동
    @GetMapping("/openPost")
    public ModelAndView openPost(@RequestParam("postNo") String postNo, ModelAndView mav) {
        mav.setViewName("/post/popupopenpost");
        mav.addObject("post", postService.openPost(postNo));

        return mav;
    }

    // 게시글 수정 페이지 이동
    @GetMapping("/updatePostForm")
    public ModelAndView updatePostForm(@RequestParam("postNo") String postNo, ModelAndView mav) {
        mav.setViewName("/post/popupupdatepost");
        mav.addObject("post", postService.openPost(postNo));

        return mav;
    }

    // 게시글 수정
    @PostMapping("/updatePost")
    public String updatePost(PostReqDto postReqDto) {
        postService.updatePost(postReqDto);
        return "redirect:/my-posts";
    }

    // 게시글 삭제
    @GetMapping("/deletePost")
    public String deletePost(@RequestParam("postNo") String postNo) {
        postService.deletePost(postNo);
        return "redirect:/my-posts";
    }
}
