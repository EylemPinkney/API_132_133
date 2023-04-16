package Homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.SwaggerPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HW8_Pojo extends PetStoreBaseUrl {

     /*
         Given
            https://petstore.swagger.io/v2/user
             {
              "id": 0,
              "username": "Eylem",
              "firstName": "Eylem",
              "lastName": "Pinkney",
              "email": "ep@gmail.com",
              "password": "1234",
              "phone": "5678",
              "userStatus": 123
            }
        When
            I send POST Request to the Url
        Then
            Status code is 200
        And
            response body is like {
                                      "code": 200,
                                      "type": "unknown",
                                      "message": "9223372036854763614"
                                    }
     */

    @Test
    public void hw8Pojo(){

        //Set the url

        spec.pathParam("first", "user");

        //Set the expected data

        SwaggerPojo expectedData = new SwaggerPojo("Eylem", "Eylem", "Pinkney","ep@gmail.com", "1234", "5678", 123);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        
        //Do assertion

        Map<String ,Object> actualData =response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(200,actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));





    }

}
