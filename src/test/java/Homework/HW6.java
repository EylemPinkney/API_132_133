package Homework;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HW6 extends RegresBaseUrl {

     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void hw6(){

        //Set the url

        spec.pathParams("first", "api","second", "unknown");

        //Set the expected data

        //Send the request and get the response

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        //1)Status code is 200
        assertEquals(200, response.statusCode());
        
        //2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        List<String> pantoneValues = jsonPath.getList("data.pantone_value");
        System.out.println("pantoneValue = " + pantoneValues);
        
        //3)Print all ids greater than 3 on the console.  Assert that there are 3 ids greater than 3
        
        List<Integer> idList = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("idList = " + idList);
        assertEquals(3,idList.size());
        
        //4)Print all names whose ids are less than 3 on the console. Assert that the number of names whose ids are less than 3 is 2

        List<String> nameList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameList = " + nameList);
        assertEquals(2, nameList.size());

    }


}
