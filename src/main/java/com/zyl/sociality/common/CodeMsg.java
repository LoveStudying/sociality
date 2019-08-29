package com.zyl.sociality.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CodeMsg {
    SUCCESS(200, "成功"),
    FAIL(500, "Internal Server Error"),
    PASSWORD_WRONG(1000, "用户名密码不匹配!"),;
    private Integer code;
    private String msg;
}