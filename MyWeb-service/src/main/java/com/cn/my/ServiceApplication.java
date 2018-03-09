package com.cn.my;


import com.cn.my.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/12 0012.
 * @author Administrator
 */
@RestController
@ComponentScan(basePackages = "com.cn.my")
@Component
@SpringBootApplication
@ServletComponentScan
public class ServiceApplication {
    @Autowired
    private CacheUtil cacheUtil;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
        System.out.print("");
    }

    @RequestMapping(value = "/testget",method = RequestMethod.GET)
    public String home1(){
        System.out.println(new Date());
        return "This is a test";
    }

    @RequestMapping(value = "/testpost",method = RequestMethod.POST)
    @ResponseBody
    public String home2(@RequestParam(value = "str") String str){
        System.out.println(str);
        return str.toUpperCase();
    }

    @RequestMapping("/set")
    public String set(String key,String value){
        cacheUtil.put2Cache(key,value);
        return "success";
    }
    @RequestMapping("/get")
    public String get(String key){
        return cacheUtil.getFromCache(key);
    }
}
