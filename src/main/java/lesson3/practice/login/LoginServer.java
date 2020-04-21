package lesson3.practice.login;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class LoginServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler();

        Users users = new Users();

        handler.addServlet(new ServletHolder(new LoginServlet(users)),"/login");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
