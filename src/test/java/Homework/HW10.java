package Homework;


import base_urls.AutomationExercisePojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HW10 extends AutomationExercisePojo {

/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends Get request
        Note: use prettyPrint like: response.jsonPath().prettyPrint()
    Then
        Assert that number of "Women" usertype is 12

*/

    @Test
    public void hw10(){
        //Set the url

       spec.pathParam("first", "productsList");

        //Set the expected data

        //Send the request and get the url

        Response response = given().spec(spec).get("{first}");
        response.jsonPath().prettyPrint();

        //Do assertion

        assertEquals(200, response.statusCode());


        // Assert that number of "Women" usertype is 12

        JsonPath jsonPath = response.jsonPath();
        List<String> userType = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}");
        System.out.println("userType = " + userType);
        int numOfWomenUser = userType.size();
        assertEquals(12, numOfWomenUser);

        /*

    JsonPath jsonPath = response.jsonPath();
    //Assert that number of "Women" usertype is 12
    int numOfWomanUser = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
    assertEquals(12,numOfWomanUser);
         */

       
      










    }


}
