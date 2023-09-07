package cn.edu.lcu.cs.designpattern.adapter.signin;

import lombok.Data;

/**
 * 登录之后返回的结果
 */
@Data
public class ResultMsg {
    private Integer code;
    private String msg;
    private Object data;

    public ResultMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}