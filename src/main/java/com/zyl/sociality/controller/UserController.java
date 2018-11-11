package com.zyl.sociality.controller;

import com.zyl.sociality.service.UserService;
import com.zyl.sociality.webMagic.DouBanPageProcessor;
import com.zyl.sociality.webMagic.PostInfoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Object findUserList()
    {
        return userService.findUserList();
    }
    @RequestMapping("/go")
    public Object goSpider()
    {
        Spider.create(new DouBanPageProcessor())
                .addUrl("https://www.douban.com/group/sydb/discussion?start=0")
                .addPipeline(new PostInfoPipeline())
                //开启5个线程抓取
                .thread(4)
                //启动爬虫
                .run();
        return "完成";
    }
}
