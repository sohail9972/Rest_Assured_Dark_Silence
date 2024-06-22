package testing.ReaptingActions.ComplexJSON;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    @Test
    public void test1() throws IOException {
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader("./src/test/java/testing/ReaptingActions/"));
            String line =null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
