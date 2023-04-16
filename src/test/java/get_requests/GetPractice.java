package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPractice extends JsonPlaceHolderBaseUrl {

    /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL
      Then
          1)Status code is 200
          2)Print all ids greater than 190 on the console
            Assert that there are 10 ids greater than 190
          3)Print all userIds whose ids are less than 5 on the console
            Assert that the number of userIds whose ids are less than 5 is 4
          4)Print all titles whose ids are less than 5
            Assert that "delectus aut autem" is one of the titles whose id is less than 5

     */

    @Test

    public void g8(){

        //Set the url

        spec.pathParam("first", "todos");

        //Set the expected data


        //Send the request and get the response

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do assertion



        assertEquals(200, response.statusCode());

        //2)Print all ids greater than 190 on the console Assert that there are 10 ids greater than 190

        JsonPath jsonPath = response.jsonPath();



    }





}
