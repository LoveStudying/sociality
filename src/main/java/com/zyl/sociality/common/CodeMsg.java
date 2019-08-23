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
    PASSWORD_WRONG(500, "Internal Server Error"),;
    private Integer code;
    private String msg;
}