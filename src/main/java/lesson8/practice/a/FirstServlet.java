package lesson8.practice.a;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class FirstServlet extends HttpServlet {

    private String content(String pathName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(new File(pathName)))
                .lines().collect(Collectors.joining("\n"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.write(content("src/main/java/lesson8/practice/a/index.html"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String n = req.getParameter("userName");
        try (PrintWriter out = resp.getWriter()) {
            out.write(content("src/main/java/lesson8/practice/a/index2.html"));

            out.printf("Welcome %s \n" , n);

            Cookie ck = new Cookie("uname", n);
            resp.addCookie(ck);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
