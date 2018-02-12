package com.cn.my.dao;


import com.cn.my.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int finAllUsersCount(@Param(value = "username") String username);
    
    List<User> finAllUsers(@Param(value = "page") int page, @Param(value = "rows") int rows, @Param(value = "username") String username);

    public User findByUserName(String username);
    
    int isExistUser(User user);
}
