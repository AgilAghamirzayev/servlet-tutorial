package lesson3.practice.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;


public class LoginServlet extends HttpServlet {

    private final Users users;

    public LoginServlet(Users users) {
        this.users = users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = new BufferedReader(new FileReader(new File("content/login.html")))
                .lines().collect(Collectors.joining("\n"));

        try (PrintWriter pw = resp.getWriter()){
            pw.write(content);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (PrintWriter pw = resp.getWriter()){
            pw.write(users.add(username,password));
        }

    }

}
