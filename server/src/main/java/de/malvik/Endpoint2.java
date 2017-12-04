package de.malvik;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by smalvik on 04.12.2017.
 */
@Path("/ep2")
public class Endpoint2 {

    @GET
    @Path("2")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return (Response.ok("Test from Resteasy.").build());
    }
}
