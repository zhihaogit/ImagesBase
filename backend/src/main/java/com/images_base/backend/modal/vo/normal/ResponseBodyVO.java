package com.images_base.backend.modal.vo.normal;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2021/12/20
 */
public class ResponseBodyVO {

    private String msg;


    private Object data;

    public ResponseBodyVO(Object data) {
        this.data = data;
    }

    public ResponseBodyVO(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
