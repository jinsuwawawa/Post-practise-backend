package com.example.demo128.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends CrudRepository<User, Integer> {

    @Insert("INSERT INTO tab(phoneNumber, password) VALUES (#{phoneNumber}, #{password})")
    int saveUser(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

    @Select("SELECT id, phoneNumber, password, avatar, name FROM tab WHERE phoneNumber = #{phoneNumber}")
    User selectuser(@Param("phoneNumber") String phoneNumber);

    @Update("UPDATE tab SET avatar = #{avatar} WHERE phoneNumber = #{phoneNumber}")
    int updateAvatar(@Param("avatar") String avatar, @Param("phoneNumber") String phoneNumber);

    @Select("SELECT avatar FROM tab WHERE id = #{id}")
    String findAvatarById(@Param("id") int id);
}
