package Homework;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class HW2 extends RegresBaseUrl {

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */

    @Test
    public void homework2(){

        //1) Set the URL

        spec.pathParams("first", "api","second", "users", "third", 23);

        //2) Set the expected data

        //3) Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //4) Do assertion

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.header("Server").contains("cloudflare"));

    }
}
