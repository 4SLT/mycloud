package com.fslt.mycloudserver.modules.example.controller;

import com.fslt.mycloudserver.modules.example.service.CloudUserService;
import com.fslt.mycloudserver.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: helloController
 * @date: 2019/12/6 23:18
 * @author: zongxiong.lin
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/hello")
public class helloController {

    @Resource
    private CloudUserService cloudUserService;


    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/getList")
    public Object getList(Integer id) {
        return Result.getSuccessResult(cloudUserService.getList());
    }


}