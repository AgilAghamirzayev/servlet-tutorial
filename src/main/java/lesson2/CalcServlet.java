package lesson2;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter w = resp.getWriter()){
            Map<String,String[]> params = req.getParameterMap();
            int x = Integer.parseInt(req.getParameter("x"));
            int y = Integer.parseInt(req.getParameter("y"));
            if (req.getParameter("op").equals("add")) w.write(String.format("%d + %d = %d",x,y,x+y));
            if (req.getParameter("op").equals("sum")) w.write(String.format("%d - %d = %d",x,y,x-y));
            if (req.getParameter("op").equals("div")) w.write(String.format("%d / %d = %d",x,y,x/y));
            if (req.getParameter("op").equals("mul")) w.write(String.format("%d * %d = %d",x,y,x*y));
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
