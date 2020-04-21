package lesson5.practice.userSaver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        TemplateEngine engine = TemplateEngine.folder("practice");
        handler.addServlet(new ServletHolder(new UserServlet(engine)),"/user/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
