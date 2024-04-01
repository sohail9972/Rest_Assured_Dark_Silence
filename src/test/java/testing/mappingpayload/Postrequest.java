package testing.mappingpayload;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Postrequest {
    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";


    @Test(description = "Create a repo")
    public void postTest(){

        RestAssured
                .given()
                .header("Authorization","token "+ TOKEN)
                .body("{\"name\": \"RepoforGit\"}")
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(201);
    }

    @Test(description = "update a repo")
    public void patchTest(){

        RestAssured
                .given()
                    .header("Authorization","token "+ TOKEN)
                    .body("{\"name\": \"test\"}")
                .when()
                    .patch("https://api.github.com/repos/sohail9972/encrypt")
                .then()
                    .statusCode(200);
    }

    @Test(description = "delete a repo")
    public void deleteTest(){

        RestAssured
                .given()
                    .header("Authorization","token "+ TOKEN)
                    .body("{\"name\": \"test\"}")
                .when()
                    .delete("https://api.github.com/repos/sohail9972/test")
                .then()
                .statusCode(204);
    }
}
