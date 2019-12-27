package com.fslt.mycloudserver.modules.login.mapper;

import com.fslt.mycloudserver.modules.user.domain.CloudUser;

/**
 * @description: LoginMapper
 * @date: 2019/12/26 9:59
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface LoginMapper {

    /**
     * 登陆
     *
     * @param cloudUser
     * @return
     */
    String login(CloudUser cloudUser);

    /**
     * 判断当前用户是否已注册
     *
     * @param cloudUser
     * @return
     */
    Integer getRegisterFlag(CloudUser cloudUser);

    /**
     * 注册
     *
     * @param cloudUser
     * @return
     */
    Integer register(CloudUser cloudUser);

}
