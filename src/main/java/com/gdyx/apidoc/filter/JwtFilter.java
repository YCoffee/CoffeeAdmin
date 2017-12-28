package com.gdyx.apidoc.filter;

import com.gdyx.apidoc.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.catalina.servlet4preview.GenericFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Y_Coffee on 2017/12/5.
 */
//@WebFilter(filterName = "JwtFilter", urlPatterns = "/*")
public class JwtFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        String webPath = req.getContextPath();
        String uri = req.getRequestURI();

        String authHeader = req.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("不合法的Authorization Header");
        } else {
            String token = authHeader.substring(7);
            System.out.println("获取Token为：" + token);
            try {
                Claims claims = TokenUtil.unBuildToken(token);
                System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(claims.getIssuedAt()));
                filterChain.doFilter(req, rep);
            } catch (Exception e) {
                rep.sendError(4000,"Invalid Token(无效的记号)");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
