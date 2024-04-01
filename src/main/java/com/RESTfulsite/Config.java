package com.RESTfulsite;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@RunWith(Enclosed.class)
public class Config {

    @Test
    public void test1() throws IOException {
        
       
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/Files/FilewithJsonContent.json"));

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }




//        JsonPath.read(string,"expression");

//        try {
//            String postAPIrequestBody = FileUtils.readFileToString(new File(fileinMAin.POST_API_REQUEST_BODY), "UTF-8");
//
//            Response response = RestAssured
//                    .given()
//                    .contentType(ContentType.JSON)
//                    .body(postAPIrequestBody)
//                    .baseUri("https://restful-booker.herokuapp.com/booking")
//                    .when()
//                    .post()
//                    .then()
//                    .assertThat()
//                    .statusCode(200)
//                    .extract()
//                    .response();
//
////            Object json = response.body().asString();
//            JSONArray jsonarray = JsonPath.read(response.body().asString(), "$.booking.firstname");
//        } catch (IOException e) {
//            throw new RuntimeException(e);

