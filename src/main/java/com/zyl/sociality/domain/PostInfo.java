package com.zyl.sociality.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子信息表
 */
@Data
public class PostInfo implements Serializable {

    int id;
    String title;
    String content;
    String source;
    String sourceUrl;
    int ownerId;
    String ownerImg;
    String ownerName;
    Date publishtime;
    Date freshtime;

}
