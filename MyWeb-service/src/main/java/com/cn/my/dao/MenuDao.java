package com.cn.my.dao;

import java.util.List;

import com.cn.my.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface MenuDao {
    List<Menu> finAllMenu();
    
    int finAllMenuCount(@Param(value = "name") String ame);
    
    List<Menu> finAllMenuList(@Param(value = "page") int page, @Param(value = "rows") int rows, @Param(value = "name") String name);
    
    int findMenubyName(String name);
    
    int isExistMenu(Menu menu);
    
    List<Menu> finSubMenuList(@Param(value = "parentid") int parentid);
}