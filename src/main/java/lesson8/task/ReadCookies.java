package lesson8.task;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadCookies() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            Cookie[] cookies = req.getCookies();
            if (cookies == null) {
                out.println("No cookies found");
            } else {
                out.println("Number of cookies: " + cookies.length);
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String value = cookie.getValue();

                    out.println(name + " : " + value);
                }
            }
        }
    }
}
