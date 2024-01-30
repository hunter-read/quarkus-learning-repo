package org.proxies;


import org.acme.models.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
public interface TvSeriesProxy {

    @GET
    @Path("/shows")

    User get(@QueryParam("q") String showName);
    
}
