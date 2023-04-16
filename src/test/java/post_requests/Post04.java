package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04 extends HerOkuAppBaseUrl {

    /*
      Given
       1)  https://restful-booker.herokuapp.com/booking
       2)   {
             "firstname": "John",
             "lastname": "Doe",
             "totalprice": 999,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-21",
                 "checkout": "2021-12-21"
              },
              "additionalneeds": "Breakfast"
          }
     When
    I send POST Request to the URL
   Then
    Status code is 200
And
    Response body is like {
                            "bookingid": 16,
                            "booking" :{
                                     "firstname": "John",
                                     "lastname": "Doe",
                                     "totalprice": 999,
                                     "depositpaid": true,
                                     "bookingdates": {
                                         "checkin": "2021-09-21",
                                         "checkout": "2021-12-21"
                                     },
                                     "additionalneeds": "Breakfast"
                                  }
                               }
  */

    @Test

    public void post04() {

        //Set the url

        spec.pathParam("first", "booking");

        //Set the expected data

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo expectedData = new BookingPojo("John", "Doe", 999, true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        BookingResponsePojo actualdata = response.as(BookingResponsePojo.class);
        System.out.println("actualdata = " + actualdata);

        //Do assertion

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualdata.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualdata.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualdata.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualdata.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualdata.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getAdditionalneeds(), actualdata.getBooking().getAdditionalneeds());

    }

}
