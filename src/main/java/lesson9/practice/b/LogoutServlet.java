package lesson9.practice.b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie: cookies){
                if (cookie.getName().equals("JSESSIONID")){
                    System.out.println("JSESSIONID = " + cookie.getName());
                    break;
                }
            }
        }
        HttpSession session = req.getSession(false);
        System.out.println("User="+session.getAttribute("user"));
        session.invalidate();
        resp.sendRedirect("login.html");

    }
}
