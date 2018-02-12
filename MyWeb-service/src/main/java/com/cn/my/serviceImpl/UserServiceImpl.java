package com.cn.my.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.my.bean.User;
import com.cn.my.dao.UserDao;
import com.cn.my.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;

	@Override
	public  Map<String, Object> findAllUser(int page,int rows,User user) {
		// TODO Auto-generated method stub
		String username=user.getUsername();
		//查询通讯录总数量
		int total = userDao.finAllUsersCount(username);
		int start=(page-1)*rows;
		if(page*rows>total) {
			rows = total - (page - 1) * rows;
		}
		List<User> userList =userDao.finAllUsers(start,rows,username);
       	Map<String, Object> jsonMap =new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", userList); 
		return jsonMap;
    }  
	
		@Override
		public void insertUser(User user) {
		Logger logger = Logger.getLogger("UserService");
		logger.info("进入插入数据方法");
		logger.debug(user);
		userDao.insert(user);
	}
	@Override
	public User findUserbyUsername(String username){
		return userDao.findByUserName(username);
	}
    @Override
    public int isExistUser(User user){
    	return userDao.isExistUser(user);
    }
}
