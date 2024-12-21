package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("INSERT into user(phoneNumber,password) value (#{phoneNumber},#{password})")
    int saveUser(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    @Select("select id,phoneNumber,password from user where phoneNumber=#{phoneNumber}")
    User selectuser(@Param("phoneNumber") String phoneNumber);



    // 更新用户密码（明文）
    @Update("UPDATE users SET password = #{password} WHERE username = #{username}")
    static User updateUserPassword(@Param("phoneNumber") String phoneNumber, @Param("password") String password) {
        return null;
    }



}
