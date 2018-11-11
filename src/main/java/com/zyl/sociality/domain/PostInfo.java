package com.zyl.sociality.domain;

import java.io.Serializable;

/**
 * 帖子信息表
 */
public class PostInfo implements Serializable {

  private int id;
  private String title;
  private String content;
  private String source;
  private String sourceUrl;
  private int ownerId;
  private String ownerImg;
  private String ownerName;
  private java.util.Date publishtime;
  private java.util.Date freshtime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public String getSourceUrl() {
    return sourceUrl;
  }

  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }


  public int getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(int ownerId) {
    this.ownerId = ownerId;
  }


  public String getOwnerImg() {
    return ownerImg;
  }

  public void setOwnerImg(String ownerImg) {
    this.ownerImg = ownerImg;
  }


  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }


  public java.util.Date getPublishtime() {
    return publishtime;
  }

  public void setPublishtime(java.util.Date publishtime) {
    this.publishtime = publishtime;
  }

  public java.util.Date getFreshtime() {
    return freshtime;
  }

  public void setFreshtime(java.util.Date freshtime) {
    this.freshtime = freshtime;
  }

}
