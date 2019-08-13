package com.zyl.sociality.mapper;

import com.zyl.sociality.domain.BuildInfo;
import com.zyl.sociality.domain.PostInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @author zhuyanlin
 * @date 2019/8/12 15:27
 */
public interface BuildInfoMapper {
    @Insert("INSERT INTO buildInfo (build_name,build_price,info_date) VALUES (#{buildName},#{buildPrice},#{infoDate});")
    @Options(useGeneratedKeys=true, keyColumn="id")
    int save(BuildInfo postInfo);
}
