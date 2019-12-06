package com.fslt.mycloudserver.modules.example.mapper;

import com.fslt.mycloudserver.modules.example.domain.CloudUser;

import java.util.List;

/**
 * @description: CloudUserMapper
 * @date: 2019/12/6 23:16
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface CloudUserMapper {

    List<CloudUser> getList();


}
