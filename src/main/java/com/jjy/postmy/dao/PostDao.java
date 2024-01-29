package com.jjy.postmy.dao;

import com.jjy.postmy.vo.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PostDao {

    // pinNo 로 작성한 게시물 조회
    @Select("SELECT postNo, title, content, dueDate, postDate FROM POST WHERE pinNo = #{pinNo} ORDER BY dueDate")
    public List<Post> allPosts(@Param("pinNo") String a);

    // 게시물 작성
    @Insert("INSERT INTO POST (pinNo, title, content, dueDate)" +
            " VALUES (#{post.pinNo}, #{post.title}, #{post.content}, #{post.dueDate})")
    public void insertPost(@Param("post") Post a);

    // 게시물 조회
    @Select("SELECT postNo, title, content, dueDate FROM POST WHERE pinNo = #{post.pinNo} AND postNo = #{post.postNo}")
    public Post onePost(@Param("post") Post a);

    // 게시물 수정
    @Update("UPDATE POST SET title = #{post.title}, content = #{post.content}, dueDate = #{post.dueDate} WHERE postNo = #{post.postNo} AND pinNo = #{post.pinNo}")
    public void updatePost(@Param("post") Post a);

    // 게시물 삭제
    @Delete("DELETE FROM POST WHERE postNo = #{post.postNo} AND pinNo = #{post.pinNo}")
    public void deletePost(@Param("post") Post a);

}
