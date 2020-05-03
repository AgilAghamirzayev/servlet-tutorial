package lesson8.practice.b;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCookies extends HttpServlet {

    private static final long serialVersionUID = 1L;
    DeleteCookies(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()){
            Cookie[] cookies = req.getCookies();
            if (cookies != null){
                for (Cookie cookie: cookies){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
                out.println("All cookies have been deleted");
            } else {
                out.println("No cookies found");
            }
        }
    }
}
