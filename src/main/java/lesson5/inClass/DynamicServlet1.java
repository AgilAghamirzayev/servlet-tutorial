package lesson5.inClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class DynamicServlet1 extends HttpServlet {
    private final TemplateEngine engine;

    public DynamicServlet1(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String person_name = "Tom";
        HashMap<String,Object> data = new HashMap<>();
        data.put("name",person_name);

        engine.render("dynamic.ftl",data,resp);
    }
}
