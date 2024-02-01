package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void fetchUserDetails() {
        given()
          .when().get("/users")
          .then()
             .statusCode(404);
             
    }

    @Test
    void addNewUser() {
        String jsonPayload = "{\n" +
        "    \"name\": \"vvv\",\n" +
        "    \"address\": \"newyork\",\n" +
        "    \"phoneNumber\": \"12344456444\"\n" +
        "}";

given()
    .contentType(ContentType.JSON)
    .body(jsonPayload)
.when()
    .post("/users")
.then()
    .statusCode(200)
    .body("name", is("vvv"))
    .body("address", is("newyork"))
    .body("phoneNumber", is("12344456444"));      
    }

    
}