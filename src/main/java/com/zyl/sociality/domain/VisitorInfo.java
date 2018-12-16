package com.zyl.sociality.domain;


import java.io.Serializable;

public class VisitorInfo implements Serializable {

  private String visitorIP;
  private java.util.Date visitTime;
  private int visitNum;
  private java.util.Date lastFreshtime;

  public String getVisitorIP() {
    return visitorIP;
  }

  public void setVisitorIP(String visitorIp) {
    this.visitorIP = visitorIp;
  }


  public java.util.Date getVisitTime() {
    return visitTime;
  }

  public void setVisitTime(java.util.Date visitTime) {
    this.visitTime = visitTime;
  }


  public int getVisitNum() {
    return visitNum;
  }

  public void setVisitNum(int visitNum) {
    this.visitNum = visitNum;
  }


  public java.util.Date getLastFreshtime() {
    return lastFreshtime;
  }

  public void setLastFreshtime(java.util.Date lastFreshtime) {
    this.lastFreshtime = lastFreshtime;
  }

}
