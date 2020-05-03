package lesson8.practice.b;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int cookieCount;
    AddCookies(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "cookie" + (++cookieCount);
        String value = String.valueOf(System.currentTimeMillis());
        Cookie cookie = new Cookie(name,value);

        resp.addCookie(cookie);
        resp.getWriter().println("A cookies has been created successfully");
    }
}
