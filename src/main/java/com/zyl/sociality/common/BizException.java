package com.zyl.sociality.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @author zhuyanlin
 * @date 2019/8/22 14:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private Object data;

    public BizException(CodeMsg codeMsg) {
        this.setCode(codeMsg.getCode());
        this.setMessage(codeMsg.getMsg());
        this.setData(new HashMap<>(1));
    }

    public BizException(Integer code, String msg) {
        this.setCode(code);
        this.setMessage(msg);
        this.setData(new HashMap<>(1));
    }
}
