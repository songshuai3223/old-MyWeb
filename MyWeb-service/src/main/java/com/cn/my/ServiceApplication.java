package com.cn.my;


import com.cn.my.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
