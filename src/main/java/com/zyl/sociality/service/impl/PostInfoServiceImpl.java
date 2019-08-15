package com.zyl.sociality.service.impl;

import com.zyl.sociality.domain.PostInfo;
import com.zyl.sociality.mapper.PostInfoMapper;
import com.zyl.sociality.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostInfoServiceImpl implements PostInfoService {
    @Autowired
    private PostInfoMapper postInfoMapper;

    @Override
    public int save(PostInfo postInfo) {

        return postInfoMapper.save(postInfo);
    }

    @Override
    public List<PostInfo> findPostInfoList() {
        List<PostInfo> list = postInfoMapper.findPostInfoList();
        return list;
    }

    @Override
    public PostInfo findById(int id) {
        PostInfo info = postInfoMapper.findById(id);
        return info;
    }

    @Override
    public void distinctPost() {
        postInfoMapper.distinctPost();
    }

    @Override
    public List<PostInfo> searchPost(String words) {
       return postInfoMapper.searchPost(words);
    }
}
