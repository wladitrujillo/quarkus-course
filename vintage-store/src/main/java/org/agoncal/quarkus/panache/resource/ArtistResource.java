package org.agoncal.quarkus.panache.resource;

import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {
    @Inject
    ArtistRepository repository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id){
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> listAllArtists(){
        return repository.listAllArtistSorted();
    }

}
