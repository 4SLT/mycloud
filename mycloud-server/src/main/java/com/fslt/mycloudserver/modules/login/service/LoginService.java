package com.fslt.mycloudserver.modules.login.service;

import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import com.fslt.mycloudserver.result.Result;

/**
 * @description: LoginService
 * @date: 2019/12/26 10:36
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface LoginService {

    /**
     * 登陆
     *
     * @param cloudUser
     * @return
     */
    Result login(CloudUser cloudUser);

    /**
     * 注册
     *
     * @param cloudUser
     * @return
     */
    Result register(CloudUser cloudUser);

}
