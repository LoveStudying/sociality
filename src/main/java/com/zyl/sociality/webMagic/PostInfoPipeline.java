package com.zyl.sociality.webMagic;



import com.zyl.sociality.domain.PostInfo;
import com.zyl.sociality.service.PostInfoService;
import com.zyl.sociality.service.impl.PostInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.PostConstruct;

@Component
public class PostInfoPipeline implements Pipeline {
    @Autowired
    private PostInfoService postInfoService;

    private static PostInfoPipeline postInfoPipeline;

    @PostConstruct
    public void init() {
        postInfoPipeline = this;
    }
    @Override
    public void process(ResultItems resultItems, Task task) {
        PostInfo info = (PostInfo)resultItems.get("info");
        postInfoPipeline.postInfoService.save(info);
    }
}
