package testing.Booking2024;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PostAPIRequestUsingFile {

    @Test
    public void postAPIrequest(){

        try {
            String postAPIrequestBody=FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY),"UTF-8");
//            System.out.println(postAPIrequestBody);

           Response response=  RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(postAPIrequestBody)
                    .baseUri("https://restful-booker.herokuapp.com/booking")
                    .when()
                    .post()
                    .then()
                    .assertThat()
                    .statusCode(201)
                    .extract()
                    .response();


            JSONArray jsonArray = JsonPath.read(response.body().toString(),"$.booking..firstname");
            String firstname= (String) jsonArray.get(0);
            Assert.assertEquals(firstname,"Jim");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
