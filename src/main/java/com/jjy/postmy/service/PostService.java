package com.jjy.postmy.service;

import com.jjy.postmy.dao.PostDao;
import com.jjy.postmy.dto.PostReqDto;
import com.jjy.postmy.dto.PostRspDto;
import com.jjy.postmy.vo.Post;
import com.jjy.postmy.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private PostDao postDao;
    private HttpServletRequest request;

    @Autowired
    public PostService(PostDao postDao, HttpServletRequest request) {
        this.postDao = postDao;
        this.request = request;
    }

    // 작성 포스트 조회
    public List<PostRspDto> allPosts() {
        // 세션에서 pinNo 가져오기
        HttpSession session = request.getSession();
        String pinNo = (String)session.getAttribute("pinNo");

        // dao 에서 VO 타입으로 List 반환. VO 타입을 DTO 타입으로 변환. ArrayList 에 add.
        List<PostRspDto> posts = new ArrayList<PostRspDto>();
        List<Post> postList = postDao.allPosts(pinNo);
        for (Post post: postList) {
            PostRspDto postRspDto = new PostRspDto();
            postRspDto.VoToDto(post);
            posts.add(postRspDto);
        }
        return posts;
    }

    public void insertPost(PostReqDto postReqDto) {
        HttpSession session = request.getSession();
        String pinNo = (String)session.getAttribute("pinNo");

        Post post = new Post();
        post.dtoToPost(postReqDto, pinNo);

        postDao.insertPost(post);
    }

}
