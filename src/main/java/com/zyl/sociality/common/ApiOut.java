package com.zyl.sociality.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhuyanlin
 * @date 2019/8/22 11:05
 */
@Data
@AllArgsConstructor
public class ApiOut<T> {
    private int code;
    private String message;
    private T data;
//    private T data= (T) new HashMap();

    public ApiOut(T data) {
        this.code = CodeMsg.SUCCESS.getCode();
        this.message = CodeMsg.SUCCESS.getMsg();
        if (data != null) {
            this.data = data;
        }
    }
}
