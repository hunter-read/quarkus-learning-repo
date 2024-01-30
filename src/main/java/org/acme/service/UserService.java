package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import org.acme.models.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UserService {
        List<User> users = new ArrayList<>();


    public Response fetchUsers() {
       if(users.isEmpty() || null == users){
        return Response.status(Response.Status.NOT_FOUND).entity("No user exists").build();  
         }
        return Response.ok(users).build();
    }
    

    public Response createNewUser( User user) {
        if( isNullOrEmpty(user.getName()) || isNullOrEmpty(user.getAddress()) || isNullOrEmpty(user.getPhoneNumber())){
            return Response.status(Response.Status.NOT_FOUND).entity("Enter Correct Data").build();  

        }
          boolean isPresent =  users.stream().anyMatch(u -> u.getName().equals(user.getName()));
          if(isPresent){
            return Response.status(Response.Status.NOT_FOUND).entity("user already exist").build();  

          }

          users.add(user);
        return Response.ok(user).build();
    }


    public boolean isNullOrEmpty(String str){
        if(str.isEmpty() || str.isBlank() || null == str){
            return false;
        }
        return true;
    
    }
}
