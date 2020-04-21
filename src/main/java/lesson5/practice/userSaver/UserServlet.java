package lesson5.practice.userSaver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class UserServlet extends HttpServlet {
    private final TemplateEngine engine;



    public UserServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String,Object> data = new HashMap<>();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        data.put("users", Arrays.asList(
                new User("Aqil"   , "Zeka"),
                new User(firstName, lastName)
                ));

        engine.render("user.ftl",data,resp);
    }

}
