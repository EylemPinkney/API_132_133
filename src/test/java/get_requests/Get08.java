package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.nio.file.Path;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get08 extends JsonPlaceHolderBaseUrl {
       /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL
      Then
          1)Status code is 200
          2)Print all ids greater than 190 on the console
            Assert that there are 10 ids greater than 190
          3)Print all userIds whose ids are less than 5 on the console
            Assert that the number of userIds whose ids are less than 5 is 4
          4)Print all titles whose ids are less than 5
            Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get08() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("{first}");
        response.prettyPrint();//When I print, I see this [
        // -->That shows that this is a list and I have 200 elements in this list. Wecan use some filter by using
        //Groovy language. With Json path, I can reach the information in a list and we can take it out.

        //Do assertion
//        1)Status code is 200
        assertEquals(200, response.statusCode());

//        2)Print all ids greater than 190 on the console
        JsonPath jsonPath = response.jsonPath();//Ive 200 elements in my reponse and I'm converting this response to
        //JsonPath object. So, I'll put in a container and use it again and again.
        List<Integer> idList = jsonPath.getList("id");//I say go to jsonPath and get list and take all ids(ot titles, completed
        //or etc. It'll give me a list of it.
        System.out.println("idList = " + idList);

//        Assert that there are 10 ids greater than 190
        //1. Way: By using foreach loop
        int idsGreaterThan190 = 0;
        for (int w : idList) {
            if (w > 190) {
                idsGreaterThan190++;
            }
        }
        System.out.println("idsGreaterThan190 = " + idsGreaterThan190);
        assertEquals(10, idsGreaterThan190);

        //2nd Way: Recommended
        List<Integer> intListGroovy = jsonPath.getList("findAll{it.id>190}.id");//Groovy: Java based programming language. --> .id brings only ids
        System.out.println("intListGroovy = " + intListGroovy);
        assertEquals(10, intListGroovy.size());
        /*
        findAll{} means,inside a list like the one below, I'll do filter --> {
        "userId": 10,
        "id": 199,
        "title": "numquam repellendus a magnam",
        "completed": true
        }
        "findAll{it.id>190}.id" -->I want to filter all these elements according to their ids. This syntax will give me a list
        of ids that are greater than 190.Where id is; we can put any elements in there for example, title, userId, completed.

        I will filter these elements according to their ids.
        List<Integer> intListGroovy = jsonPath.getList("findAll{it.id>190}.id")
         */


//        3)Print all userIds whose ids are less than 5 on the console
        List<Integer> userIdList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);
        System.out.println(userIdList.size());//How many elements in our list

//        Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4, userIdList.size());

//        4)Print all titles whose ids are less than 5
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);

//        Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titleList.contains("delectus aut autem"));

        /*
        Note 1: Groovy language is Java based programming language. So, we can do filter with groovy on the example above.

         */

    }
}
