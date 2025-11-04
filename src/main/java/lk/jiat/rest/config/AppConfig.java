package lk.jiat.rest.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("lk.jiat.rest.controller");
    }
}
