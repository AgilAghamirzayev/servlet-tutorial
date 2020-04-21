package weekReview1.headFirst;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(23);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new MyServlet()),"/servlet");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
