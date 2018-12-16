package com.zyl.sociality.mapper;

import com.zyl.sociality.domain.VisitorInfo;
import org.apache.ibatis.annotations.Insert;

public interface VisitorInfoMapper {
    //根据主键去重+1
    @Insert("INSERT INTO visitorinfo (visitorIP, visitTime) VALUES (#{visitorIP}, #{visitTime})" +
            "ON DUPLICATE KEY UPDATE visitNum=visitNum+1;")
    int save(VisitorInfo visitorInfo);
}
