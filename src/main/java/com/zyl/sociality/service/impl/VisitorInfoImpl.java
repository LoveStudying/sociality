package com.zyl.sociality.service.impl;

import com.zyl.sociality.domain.VisitorInfo;
import com.zyl.sociality.mapper.VisitorInfoMapper;
import com.zyl.sociality.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorInfoImpl implements VisitorInfoService {
    @Autowired
    private VisitorInfoMapper visitorInfoMapper;

    @Override
    public int save(VisitorInfo visitorInfo) {
        return visitorInfoMapper.save(visitorInfo);
    }
}
