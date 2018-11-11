package com.zyl.sociality.domain;

import java.io.Serializable;

/**
 * 用户表
 */
public class User implements Serializable {

  private int id;
  private String userName;
  private String city;
  private int sex;
  private String userImg;
  private java.util.Date registertime;
  private java.util.Date birthday;
  private String phone;
  private String sign;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }


  public String getUserImg() {
    return userImg;
  }

  public void setUserImg(String userImg) {
    this.userImg = userImg;
  }


  public java.util.Date getRegistertime() {
    return registertime;
  }

  public void setRegistertime(java.sql.Date registertime) {
    this.registertime = registertime;
  }


  public java.util.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

}
