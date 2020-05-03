package lesson8.task;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server servlet = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler();
        TemplateEngine engine = TemplateEngine.folder("src/main/java/lesson8/task/front/ftl/");

        Calculator calc = new Calculator();
        handler.addServlet(new ServletHolder(new CalcServlet(calc)), "/calc/do/*");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/calc/login/*");
        handler.addServlet(new ServletHolder(new LogoutServlet()),"/calc/logout/*");
        handler.addServlet(new ServletHolder(new ReadCookies()),"/calc/read/*");
        handler.addServlet(new ServletHolder(new HistoryServlet(engine)),"/calc/history/*");

        servlet.setHandler(handler);
        servlet.start();
        servlet.join();
    }



}
