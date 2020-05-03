package lesson8.practice.a;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new FirstServlet()),"/go");
        handler.addServlet(new ServletHolder(new SecondServlet()), "/sgo");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
