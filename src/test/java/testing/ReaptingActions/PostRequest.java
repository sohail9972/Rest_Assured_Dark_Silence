package testing.ReaptingActions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testing.ReaptingActions.utils.BaseTest;

public class PostRequest extends BaseTest {

    @Test
    public void createBooking(){
        //Prepare request body by Json

        JSONObject booking = new JSONObject();
        JSONObject bookingpath= new JSONObject();

        booking.put("firstname","sohail");
        booking.put("lastname","maid");
        booking.put("totalprice",500);
        booking.put("depositpaid",true);
        booking.put("additionalneeds","breakfast");
        booking.put("bookingdates",bookingpath);


        bookingpath.put("checkin","2024-07-25");
        bookingpath.put("checkout","2024-07-30");

Response response=
        //creating the Post Request
         RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(booking.toString())
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                 //printing the body
//                     .log().body()
                 //printiting the headers
//                        .log().headers()
                 //printing al
//                     .log().all()
                .when()
                    .post()
                .then()
                    .assertThat()
                 //printing th eBody from Applicaation server
//                     .log().body()
                 //priting the Headers from application Server
//                    .log().headers()
                 //printing all Details
//                    .log().all()
                 //checking if the validation fails
//                    .log().ifValidationFails()

                    .statusCode(200)
                    .body("booking.firstname", Matchers.equalTo("sohail"))
                    .body("booking.bookingdates.checkin", Matchers.equalTo("2024-07-25"))

                .extract()
                 .response();

        int bookingId = response.path("bookingid");
        //Now we have taken the booking id from the Prvious API call and
//        Passing it to the nexty APi Request for getting the All the booking
        //details
        //creating New Get API call with Previous API call and Collecting
        //Collecting the Booking Id from Previous to next


                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .pathParams("bookingid",bookingId)
//                        .baseUri("https://restful-booker.herokuapp.com/booking/{{b_id}}")    or next line then mention params in get method
                        .baseUri("https://restful-booker.herokuapp.com/booking")
                        .when()
                            .get("{bookingid}")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("firstname",Matchers.equalTo("sohail"))
                        .body("lastname",Matchers.equalTo("maid"));
    }
}
