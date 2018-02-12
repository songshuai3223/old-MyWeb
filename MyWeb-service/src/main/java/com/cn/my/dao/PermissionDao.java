package com.cn.my.dao;

import com.cn.my.bean.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by gcb on 2018/2/2.
 */
@Mapper
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
