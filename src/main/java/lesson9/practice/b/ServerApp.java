package lesson9.practice.b;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class ServerApp {
    private static final EnumSet<DispatcherType> request = EnumSet.of(DispatcherType.REQUEST);
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
