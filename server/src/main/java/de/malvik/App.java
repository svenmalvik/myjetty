package de.malvik;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);

        //setServlet(server);
        setWebappServlet(server);
        server.start();
        server.join();
    }

    private static void setWebappServlet(Server server) {
        WebAppContext webapp = new WebAppContext();
        webapp.setWar(new File("webapp/target/webapp.war").getAbsolutePath());
        webapp.setContextPath("/web");

        server.setHandler(webapp);
    }

    private static void setServlet(Server server) {
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(PingHandler.class, "/ping");
        server.setHandler(handler);
    }
}
