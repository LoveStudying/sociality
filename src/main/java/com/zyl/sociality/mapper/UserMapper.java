package com.zyl.sociality.mapper;

import com.zyl.sociality.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO `user` (`user_name`, `city`, `sex`, `user_img`, `registertime`, `birthday`, `phone`, `sign`) VALUES " +
            "('#{userName}', '#{city}', '#{sex}', '#{userImg}', '#{registertime}', '#{birthday}', '#{phone}', '#{sign}');")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(int id);

    @Select("SELECT * FROM user")
    List<User> findUserList();
}
