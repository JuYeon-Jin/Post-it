package com.jjy.postmy.dao;

import com.jjy.postmy.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    // 중복 아이디 확인
    @Select("SELECT count(*) FROM Users where id = #{id}")
    public int countId(@Param("id") String a);

    // 이메일로 아이디 찾기
    @Select("SELECT id FROM Users where email = #{email}")
    public List<User> findId(@Param("email") String a);

    // 아이디와 이메일로 userNo 가져오기
    @Select("SELECT userNo FROM Users where id = #{user.id} and email = #{user.email}")
    public String findUserNo(@Param("user") User a);

    // userNo 로 비밀번호 업데이트
    @Update("UPDATE USERS SET password = #{user.password} WHERE userNo = #{user.userNo};")
    public void updatePw(@Param("user") User a);

}
