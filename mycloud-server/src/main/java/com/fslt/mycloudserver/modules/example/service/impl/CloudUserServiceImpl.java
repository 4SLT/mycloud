package com.fslt.mycloudserver.modules.example.service.impl;

import com.fslt.mycloudserver.modules.example.domain.CloudUser;
import com.fslt.mycloudserver.modules.example.mapper.CloudUserMapper;
import com.fslt.mycloudserver.modules.example.service.CloudUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: CloudUserServiceImpl
 * @date: 2019/12/6 23:17
 * @author: zongxiong.lin
 * @version: 1.0
 */
@Service
public class CloudUserServiceImpl implements CloudUserService {

    @Resource
    private CloudUserMapper cloudUserMapper;

    @Override
    public List<CloudUser> getList() {
        return cloudUserMapper.getList();
    }
}