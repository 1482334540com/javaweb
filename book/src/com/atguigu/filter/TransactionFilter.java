package com.atguigu.filter;


import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName : TransationFilter  //类名
 * @Description : 使用fitter实现事务统一管理  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/20  12:28
 */
public class  TransactionFilter  implements Filter {

    public TransactionFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();// 提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }

    }

    @Override
    public void destroy() {

    }
}


