package lesson9.practice.a;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String collect = new BufferedReader(new FileReader(new File("src/main/java/lesson9/practice/a/html/index" +
                ".html")))
                .lines().collect(Collectors.joining("\n"));

        PrintWriter out = resp.getWriter();
        out.write(collect);
        out.print("<br>welcome to servlet<br>");
        out.close();

    }
}
