package lesson9.practice.inClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {
    private Calculator calculator;

    public CalcServlet(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = new BufferedReader(new FileReader(new File("content/1.html"))).lines()
                .collect(Collectors.joining("\n"));
        try (PrintWriter writer = resp.getWriter()){
            writer.write(content);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String op = req.getParameter("op");

        try (PrintWriter writer = resp.getWriter()){
            writer.write(calculator.doOperation(x,y,op));
        }
    }
}
