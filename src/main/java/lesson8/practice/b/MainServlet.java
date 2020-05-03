package lesson8.practice.b;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class MainServlet extends HttpServlet {
    private String content(String pathName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(new File(pathName)))
                .lines().collect(Collectors.joining("\n"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.write(content("src/main/java/lesson8/practice/b/index.jsp"));
        }
    }
}
