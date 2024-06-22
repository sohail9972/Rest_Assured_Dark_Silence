package testing.ReaptingActions.utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
