package com.zyl.sociality.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyl.sociality.domain.PostInfo;
import com.zyl.sociality.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/postinfo")
public class PostInfoController {
    @Autowired
    private PostInfoService postInfoService;
    //暂时在这里写下页数
    private final int pageSize =12;

    @RequestMapping("/list")
    public String  index(Model model){
        PageHelper.startPage(1, pageSize);
        List<PostInfo> list =postInfoService.findPostInfoList();
        PageInfo<PostInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "postList";
    }


    @ResponseBody
    @RequestMapping("/list/{pageNum}")
    public PageInfo<PostInfo> pageList(@PathVariable int pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<PostInfo> list =postInfoService.findPostInfoList();
        PageInfo<PostInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/detail/{postId}")
    public PostInfo pageDetail(@PathVariable int postId){
        PostInfo PI =postInfoService.findById(postId);
        return PI;
    }
}
