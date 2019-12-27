package com.fslt.mycloudserver.modules.login.service.impl;

import com.fslt.mycloudserver.modules.login.mapper.LoginMapper;
import com.fslt.mycloudserver.modules.login.service.LoginService;
import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import com.fslt.mycloudserver.result.Result;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: LoginServiceImpl
 * @date: 2019/12/26 10:37
 * @author: zongxiong.lin
 * @version: 1.0
 */

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private LoginMapper loginMapper;

    /**
     * 登陆功能
     *
     * @param cloudUser
     * @return
     */
    @Override
    public Result login(CloudUser cloudUser) {
        Integer registerFlag = loginMapper.getRegisterFlag(cloudUser);
        if (!new Integer(1).equals(registerFlag)) {
            return Result.getServiceError("此账号还未注册", "-1");
        }
        String password = loginMapper.login(cloudUser);
        if (password.equals(cloudUser.getUserPassword())) {
            return Result.getSuccessResult("登陆成功");
        } else {
            return Result.getServiceError("密码错误", "-1");
        }
    }

    /**
     * 注册
     *
     * @param cloudUser
     * @return
     */
    @Override
    public Result register(CloudUser cloudUser) {
        logger.info("用户：{}正在注册，入参：{}", cloudUser.getUserName(), cloudUser.toString());
        Integer registerFlag = loginMapper.getRegisterFlag(cloudUser);
        if (new Integer(1).equals(registerFlag)) {
            return Result.getServiceError("此账号已被注册", "-1");
        }
        try {
            loginMapper.register(cloudUser);
            return Result.getSuccessResult("注册成功");
        } catch (Exception e) {
            logger.info("用户：{}注册失败，入参：{}", cloudUser.getUserName(), cloudUser.toString());
            return Result.getServiceError("注册失败", "-1");
        }
    }


}
