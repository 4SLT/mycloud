package com.fslt.mycloudserver.modules.example.domain;

/**
 * @description: CloudUser
 * @date: 2019/12/6 23:14
 * @author: zongxiong.lin
 * @version: 1.0
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CloudUser {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 头像URL
     */
    private String profilePhoneUrl;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 是否已注销(0否；1是)
     */
    private boolean deleteFlag;
    /**
     * 状态(0无效;1有效)
     */
    private boolean status;


}
