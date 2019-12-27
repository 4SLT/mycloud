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
     * 根据用户名获取密码
     *
     * @param cloudUser
     * @return
     */
    String getPasswordByUserName(CloudUser cloudUser);

    /**
     * 查询手机号是否存在
     *
     * @param cloudUser
     * @return
     */
    Integer queryPhone(CloudUser cloudUser);

    /**
     * 查询邮箱是否存在
     *
     * @param cloudUser
     * @return
     */
    Integer queryEmail(CloudUser cloudUser);

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
