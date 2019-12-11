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
@Service
public interface CloudUserService {

    List<CloudUser> getList();

}
