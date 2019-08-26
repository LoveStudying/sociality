package com.zyl.sociality.Filter;

import com.zyl.sociality.utils.JwtHelper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhuyanlin
 * @date 2019/8/21 15:20
 */
@Component
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //以.js.css 结尾的文件不进行过滤
        if (StringUtils.endsWithAny(request.getRequestURL(),".js",".css",".ico",".map"))
        {
            filterChain.doFilter(request, servletResponse);
            return;
        }
        //先检查session
        if (request.getSession().getAttribute("userName") == null) {
            Cookie[] cookies = request.getCookies();
            //查看是否有cookie，有cookie就解析其中内容
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("token")) {
                        Claims claims = JwtHelper.verifyJwt(cookie.getValue());
                        try {
                            request.setAttribute("userName", claims.get("userName"));
                            request.setAttribute("userId", claims.get("userId"));
                            request.setAttribute("role", claims.get("role"));
                        } catch (Exception e) {

                        }
                    }
                }
            }
        } else {
            request.setAttribute("userName", request.getSession().getAttribute("userName"));
        }
        filterChain.doFilter(request, servletResponse);
    }
}
