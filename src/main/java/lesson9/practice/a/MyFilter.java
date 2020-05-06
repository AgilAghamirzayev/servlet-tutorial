package lesson9.practice.a;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
       // out.print("filter is invoked before");
        chain.doFilter(request,response); // send request to next resource
        out.print("filter is invoked after");
    }

    @Override
    public void destroy() {

    }
}
