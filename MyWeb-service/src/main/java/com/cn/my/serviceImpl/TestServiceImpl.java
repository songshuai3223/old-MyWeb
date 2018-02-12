package com.cn.my.serviceImpl;

import com.cn.my.service.ITestService;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}