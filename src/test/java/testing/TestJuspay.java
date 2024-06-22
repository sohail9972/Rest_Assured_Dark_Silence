package testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestJuspay {
    public static void setup(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getREquest(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(response.jsonPath().getString("title[1]"),("qui est esse"));
    }
}
