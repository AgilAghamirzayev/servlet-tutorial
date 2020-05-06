package lesson9.practice.inClass;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class CalculatorFilter implements Filter {

    private Calculator calculator;

    public CalculatorFilter(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equals("POST")){
            Map<String, String[]> allParams = req.getParameterMap();
            boolean all =
                    allParams.containsKey("x") &&
                            allParams.containsKey("y") &&
                            allParams.containsKey("op");
            if (all && allValid(req)) chain.doFilter(request,response);
            else ((HttpServletResponse)response).sendRedirect("/a");

        } else chain.doFilter(request,response);
    }

    private boolean allValid(HttpServletRequest request){
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String op = request.getParameter("op");

        try {
            Integer.parseInt(x);
            Integer.parseInt(y);
            return calculator.allowedOps().contains(op);
        }catch (NumberFormatException ignored){
            return false;
        }
    }

    @Override
    public void destroy() {

    }
}
