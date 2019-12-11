package com.fslt.mycloudserver.modules.user.mapper;


import com.fslt.mycloudserver.modules.user.domain.CloudUser;

import java.util.List;

/**
 * @description: CloudUserMapper
 * @date: 2019/12/11 16:09
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface CloudUserMapper {

    /**
     * 获取用户信息列表
     *
     * @return: List<CloudUser>
     * @param: null
     */
    List<CloudUser> getList();

}
