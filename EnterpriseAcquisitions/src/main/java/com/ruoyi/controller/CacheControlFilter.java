package com.ruoyi.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CacheControlFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 设置禁用浏览器缓存的响应头

        HttpServletResponse response2 = (HttpServletResponse) response;
        response2.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response2.setHeader("Pragma", "no-cache");
        response2.setHeader("Expires", "0");


        // 继续处理请求
        chain.doFilter(request, response);
    }

    // 其他必要的Filter接口方法
}
