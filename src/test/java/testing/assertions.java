package testing;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class assertions {
    public static final java.lang.String BASE_URL = "https://api.github.com";

    @Test
    public void assertioncheck(){
        Response response = RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
    }

    @Test
    public void gennericHeader(){
        Response response= RestAssured.get(BASE_URL);

        Assert.assertEquals(response.getHeader("server"),"GitHub.com");
        Assert.assertEquals(response.getHeader("x-ratelimit-limit"),"60");

        //or
        Assert.assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")),60);
    }

    @Test
    public void getHeaders(){
        Response response = RestAssured.get(BASE_URL);
        Headers headers = response.getHeaders();
        String val = headers.getValue("header1");
        int size= headers.size();
//        List<Headers> list = headers.asList();
        boolean isPresent = headers.hasHeaderWithName("header2");
        assertTrue(isPresent);


    }
}
