package testing.Booking2024;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonwithComplexdata {
    @Test
    public void test1() throws IOException {


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/Files/FilewithJsonContent.json"));

            String line = null;

            StringBuilder builder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);

            }
            String jsonContent = builder.toString();
//            System.out.println(jsonContent);

           JSONArray array = JsonPath.read(jsonContent,"$.book..category");
            System.out.println(array);

            System.out.println(array.get(0));
//            System.out.println(array.getString(1));
//            System.out.println(array.getString(2));

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

