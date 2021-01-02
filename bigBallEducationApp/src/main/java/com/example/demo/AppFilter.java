package com.example.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;
//
@WebFilter(filterName = "BigBALL", urlPatterns = { "/*"})
public class AppFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String servletPath = httpServletRequest.getServletPath();
        HttpSession session= httpServletRequest.getSession();
        String requestURI = httpServletRequest.getRequestURI();




        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");

        response.setHeader("Access-Control-Max-Age", "3600");

        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");










        filterChain.doFilter(httpServletRequest, httpServletResponse);
//            if (session.getAttribute("user")==null&&(requestURI.contains("test3")||requestURI.contains("score")))
//            {
//                System.out.println("this is  unAuthoring");
//                ((HttpServletResponse) servletResponse).sendRedirect("/UnAuth");
//            }
//
//        else
//        {
//            System.out.println("this is  passing Authoring");
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//        }


    }

    @Override
    public void destroy() {

    }
}
