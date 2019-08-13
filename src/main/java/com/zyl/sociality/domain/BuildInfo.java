package com.zyl.sociality.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuyanlin
 * @date 2019/8/12 14:33
 */
@Data
@ToString
public class BuildInfo implements Serializable {
    Integer id;
    String buildName;
    String buildPrice;
    Date infoDate;
}
