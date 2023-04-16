package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is "application/json"
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos
       And
           "quis eius est sint explicabo" should be one of the todos title
       And
           2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04() {
        //Set the URL
        spec.pathParam("first", "todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();


        //Do assertion

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("", hasSize(200),
                        "title", hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2, 7, 9));



    }

    /*
    Note 1: hasSize() is a HamCrest.Matchers and  asserts if the size of the actual result is equal to the expected one
     body("", hasSize(200) -> between tirnak it is empty because, we want to count/check elements
    Note 2: hasItem() is a HamCrest.Matchers and  asserts if one of the titles has the expected one
    Note 3: hasItems() is like contains all and checks multiple items



    what have we done so far?

    1)
     */
}
