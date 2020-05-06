package lesson9.practice.inClass;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private boolean isHttp(ServletRequest request, ServletResponse response) {
        return request instanceof HttpServletRequest && response instanceof HttpServletResponse;
    }

    private boolean isRequestValid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("aaa") && cookie.getValue().equals("bbb")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isHttp(request,response) && isRequestValid((HttpServletRequest) request))
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
