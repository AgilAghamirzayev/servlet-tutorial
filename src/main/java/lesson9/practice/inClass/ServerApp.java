package lesson9.practice.inClass;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class ServerApp {
    private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(ServletCookieAdd.class,"/cs/*");
        handler.addServlet(ServletA.class, "/a/*");
        handler.addServlet(new ServletHolder(new ServletB()),"/b/*");

        Calculator calculator = new Calculator();
        handler.addServlet(new ServletHolder(new CalcServlet(calculator)),"/calc/*");

        handler.addFilter(new FilterHolder(new CalculatorFilter(calculator)),"/calc",ft);
        handler.addFilter(new FilterHolder(new CookieFilter()),"/a",ft);
        handler.addFilter(CookieFilter.class,"/b",ft);

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
