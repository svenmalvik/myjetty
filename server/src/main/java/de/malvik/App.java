package de.malvik;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);

// Chose one of the three
//-----------------------
//        server.setHandler(getSimpleServletHandler());
//        server.setHandler(getWebappHandler();
        server.setHandler(getJerseyHandler());

        server.start();
        server.join();
    }

    private static Handler getJerseyHandler() {
        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.setContextPath("/");
        ServletHolder servlet = ctx.addServlet(ServletContainer.class, "/api/*");
        servlet.setInitParameter("jersey.config.server.provider.classnames", Entrypoint.class.getCanonicalName());
        return ctx;
    }


    private static Handler getWebappHandler() {
        WebAppContext webapp = new WebAppContext();
        webapp.setWar(new File("webapp/target/webapp.war").getAbsolutePath());
        webapp.setContextPath("/web");
        return webapp;
    }

    private static Handler getSimpleServletHandler() {
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(PingHandler.class, "/ping");
        return handler;
    }
}
