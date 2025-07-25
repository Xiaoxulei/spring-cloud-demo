package com.xuxiaolei.common;

import lombok.Data;

/**
 * @Author: xuxiaolei
 * @Description: TODO: R
 * @CreatTime: 2025/07/24 09:42
 **/
@Data
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public static R ok() {
        R r = new R();
        r.setCode(200);
        return  r;
    }
    public static R ok(String msg,Object data) {
        R r = new R();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return  r;
    }

    public static R error() {
        R r = new R();
        r.setCode(500);
        return  r;
    }

    public static R error(Integer code,String msg,Object data) {
        R r = new R();
        r.setCode(500);
        r.setMsg(msg);
        r.setData(data);
        return  r;
    }
}
