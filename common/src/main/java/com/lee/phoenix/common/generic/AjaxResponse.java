package com.lee.phoenix.common.generic;

import java.io.Serializable;

/**
 * Ajax返回对象. <p />
 *
 * @author lee
 * @version 1.0.0
 * @date 2018/08/07 23:00
 * @since JDK1.8
 */
public class AjaxResponse implements Serializable {
    /**
     * 操作成功.
     */
    public final static int SUCCESS = 0;

    /**
     * 通用失败
     */
    public final static int FAIL = -1;

    /**
     * 添加数据实体失败.
     */
    public static final int FAILURE_ADD_ENTITY = 10001;

    /**
     * 修改数据实体失败.
     */
    public static final int FAILURE_EDIT_ENTITY = 10002;

    /**
     * 删除数据实体失败.
     */
    public static final int FAILURE_DEL_ENTITY = 10003;

    /**
     * 响应结果编码.
     *
     * @see #SUCCESS
     * @see #FAIL
     * @see #FAILURE_ADD_ENTITY
     * @see #FAILURE_EDIT_ENTITY
     * @see #FAILURE_DEL_ENTITY
     */
    private int code;

    /**
     * 响应结果消息.
     */
    private String message;

    /**
     * 响应结果数据.
     */
    private Object data;


    private AjaxResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResponse success(Object data) {
        return new AjaxResponse(SUCCESS, "ok", data);
    }

    public static AjaxResponse fail(Object data) {
        return new AjaxResponse(FAIL, "fail", data);
    }

    public static AjaxResponse fail(int code, Object data) {
        return new AjaxResponse(code, "fail", data);
    }

    public static void main(String[] args) {


    }
}
