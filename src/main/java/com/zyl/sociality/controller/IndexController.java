package com.zyl.sociality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    //用来设置默认首页，效果也不错
    @RequestMapping("/")
    public ModelAndView  index()
    {
        return new ModelAndView("forward:/postinfo/list/1");
    }
}
