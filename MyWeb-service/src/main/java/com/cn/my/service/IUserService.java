package com.cn.my.service;

import com.cn.my.bean.User;

import java.util.Map;



public interface IUserService {

	public  Map<String, Object> findAllUser(int page,int rows,User user);


	public void insertUser(User user);
	
	public User findUserbyUsername(String username);
    
    public int isExistUser(User user);
}
