package com.jjy.postmy.dao;

import com.jjy.postmy.vo.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostDao {

    // pinNo 로 작성한 게시물 조회
    @Select("SELECT postNo, title, content, dueDate, postDate FROM POST WHERE pinNo = #{pinNo} ORDER BY dueDate")
    public List<Post> allPosts(@Param("pinNo") String a);

    // 게시물 작성
    @Insert("INSERT INTO POST (pinNo, title, content, dueDate)" +
            " VALUES (#{post.pinNo}, #{post.title}, #{post.content}, #{post.dueDate})")
    public void insertPost(@Param("post") Post a);

    // 게시물 수정

    // 게시물 삭제


}
