package testing;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.StringReader;
import java.sql.SQLOutput;
import java.util.Map;

public class valuesfromJsonpath {
    public static final java.lang.String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void jsonPathReturnsMap() {
        Response response = RestAssured.get(BASE_URL);
        ResponseBody<?> body = response.body();
        JsonPath jpath = body.jsonPath();

        JsonPath jpath2 = response.body().jsonPath();

        Map<String, String> fullJson = jpath2.get();
        Map<String, String> submap = jpath2.get("resources");
        Map<String, String> Submap2 = jpath2.get("resources.core");

        int value = jpath2.get("resources.core.limit");
        int value2 = jpath2.get("resources.core.remaining");

        System.out.println(fullJson);
        System.out.println(submap);
        System.out.println(Submap2);
        System.out.println(value);
        System.out.println(value2);

        Assert.assertEquals(value, 60);
        Assert.assertEquals(value2, 60);

    }
//        @Test
//        public void castingFailure()
//        {
//            JsonPath jpath3 = RestAssured.get(BASE_URL).body().jsonPath();
//
//            Map<String,String> mapjsonbody = jpath3.get("incorrect.path");  // Null pointer exception
//            int aMap = jpath3.get("rescources.core"); // Classcastexception
//            String value3 = jpath3.get("resources.core.limit");  //classcastexception
//
//        }
    }
