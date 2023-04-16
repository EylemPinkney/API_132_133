package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

      /*
    'RequestSpecification' interface provided by Rest Assured is used to club and extract
    repetitive actions like setting up base URL, headers, HTTP verbs etc which may be
    common for multiple Rest calls.
     */

    @Before//This method will run before each @Test methods.
    public void setUp() {

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com").build();

        /*
        We created our request specification. In this request specification, we specify our requests. The repetitions I will be
        doing in my requests, I can put every repetitions into my request specification. Such as base url, content type,
        etc.

         */
    }
}
