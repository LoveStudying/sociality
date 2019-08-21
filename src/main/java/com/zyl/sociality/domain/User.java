package com.zyl.sociality.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 */
@Data
public class User implements Serializable {

    int id;
    String userName;
    String nickName;
    String passWord;
    String type;
    String city;
    int sex;
    String userImg;
    java.util.Date registertime;
    java.util.Date birthday;
    String phone;
    String sign;

}
