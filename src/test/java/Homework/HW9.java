package Homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HW9 extends PetStoreBaseUrl {

/*
Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets"
with a status of "available" and asserts that those are more than 100.
 */

   /*
    Given
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        Send the request and get response
    Then
        find number of pets that are available
    And
        number of pets must be more than 100
 */
     @Test
     public void hw9(){

          //Assert the url
        spec.pathParams("first", "pet", "second", "findByStatus").queryParams("status", "available");

          //Sent the request and get the response

         Response response = given(spec).get("{first}/{second}");
          response.prettyPrint();

         //Do assertion

         assertEquals(200, response.statusCode());

         JsonPath jsonPath = response.jsonPath();
         List<String> available = jsonPath.getList("status");
         System.out.println("available = " + available);
         System.out.println("available = " + available.size());

         assertTrue(available.size()>100);


         /*
        Solution:

        int numOfavailablePets = response.jsonPath().getList("id").size();
        assertTrue(numOfavailablePets>100);

          */






     }






}
