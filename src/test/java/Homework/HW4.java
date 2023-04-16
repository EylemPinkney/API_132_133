package Homework;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HW4 extends HerOkuAppBaseUrl {

    /*
        Given
             Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */

    @Test

    public void homework4() {

        //1) Set the URL

        spec.pathParam("first", "booking").queryParams("firstname", "Brandooon", "lastname", "Wilson");

        //2) Set the expected data

        //3) Send the request and get the response

        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();

        //4) Do assertion
        //assertEquals(200, response.statusCode());
       // assertTrue(response.asString().contains("booking"));



    }

}
