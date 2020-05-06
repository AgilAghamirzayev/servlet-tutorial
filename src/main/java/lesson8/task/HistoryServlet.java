package lesson8.task;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HistoryServlet extends HttpServlet {

    CalcServlet calcServlet = new CalcServlet();
    private final TemplateEngine engine;

    public HistoryServlet(TemplateEngine engine) {
        this.engine = engine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(req,resp);
        } else {
            if (calcServlet.history == null) {
                try (PrintWriter out = resp.getWriter()) {
                    out.write("History is null");
                }
            } else engine.render("history.ftl", calcServlet.getHistory(), resp);
        }
    }
}
