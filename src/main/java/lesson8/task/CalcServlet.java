package lesson8.task;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {

  private Calculator calc;

  HashMap<String, Object> history = new HashMap<>();
  public CalcServlet() {
  }

  public CalcServlet(Calculator calc) {
    this.calc = calc;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    if (cookies == null){
      LoginServlet loginServlet = new LoginServlet();
      loginServlet.doGet(req,resp);
    } else {
      String content =
              new BufferedReader(new FileReader(new File("src/main/java/lesson8/task/front/html/calc.html"))).lines()
                      .collect(Collectors.joining("\n"));

      try (PrintWriter writer = resp.getWriter()) {
        writer.write(content);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String x = req.getParameter("x");
    String y = req.getParameter("y");
    String op = req.getParameter("op");
    String result = calc.doOperation(x,y,op);

    List<Operation> operations = Arrays.asList(new Operation("1","4","mul","4"),
            new Operation("1","4","mul","4"),
            new Operation("1","4","mul","4"));

    history.put("operations",operations);

    try (PrintWriter writer = resp.getWriter()){

    }
  }

  public HashMap<String, Object> getHistory() {
    return history;
  }
}


