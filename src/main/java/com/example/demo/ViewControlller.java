package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Vector;

@Controller
public class ViewControlller  {

    @GetMapping("index")
    public String index() {
       return  "index2";
    }

    @ResponseBody
    @PostMapping("postindex")
    @ApiOperation("获取全部数据方法")
    public String postindex( @ApiParam(value = "返回一个对象") Map map, @ApiParam("用户id")  String id) {
      //  System.out.println(map);

        return  "访问成功了";

    }

    public static void main(String[] args){
        ViewControlller vi =new ViewControlller();
    }
}
