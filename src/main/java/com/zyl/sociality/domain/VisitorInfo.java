package com.zyl.sociality.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VisitorInfo implements Serializable {

    String visitorIP;
    Date visitTime;
    int visitNum;
    Date lastFreshtime;

}
