package lesson1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter writer = resp.getWriter()){
            Map<String, String[]> params = req.getParameterMap();
            writer.write(String.format("req.getPathInfo:%s\n",req.getPathInfo()));
            writer.write(String.format("req.getQueryString:%s\n",req.getQueryString()));
            writer.write(String.format("req.getParameter:%s\n",req.getParameter("a")));
            writer.write(String.format("req.getDateHeader:%s\n",req.getDateHeader("date: ")));

        }
    }
}
