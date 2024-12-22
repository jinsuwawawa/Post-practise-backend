package com.example.demo128.mapper;

import com.example.demo128.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper extends CrudRepository<User, Integer> {

    // 插入用户
    @Insert("INSERT INTO users (phoneNumber, password) VALUES (#{phoneNumber}, #{password})")
    int saveUser(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    // 查询用户
    @Select("SELECT * FROM users WHERE phoneNumber = #{phoneNumber}")
    User selectuser(@Param("phoneNumber") String phoneNumber);

    // 更新用户头像路径
    @Update("UPDATE users SET avatar = #{avatar} WHERE phoneNumber = #{phoneNumber}")
    int updateAvatar(@Param("phoneNumber") String phoneNumber, @Param("avatar") String avatar);

    // 根据用户 ID 查询用户

    @Select("SELECT * FROM users WHERE user_id = #{id}")
    Optional<User> findById(@Param("id") int id);
}
