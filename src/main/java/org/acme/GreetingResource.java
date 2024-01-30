package org.acme;

import java.util.ArrayList;
import java.util.List;

import org.acme.models.User;
import org.acme.service.UserService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.proxies.TvSeriesProxy;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class GreetingResource {

    @Inject
    UserService userService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchTvSeriesDeails() {
       
        return userService.fetchUsers();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

   

}
