package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName : Filter1  //类名
 * @Description : 测试多个过滤器one  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/9  12:19
 */
public class Filter1  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println( "Filter1前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println( "Filter1后置代码");
    }

    @Override
    public void destroy() {

    }
}


