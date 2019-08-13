package com.zyl.sociality.service.impl;

import com.zyl.sociality.domain.BuildInfo;
import com.zyl.sociality.mapper.BuildInfoMapper;
import com.zyl.sociality.service.BuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuyanlin
 * @date 2019/8/12 15:24
 */
@Service
public class BuildInfoServiceImpl implements BuildInfoService {
    @Autowired
    BuildInfoMapper buildInfoMapper;
    @Override
    public int save(BuildInfo buildInfo) {
       return buildInfoMapper.save(buildInfo);
    }
}
