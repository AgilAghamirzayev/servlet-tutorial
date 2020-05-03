package lesson8.practice.a;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//        String cookies = Arrays.stream(req.getCookies())
//                .map(c -> String.format("name=%s, value=%s", c.getName(), c.getValue()))
//                .collect(Collectors.joining(" "));
        try (PrintWriter out = resp.getWriter()) {
            Cookie[] cookies = req.getCookies();
            out.write(String.format("name %s : value %s",cookies[2].getName(), cookies[2].getValue()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
