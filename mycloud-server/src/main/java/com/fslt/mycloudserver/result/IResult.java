package com.fslt.mycloudserver.result;

/**
 * @description: IResult
 * @date: 2019/12/6 23:20
 * @author: zongxiong.lin
 * @version: 1.0
 */

public interface IResult<T> {

    /**
     * 成功
     */
    Integer SUCCESS_STATUS = 0;

    /**
     * 业务异常,必填字段为空，年龄为负数等
     */
    Integer BUSINESS_ERROR_STATUS = -1;

    /**
     * 服务异常，数据库连接超时，空指针等
     */
    Integer SERVICE_ERROR_STATUS = -2;

//    public int getStatus();
//
//    public void setStatus(int status);
//
//    public String getMsg();
//
//    public void setMsg(String msg);
//
//    public T getRe();
//
//    public void setRe(T re);
//
//    public String getCode();
//
//    public void setCode(String code);
//
//    public String getTrace();
//
//    public void setTrace(String trace);

}
