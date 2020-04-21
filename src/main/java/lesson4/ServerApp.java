package lesson4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server servlet = new Server(8081);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new StaticServlet("css")),"/css/*");
        handler.addServlet(new ServletHolder(new StaticServlet("images")),"/images/*");
        //handler.addServlet(new ServletHolder(new StaticServlet("js")),"/js/*");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/login");

        servlet.setHandler(handler);
        servlet.start();
        servlet.join();
    }



}
