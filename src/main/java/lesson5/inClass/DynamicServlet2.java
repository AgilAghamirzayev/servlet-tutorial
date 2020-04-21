package lesson5.inClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class DynamicServlet2 extends HttpServlet {
    private final TemplateEngine engine;

    public DynamicServlet2(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HashMap<String,Object> data = new HashMap<>();
        data.put("students", Arrays.asList(
                new Student("Ali", 21,"BE3"),
                new Student("Tom", 32,"BE5"),
                new Student("Aysu",23,"BA4"),
                new Student("Aqil",21,"BE1")
        ));
        engine.render("dynamic2.ftl",data,resp);
    }
}
