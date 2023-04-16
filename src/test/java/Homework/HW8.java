package Homework;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HW8 extends PetStoreBaseUrl {

     /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
   */

    /*
         Given
            https://petstore.swagger.io/v2/user
             {
              "id": 11
              "username": "Eylem",
              "firstName": "Eylem",
              "lastName": "Pinkney",
              "email": "ep@gmail.com",
              "password": "1234",
              "phone": "5678",
              "userStatus": 1
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
    public void hw8(){

        //Set the url

        spec.pathParams("first", "user");

        //Set the expected data

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", 0);
        expectedData.put("username", "Eylem");
        expectedData.put("lastName", "Pinkney");
        expectedData.put("email", "ep@gmail.com");
        expectedData.put("password", "1234");
        expectedData.put("phone","5678");
        expectedData.put("userStatus", 0);

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion

        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(200, actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));



    }
}
