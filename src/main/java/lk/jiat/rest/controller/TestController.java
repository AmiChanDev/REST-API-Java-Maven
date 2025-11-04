package lk.jiat.rest.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class TestController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "TestController API Called";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postRequest(String input) {
        System.out.println(input);
        return input;
    }
}
