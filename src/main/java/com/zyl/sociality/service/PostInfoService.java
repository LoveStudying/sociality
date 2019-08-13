package com.zyl.sociality.service;

import com.zyl.sociality.domain.PostInfo;

import java.util.List;

public interface PostInfoService {

    int save(PostInfo postInfo);
    List<PostInfo> findPostInfoList();
    PostInfo findById(int id);
    void distinctPost();
}
