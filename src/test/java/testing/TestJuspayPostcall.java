package testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestJuspayPostcall {
    private static String requestBody = "{\\n\" +\n" +
            "            \"  \\\"title\\\": \\\"foo\\\",\\n\" +\n" +
            "            \"  \\\"body\\\": \\\"bar\\\",\\n\" +\n" +
            "            \"  \\\"userId\\\": \\\"1\\\" \\n}";
    public static void setup(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
}
@Test
    public void postRequest(){
    Response response = given()
            .header("Content-type","application/json")
            .and()
            .body(requestBody)
            .when()
            .post("/posts")
            .then()
            .extract().response();

    Assert.assertEquals(201,response.statusCode());
    Assert.assertEquals("foo",response.jsonPath().getString("title"));
    Assert.assertEquals("bar",response.jsonPath().getString("body"));
    Assert.assertEquals("1",response.jsonPath().getString("userId"));
    Assert.assertEquals("101",response.jsonPath().getString("id"));
}


}
