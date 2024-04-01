package testing.mappingpayload;

import com.RESTfulsite.User;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectMapperDemo {
    public static final String BASE_URL="https://api.github.com/users/rest-assured";

    @Test
    public void objectMappingTestOne(){
        User user=RestAssured.get(BASE_URL)
                .as(User.class);

        Assert.assertEquals(user.getLogin(),"rest-assured");
        Assert.assertEquals(user.getId(),19369327);
        Assert.assertEquals(user.getPublicRepos(),2);
    }
}
