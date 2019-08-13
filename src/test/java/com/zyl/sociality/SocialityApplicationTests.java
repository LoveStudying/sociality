package com.zyl.sociality;

import com.zyl.sociality.mapper.PostInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialityApplicationTests {

    @Autowired
    PostInfoMapper postInfoMapper;
    @Test
    public void contextLoads() {
       System.out.println(postInfoMapper.distinctPost());
    }

}
