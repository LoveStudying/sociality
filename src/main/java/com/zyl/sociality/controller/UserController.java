package com.zyl.sociality.controller;

import com.zyl.sociality.domain.User;
import com.zyl.sociality.service.UserService;
import com.zyl.sociality.webMagic.BuidInfoPipeline;
import com.zyl.sociality.webMagic.DouBanPageProcessor;
import com.zyl.sociality.webMagic.LjInfoPageProcessor;
import com.zyl.sociality.webMagic.PostInfoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@Controller
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
        Spider.create(new LjInfoPageProcessor())
                .addUrl("https://sy.lianjia.com/xiaoqu/3115388196767878/")
                .addPipeline(new BuidInfoPipeline())
                .thread(1)
                //启动爬虫
                .run();
        return "完成";
    }
    @PostMapping("/login")
    public String pageDetail(String  userName, String passWord, Boolean remeber, Model model){
        User user= userService.login(userName,passWord);
        model.addAttribute("userInfo",user);
        return "postList";
    }
}
