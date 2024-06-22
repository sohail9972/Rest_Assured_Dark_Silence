package testing;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class course1 {
    public static final java.lang.String BASE_URL = "https://api.github.com";
    @Test
    public void peek(){
        RestAssured.get(BASE_URL)
                .peek();
    }
}
