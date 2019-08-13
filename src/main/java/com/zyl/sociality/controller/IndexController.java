package com.zyl.sociality.controller;

import com.zyl.sociality.domain.VisitorInfo;
import com.zyl.sociality.service.VisitorInfoService;
import com.zyl.sociality.utils.DateHelper;
import com.zyl.sociality.utils.IpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private VisitorInfoService visitorInfoService;

    //用来设置默认首页，效果也不错
    @RequestMapping("/")
    public ModelAndView  index(HttpServletRequest request)
    {
        //记录进入首页的IP
        VisitorInfo vi =new VisitorInfo();
        vi.setVisitorIP(IpHelper.getIpAddress(request));
        vi.setVisitTime(DateHelper.getNowTime());
        visitorInfoService.save(vi);
        return new ModelAndView("forward:/postinfo/list/1");
    }
    /**
     * robots txt
     *
     * @return
     */
    @GetMapping("/robots.txt")
    public void robotsTxt(HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();
        String lineSeparator = System.getProperty("line.separator", "\n");
        writer.append("User-agent: *").append(lineSeparator);
        writer.append("Disallow:").append("  ").append(lineSeparator);
    }
}
