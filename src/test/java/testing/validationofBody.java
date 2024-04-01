package testing;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class validationofBody {

        public static final java.lang.String BASE_URL="https://api.github.com/users/andrejs-ps";

    @Test
    public void validateResponse(){
        RestAssured.get(BASE_URL)
                .then()
                .body("url",response -> Matchers.containsString("andrejs-ps")) ///valuates for one value
                .body("url",response -> Matchers.containsString(response.body().jsonPath().get("login"))); //Fetchs the Body Dynamically using lamda functions and Can be used for all the logins not only for the Single ones


    }


    // this Validates multiple values in the Jsonpath body w
//    @DataProvider
//    public Object[][] names(){
//        return new Object[][]{
//                {"andrejs-ps"},
//                {"rest-assured"}
//        };
//    }
//
//    @Test(dataProvider = "names")
//    public void complexBodyExamplewithDP(String name){
//        RestAssured.get(BASE_URL+"users/"+ name)
//                .then()
//                .body("url",response -> Matchers.containsString(response.body().jsonPath().get("login")));
//    }
}
