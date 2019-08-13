package com.zyl.sociality.webMagic;

import com.zyl.sociality.domain.BuildInfo;
import com.zyl.sociality.service.BuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.PostConstruct;

/**
 * @author zhuyanlin
 * @date 2019/8/12 15:23
 */
@Component
public class BuidInfoPipeline implements Pipeline {

    @Autowired
    private BuildInfoService buildInfoService;

    private static BuidInfoPipeline buidInfoPipeline;

    @PostConstruct
    public void init() {
        buidInfoPipeline = this;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        BuildInfo info = (BuildInfo)resultItems.get("info");
        System.out.println(info);
        buidInfoPipeline.buildInfoService.save(info);
    }
}
