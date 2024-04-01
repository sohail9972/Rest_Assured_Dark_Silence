package testing.Booking2024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Postrequest extends BaseTest{
    @Test
    public void createBooking(){

        //created the Payload required to create POST request
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        booking.put("firstname","Sohail");
        booking.put("lastname","testing");
        booking.put("totalprice",7248);
        booking.put("depositpaid",true);
        booking.put("additionalneeds","brekfast");

        booking.put("bookingdates",bookingDates);

        bookingDates.put("checkin","2024-03-25");
        bookingDates.put("checkout","2024-03-30");

        //Validation Through The Rest Assured

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(booking.toString())
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .log().body()
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Sohail"))
                .body("booking.totalprice",Matchers.equalTo(7248))
                .body("booking.bookingdates.checkin",Matchers.equalTo("2024-03-25"));


    }
}
