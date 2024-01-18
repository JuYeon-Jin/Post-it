package com.jjy.postmy.dao;

import com.jjy.postmy.vo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    // 로그인 (id, password 입력 → pinNo)
    @Select("SELECT pinNo FROM Users WHERE id = #{user.id} AND password = #{user.password}")
    public String loginUser(@Param("user") User a);

    // pinNo로 닉네임 가져오기
    @Select("SELECT nickName FROM UserPin WHERE pinNo = #{user.pinNo}")
    public String findNickName(@Param("user") User a);
}
