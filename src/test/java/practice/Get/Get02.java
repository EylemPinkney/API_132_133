package practice.Get;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get02 extends PetStoreBaseUrl {

    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */

    @Test

    public void g02(){

        //Set the url

        spec.pathParams("first", "pet", "second", "findByStatus").queryParam("status", "available");

        //Set the expected data

        //Send the response and get the request

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        
        int availablePetNumber = response.jsonPath().getList("").size();
        System.out.println("availablePetNumber = " + availablePetNumber);

        assertTrue(availablePetNumber>100);





    }

}
