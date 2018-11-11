package com.zyl.sociality.mapper;

import com.zyl.sociality.domain.PostInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PostInfoMapper {
    @Insert("INSERT INTO `postinfo` (`title`, `content`, `source`, `source_url`, `owner_id`, `owner_name`,`owner_img`, `publishtime`, `freshtime`) VALUES" +
            "(#{title},#{content},#{source},#{sourceUrl},#{ownerId},#{ownerImg},#{ownerName},#{publishtime},#{freshtime});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(PostInfo postInfo);

    @Select("SELECT * FROM postinfo order by createtime desc")
    List<PostInfo> findPostInfoList();

    @Select("SELECT * FROM postinfo WHERE id = #{id}")
    PostInfo findById(int id);
}
