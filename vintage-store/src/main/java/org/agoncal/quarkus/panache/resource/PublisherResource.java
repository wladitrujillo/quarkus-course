package org.agoncal.quarkus.panache.resource;

import org.agoncal.quarkus.panache.model.Publisher;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {
    @GET
    @Path("{id}")
    public Publisher findPublisherById(@PathParam("id") Long id) {
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> listAllPublishers() {
        return Publisher.listAll();
    }

}
