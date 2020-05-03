package lesson8.task;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {

  private Calculator calc;

  HashMap<User, List<Operation>> history = new HashMap<>();
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


    List<Operation> operations = new ArrayList<>();
    User user = new User();
    operations.add(new Operation(x,y,op,result));

    history.put(user,operations);
  }

  public HashMap<User, List<Operation>> getHistory() {
    return history;
  }
}


