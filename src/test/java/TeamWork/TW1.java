package TeamWork;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.UserIdPojo_TW;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TW1 extends JsonPlaceHolderBaseUrl {

    /*
    Note: Original question Get9- short version
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            Response body should be like that;
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false

            }
     */

    @Test
    public void tw1(){

        //Set the url

        spec.pathParams("first", "todos", "second", 2);

        //Set the expected data

        UserIdPojo_TW expectedData = new UserIdPojo_TW(1, 2, "quis ut nam facilis et officia qui", false);

        System.out.println("expectedData = " + expectedData);

        //Send the request and set the response

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        
        //Do assertion
        
        UserIdPojo_TW actualData = response.as(UserIdPojo_TW.class);
        System.out.println("actualData = " + actualData);
        
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());

        

    }
}
