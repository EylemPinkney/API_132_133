package Homework;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HW7 extends RegresBaseUrl {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
      @Test
      public void q02(){

          //Set the url
          spec.pathParams("first","api","second","users");

          //Set the expected data
          Map<String, String> expectedData = new HashMap<>();
          expectedData.put("name", "morpheus");
          expectedData.put("job", "leader");

          System.out.println("expectedData = " + expectedData);

          //Send the request and get the response

          Response response = given(spec).body(expectedData).post("{first}/{second}");
          response.prettyPrint();

          //Do assertion

          Map<String, String> actualData =response.as(HashMap.class);

          assertEquals(201, response.statusCode());
          assertEquals(expectedData.get("name"), actualData.get("name"));
          assertEquals(expectedData.get("job"), actualData.get("job"));
          assertEquals(expectedData.get(null), actualData.get("id"));





      }
}
