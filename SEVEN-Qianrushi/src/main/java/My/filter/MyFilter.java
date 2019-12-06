package My.filter;


import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter 执行啦。。");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter 准备好啦。。");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter 销毁啦。。");
    }
}
