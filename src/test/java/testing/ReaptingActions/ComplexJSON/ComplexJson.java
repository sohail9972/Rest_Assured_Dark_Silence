package testing.ReaptingActions.ComplexJSON;

import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ComplexJson {

    @Test
    public void complexity() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/test/java/testing/ReaptingActions/Demo.json"));
            String line = null;

            StringBuilder builder = new StringBuilder();


            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            String jsoncontent = builder.toString();
            System.out.println(jsoncontent);
//        JSONArray array = JsonPath.read(jsoncontent,"$.people..firstName");
            net.minidev.json.JSONArray array1 = JsonPath.read(jsoncontent,"$.people..firstName");
            System.out.println(array1.get(0));

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
