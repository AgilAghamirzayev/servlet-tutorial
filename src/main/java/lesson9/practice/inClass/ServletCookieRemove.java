package lesson9.practice.inClass;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletCookieRemove extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) return;
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("aaa")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
    }
}
