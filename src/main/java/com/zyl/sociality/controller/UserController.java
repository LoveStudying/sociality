package com.zyl.sociality.controller;

import com.zyl.sociality.common.ApiOut;
import com.zyl.sociality.domain.User;
import com.zyl.sociality.service.UserService;
import com.zyl.sociality.utils.JwtHelper;
import com.zyl.sociality.webMagic.BuidInfoPipeline;
import com.zyl.sociality.webMagic.LjInfoPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Object findUserList() {
        return userService.findUserList();
    }

    @RequestMapping("/go")
    public Object goSpider() {
        Spider.create(new LjInfoPageProcessor())
                .addUrl("https://sy.lianjia.com/xiaoqu/3115388196767878/")
                .addPipeline(new BuidInfoPipeline())
                .thread(1)
                //启动爬虫
                .run();
        return "完成";
    }

    @PostMapping("/login")
    public ApiOut login(HttpSession session, String userName, String passWord, String remeber, HttpServletResponse response) throws Exception {
        User user = userService.login(userName, passWord);
        if ("on".equals(remeber)) {
            String token = JwtHelper.generateToken(user.getId(), user.getUserName(), user.getType());
            Cookie cookie = new Cookie("token", token);
            // 有效期,秒为单位 设置为三天
            cookie.setMaxAge(60 * 60 * 24 * 3);
            //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问,设置为“/”则这个项目下都可以使用
            //这个问题找了很久，切记
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            session.setAttribute("userName", user.getUserName());
        }
        return new ApiOut("true");
    }

    @PostMapping("/loginOut")
    public ApiOut login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //清除cookie
        Cookie[] cookies = request.getCookies();
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        //清除session
        session.removeAttribute("userName");
        return new ApiOut("ok");
    }
}
