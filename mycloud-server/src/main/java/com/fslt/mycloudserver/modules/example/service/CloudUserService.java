package com.fslt.mycloudserver.modules.example.service;

import com.fslt.mycloudserver.modules.example.domain.CloudUser;

import java.util.List;

/**
 * @description: CloudUserService
 * @date: 2019/12/6 23:17
 * @author: zongxiong.lin
 * @version: 1.0
 */
public interface CloudUserService {

    List<CloudUser> getList();


}