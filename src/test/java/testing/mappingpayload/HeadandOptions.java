package testing.mappingpayload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.core.IsEqual.equalTo;

public class HeadandOptions {
    public static final String BASE_URL= "http://api.github.com/";

    @Test
    public void headTest(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    public void options(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200) //no content
                .header("access-control-allow-methods", equalTo("GET,POST,PATCH,PUT,DELETE"))
                .body(emptyOrNullString());
    }
}
