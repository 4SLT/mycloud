package com.fslt.mycloudserver.result;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: Result
 * @date: 2019/12/6 23:19
 * @author: zongxiong.lin
 * @version: 1.0
 */
@Data
public class Result<T> implements Serializable, IResult<T> {

    public static final Logger logger = LoggerFactory.getLogger(Result.class);

    /**
     * 服务状态码，为int类型， 0 为成功，-1为业务异常，-2为服务异常。
     */
    private Integer status = SUCCESS_STATUS;
    /**
     * 描述信息。用于返回业务异常信息和服务异常信息，不可用于设置日志堆栈信息。举例：业务信息： msg = "附近暂无司机" ，服务异常信息：msg="订单创建失败".
     */
    private String msg;
    /**
     * 业务语义状态码，用于做业务语义路由
     */
    private String code;
    /**
     * 业务正常返回的消息体,每个服务使用专用Re对象，不可复用。属性命名规则同数据库命名。支持数据结构包装，例如：List<Re>，Set<Re>。
     */
    private T re;
    /**
     * 异常堆栈信息
     */
    private String trace;

    public Result() {
    }


    /**
     * 得到服务异常Result.msg字段值为"发生未知错误"
     */
    public static <T> Result<T> getServiceError() {
        return getServiceError("发生未知错误", null);
    }

    /**
     * 得到服务异常Result.
     *
     * @param message 用于设置Result.msg字段
     * @param code    用于设置Result.code字段
     */
    public static <T> Result<T> getServiceError(String message, String code) {
        Result<T> result = new Result<T>();
        result.setStatus(SERVICE_ERROR_STATUS);
        result.setMsg(message);
        result.setCode(code);
        return result;
    }

    /**
     * 得到服务异常Result.
     *
     * @param message 用于设置Result.msg字段
     * @param code    用于设置Result.code字段
     * @param trace   用于设置Result.trace字段
     */
    public static <T> Result<T> getServiceError(String message, String code, String trace) {
        Result<T> result = new Result<T>();
        result.setStatus(SERVICE_ERROR_STATUS);
        result.setMsg(message);
        result.setCode(code);
        result.setTrace(trace);
        return result;
    }

    /**
     * 得到正常结果.
     *
     * @param re 正常结果
     */
    public static <T> Result<T> getSuccessResult(T re) {
        Result<T> result = new Result<T>();
        result.setStatus(SUCCESS_STATUS);
        result.setRe(re);
        return result;
    }

    /**
     * 得到业务异常Result.
     *
     * @param msg   用于设置Result.msg字段
     * @param code  用于设置Result.code字段
     * @param trace 用于设置Result.trace字段
     */
    public static <T> Result<T> getBusinessException(String msg, String code, String trace) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setStatus(BUSINESS_ERROR_STATUS);
        result.setMsg(msg);
        result.setTrace(trace);
        return result;
    }

    /**
     * 得到业务异常Result.
     *
     * @param msg  用于设置Result.msg字段
     * @param code 用于设置Result.code字段
     */
    public static <T> Result<T> getBusinessException(String msg, String code) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setStatus(BUSINESS_ERROR_STATUS);
        result.setMsg(msg);
        return result;
    }

    /**
     * 用于拷贝集合中的bean
     *
     * @param source      待拷贝集合
     * @param targetClass 目标对象类型
     * @return
     */
    public static List copyPropertiesForCollection(Collection source, Class targetClass) {
        List result = new ArrayList();
        if (source != null) {
            for (Object item : source) {
                try {
                    Object targetObject = targetClass.newInstance();
                    BeanUtils.copyProperties(item, targetObject);
                    result.add(targetObject);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("status=").append(status);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", re=").append(re);
        sb.append('}');
        return sb.toString();
    }

}
