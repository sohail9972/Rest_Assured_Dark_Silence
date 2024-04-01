package testing.Booking2024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class putrequest {
    @Test
    public void createBooking() {

        //created the Payload required to create POST request
        JSONObject booking = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        booking.put("firstname", "Sohail");
        booking.put("lastname", "testing");
        booking.put("totalprice", 7248);
        booking.put("depositpaid", true);
        booking.put("additionalneeds", "brekfast");

        booking.put("bookingdates", bookingDates);

        bookingDates.put("checkin", "2024-03-25");
        bookingDates.put("checkout", "2024-03-30");

        //Validation Through The Rest Assured
Response response =  RestAssured
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
                .body("booking.totalprice", Matchers.equalTo(7248))
                .body("booking.bookingdates.checkin", Matchers.equalTo("2024-03-25"))
        .extract().response();

int bookingId = response.path("bookingid");

RestAssured
        .given()
        .contentType(ContentType.JSON)
        .pathParam("bookingID",bookingId)
        .baseUri("https://restful-booker.herokuapp.com/booking")
        .when()
        .get("{bookingID}")
        .then()
        .assertThat()
        .statusCode(200)
        .body("firstname",Matchers.equalTo("Sohail"))
        .body("lastname",Matchers.equalTo("testing"));

    }
}

