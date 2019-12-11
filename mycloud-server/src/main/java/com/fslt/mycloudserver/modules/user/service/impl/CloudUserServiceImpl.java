package com.fslt.mycloudserver.modules.user.service.impl;

import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import com.fslt.mycloudserver.modules.user.mapper.CloudUserMapper;
import com.fslt.mycloudserver.modules.user.service.CloudUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: CloudUserServiceImpl
 * @date: 2019/12/11 16:10
 * @author: zongxiong.lin
 * @version: 1.0
 */
public class CloudUserServiceImpl implements CloudUserService {

    @Resource
    private CloudUserMapper cloudUserMapper;

    @Override
    public List<CloudUser> getList() {
        return cloudUserMapper.getList();
    }

}
