package com.zyl.sociality.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyl.sociality.domain.PostInfo;
import com.zyl.sociality.service.PostInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postinfo")
public class PostInfoController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private PostInfoService postInfoService;
    //暂时在这里写下页数
    private final int pageSize =12;

    @RequestMapping("/list/{pageNum}")
    public String  index(Model model,@PathVariable int pageNum,String search){
        PageHelper.startPage(pageNum, pageSize);
        List<PostInfo> list=new ArrayList<>();
        if (StringUtils.isBlank(search))
        {
            list =postInfoService.findPostInfoList();
        }else{
            list =postInfoService.searchPost(search);
        }
        PageInfo<PostInfo> pageInfo = new PageInfo<>(list);
        model.addAttribute("loginName",request.getAttribute("userName"));
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("seachText",search);
        return "postList";
    }

    @RequestMapping("/detail/{postId}")
    public String pageDetail(@PathVariable int postId,Model model){
        PostInfo PI =postInfoService.findById(postId);
        model.addAttribute("loginName",request.getAttribute("userName"));
        model.addAttribute("postInfo",PI);
        return "postDetail";
    }
}
