package testing;

import io.restassured.RestAssured;
import io.restassured.specification.Argument;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.util.List;

public class NestedBodyValidation {
    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void validationofNestedBody(){
        RestAssured.get(BASE_URL +"rate_limit")
                .then()
                .rootPath("resources.core")
                    .body("limit",equalTo(60))
                    .body("remaining",lessThanOrEqualTo(60))
                    .body("reset",notNullValue())
                .rootPath("resources.search")
                    .body("limit",equalTo(10))
                    .body("remaining",lessThanOrEqualTo(10))
                .noRootPath()
                    .body("resources.graphql.limit",is(0));
    }


}
