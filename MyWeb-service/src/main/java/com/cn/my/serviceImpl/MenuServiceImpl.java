package com.cn.my.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cn.my.bean.Menu;
import com.cn.my.dao.MenuDao;
import com.cn.my.service.IMenuService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public JSONArray findAllMenu(){
//		List<Menu> list=menuDao.finAllMenu();
//		for (Menu menu : list) {
//			System.out.println(menu.toString());
//		}
		
		List<Menu> menuList =menuDao.finAllMenu();
		JSONArray obj =JSONArray.fromObject(menuList);
		return obj; 
	}

	@Override
	public  Map<String, Object> findAllMenuList(int page,int rows,Menu menu) {
		// TODO Auto-generated method stub
		String name=menu.getName();
		//查询通讯录总数量
		int total = menuDao.finAllMenuCount(name);
		int start=(page-1)*rows;
		if(page*rows>total) {
			rows = total - (page - 1) * rows;
		}
		List<Menu> userList =menuDao.finAllMenuList(page-1, rows, name);
       	Map<String, Object> jsonMap =new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", userList); 
		return jsonMap;
    }
	
	@Override
	public Map<String, Object> findSubMenuList(int parentid) {
		// TODO Auto-generated method stub
		List<Menu> userList =menuDao.finSubMenuList(parentid);
       	Map<String, Object> jsonMap =new HashMap<String, Object>();
		jsonMap.put("total", null);
		jsonMap.put("rows", userList); 
		return jsonMap;
	} 

	@Override
	public Map<String, Object> getMenu(Map<?, ?> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findMenubyname(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isExistMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("null")
	@Override
	public String loadMenuTree() {
		// TODO Auto-generated method stub
		//加载目录树
		JSONArray jsonResult=null;
		List<Menu> list=menuDao.finAllMenu();
		for (Menu menu : list) {
			System.out.println(menu.getName());
//			JSONObject jsonObject=new JSONObject();
//			jsonObject.element("id", menu.getId());
//			jsonObject.element("text", menu.getName());
//			if(menu.getParentid()==0){
//				JSONArray parentJson=null;
////				for (Menu subMenu : list) {
////					if(subMenu.getParentid()==menu.getId()){
////						//此菜单是上层菜单的子菜单
////						JSONObject sub=new JSONObject();
////						sub.element("id", subMenu.getId());
////						sub.element("text", subMenu.getName());
////						parentJson.add(sub);
////					}
////				}
////				if (null!=parentJson) {
////				jsonObject.element("children", parentJson);
////				}
//			}
//			
//			jsonResult.add(jsonObject);
		}
		System.out.println(jsonResult);
		return null;
	}

	
}
