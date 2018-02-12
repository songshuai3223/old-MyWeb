package com.cn.my.service;

import java.util.Map;

import com.cn.my.bean.Menu;
import org.springframework.web.bind.annotation.RequestParam;


import net.sf.json.JSONArray;

/**
 * @author songshuai
 */
public interface IMenuService{
	public JSONArray findAllMenu();
	public  Map<String, Object> getMenu(Map<?, ?> map);
	public  Map<String, Object> findAllMenuList(@RequestParam("page") int page,
												@RequestParam("rows") int rows, Menu menu);
	
	public void insertMenu(Menu menu);
	
	public int findMenubyname(String name);
    
    public int isExistMenu(Menu menu);
    
    public Map<String, Object> findSubMenuList(int parentid);
    public String loadMenuTree();
}
