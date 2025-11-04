package lk.jiat.rest;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class Main {
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(SERVER_PORT);
            tomcat.getConnector();

            Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());

            // Register Jersey servlet properly
            ServletContainer servletContainer = new ServletContainer(
                    new ResourceConfig().packages("lk.jiat.rest.controller")
            );

            Tomcat.addServlet(context, "restapi", servletContainer);
            context.addServletMappingDecoded("/rest_api/*", "restapi");

            tomcat.start();
            System.out.println("Server running at: http://localhost:8080/rest_api/test");
            tomcat.getServer().await();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
