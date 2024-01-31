package org.acme;

import org.acme.models.User;
import org.acme.service.UserService;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/users")
public class GreetingResource {

    @Inject
    UserService userService;
    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchUserDetails() {
       logger.info("returning all users");
        return userService.fetchUsers();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchUserDetailbyName(@PathParam("name") String userName) {
       logger.info("returning users with name : " + userName);
        return userService.fetchUsersByName(userName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUser(User user) {
        logger.info("creating new users");
        return userService.createNewUser(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        logger.info("updating  users");
        return userService.updateUser(user);
    }
    @DELETE
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("name") String userName) {
        logger.info("deleting  users");
        return userService.deleteUser(userName);
    }

}
