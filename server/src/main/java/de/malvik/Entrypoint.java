package de.malvik;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by smalvik on 29.11.2017.
 */
@Path("/ep")
public class Entrypoint {

    /**
     * http://localhost:8080/api/ep/1
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("1")
    public String endpoint1() {
        return "Hallo form endpoint1";
    }

}