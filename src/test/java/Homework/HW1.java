package Homework;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HW1 extends RegresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

@Test

    public void homeWork1(){

    //Set the URL

    spec.pathParams("first", "api", "second", "users", "third", 3);

    //Set the expected data

    //Send the request and get the response

    Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
    response.prettyPrint();

    //Do assertion

    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");


}


}
