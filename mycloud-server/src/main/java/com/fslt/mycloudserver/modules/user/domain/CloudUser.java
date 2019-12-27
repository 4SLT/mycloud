package com.fslt.mycloudserver.modules.user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description: CloudUser
 * @date: 2019/12/11 16:04
 * @author: zongxiong.lin
 * @version: 1.0
 */

@Data
public class CloudUser {

    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户名
     */
    @NotNull(message = "用户名不允许为空")
    private String userName;
    /**
     * 用户密码
     */
    @NotNull(message = "用户密码不允许为空")
    private String userPassword;
    /**
     * 头像URL
     */
    private String profilePhotoUrl;
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
