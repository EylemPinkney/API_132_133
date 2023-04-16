package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url

        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data -- We need to set the expected data because we need data to send the API(Application programming interface)
        Map<String, Object> expectedData = new HashMap<>();//Payload -- Payload is the data, we'll send to API
        expectedData.put("userId", 55);
        expectedData.put("title", "Tidy your room");  // This is not recommended way
        expectedData.put("completed", false);
        /*
        {
           "userId": 55,
           "title": "Tidy your room",
           "completed": false
         } --> This is Json data type/structure. When we write code here, we use Java language. I have to convert Json to Java object.
         The key values we see in the Json, looks like map in Java.

         We created this map above because we are going to post this data. We need to send this data --> send request and get
         the response. We need a data to send, thats why we created we creted this in Java language and Java object.
         We cant use Json data directly here.
        */

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
        response.prettyPrint();
        /*
        Note: We add content type above as if we dont we wont be able to see Json data.
         */

        //Do Assertion -

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization - Json to Java
        System.out.println("actualData = " + actualData);


        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        /*
        In response, the data is in Json. We need to take it out, we use jsonPath. We are going to get our expected data
        from below of where it says  //Set the expected data.

        Where are we gonna get actual data. From  //Send the request and get the response. But this is on json data format.
        We'll get the response, convert it to map with as() method. --> as(HashMap.class); And we use the same Map
        --> Map<String, Object> with actual data

        When we do assertion, what we assert in software testing is; we  assert the expected data with actual data. We put the key
        in the parenthesis.
         */

    }

    @Test
    public void post01b() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        //Create an object folder from JsonPlaceHolderTestData class and use the expectedDataMapMethod to create "expected data".
        Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(55,"Tidy your room", false );




        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
        response.prettyPrint();
        /*
        Note: We add content type above as if we dont we wont be able to see Json data.
         */

        //Do Assertion

        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization-->Json to Java
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));



    }

}

