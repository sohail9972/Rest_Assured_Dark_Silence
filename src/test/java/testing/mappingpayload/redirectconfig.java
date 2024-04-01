package testing.mappingpayload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.config.RedirectConfig.redirectConfig;

public class redirectconfig {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void maxRedirect(){

        RestAssured.config = RestAssured.config().redirect(redirectConfig().followRedirects(true).maxRedirects(1));
        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(200);
    }

//    @Test
//    public void failureConfig(){
//
//        ResposeValidateFailureListener failurelistener = (reqspec,resSpec,response) ->
//                System.out.println("We have a failure , " + "response status was %s and the body contained : %s", response.getStatusCode(),response.body().asPrettyString());
//
//        RestAssured.config=RestAssured.config().failureConfig(failureConfig().failureListeners(failurelistener));
//
//        RestAssured.get(BASE_URL + "users/andrejs-ps")
//                .then()
//                .body("some.path", equalTo("a thing"));
//    }
}
