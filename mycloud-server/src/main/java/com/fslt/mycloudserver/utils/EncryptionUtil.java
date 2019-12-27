package com.fslt.mycloudserver.utils;

import com.fslt.mycloudserver.modules.user.domain.CloudUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * @description: 加密工具类
 * @date: 2019/12/27 15:27
 * @author: zongxiong.lin
 * @version: 1.0
 */
public class EncryptionUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

    /**
     * 加密用户部分信息
     *
     * @param cloudUser
     * @return
     */
    public static void encryptUser(CloudUser cloudUser) {
        String password = EncryptionUtil.encryptByMD5(cloudUser.getUserPassword());
        cloudUser.setUserPassword(password);
    }


    /**
     * 将密码MD5加密
     *
     * @param password
     * @return
     */
    public static String encryptByMD5(String password) {
        logger.info("待加密密码：{}", password);
        //使用spring自带md5加密
        try {
            String result = DigestUtils.md5DigestAsHex(password.getBytes());
            logger.info("加密成功");
            return result;
        } catch (Exception e) {
            logger.error("加密失败");
            e.printStackTrace();
            return null;
        }
    }


}
