package com.fslt.mycloudserver.modules.login.controller;

import com.fslt.mycloudserver.modules.login.service.LoginService;
import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import com.fslt.mycloudserver.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: LoginController
 * @date: 2019/12/26 11:02
 * @author: zongxiong.lin
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/register")
    public Result register(CloudUser cloudUser) {
        return loginService.register(cloudUser);
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Result login(CloudUser cloudUser) {
        return loginService.login(cloudUser);
    }

}
