package com.fslt.mycloudserver.modules.user.service;


import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: CloudUserService
 * @date: 2019/12/11 16:10
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface CloudUserService {

    /**
     * 获取用户信息列表
     *
     * @return: List<CloudUser>
     * @param: null
     */
    List<CloudUser> getList();

}
