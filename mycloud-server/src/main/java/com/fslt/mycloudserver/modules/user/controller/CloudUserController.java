package com.fslt.mycloudserver.modules.user.controller;

import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import com.fslt.mycloudserver.modules.user.service.CloudUserService;
import com.fslt.mycloudserver.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: CloudUserController
 * @date: 2019/12/11 16:13
 * @author: zongxiong.lin
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "/user")
public class CloudUserController {

    @Resource
    private CloudUserService cloudUserService;


    @RequestMapping(value = "/getList")
    public Object getList(CloudUser cloudUser) {
        return Result.getSuccessResult(cloudUserService.getList());
    }


}
