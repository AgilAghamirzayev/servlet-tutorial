package lesson9.practice.a;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class ServerApp {
    private static final EnumSet<DispatcherType> request = EnumSet.of(DispatcherType.REQUEST);
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new HelloServlet()),"/servlet1");
        handler.addFilter(new FilterHolder(new MyFilter()),"/servlet1",request);

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
