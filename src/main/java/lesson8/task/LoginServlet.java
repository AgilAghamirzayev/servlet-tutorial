package lesson8.task;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = new BufferedReader(new FileReader(new File("src/main/java/lesson8/task/front/html/login.html")))
                .lines().collect(Collectors.joining("\n"));

        try (PrintWriter writer = resp.getWriter()){
            writer.write(content);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(name,password);

        Cookie cookie = new Cookie(user.getName(),user.getPassword());
        resp.addCookie(cookie);

    }
}
