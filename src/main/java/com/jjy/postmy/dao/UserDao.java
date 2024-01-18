package com.jjy.postmy.dao;

import com.jjy.postmy.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    // 로그인 (id, password 입력 → pinNo)
    @Select("SELECT pinNo FROM Users WHERE id = #{user.id} AND password = #{user.password}")
    public String loginUser(@Param("user") User a);

    // pinNo로 닉네임 가져오기
    @Select("SELECT nickName FROM UserPin WHERE pinNo = #{user.pinNo}")
    public String findNickName(@Param("user") User a);

    // 회원가입
    @Insert("INSERT INTO UserPin (pinNo, nickName) VALUES (UUID(), '-')")
    public void makePin();
    @Select("SELECT pinNo FROM UserPin WHERE nickName = '-' ORDER BY RAND() LIMIT 1")
    public String newPinNo();
    @Insert("INSERT INTO Users (userNo, pinNo, id, password, email) VALUES (uuid(), #{user.pinNo}, #{user.id}, #{user.password}, #{user.email})")
    public void joinUser(@Param("user") User a);
    @Update("UPDATE UserPin SET nickName = #{user.nickName} WHERE pinNo = #{user.pinNo}")
    public void setNickName(@Param("user") User a);

}
