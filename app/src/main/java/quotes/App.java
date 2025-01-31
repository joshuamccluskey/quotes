/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        getJsonData();
        System.out.println(randomQuote(args[0], true)); // Test with args[0] for command line file path default
        System.out.println(randomQuote(args[0], false)); // Test with args[0] for random index

    }

    public static void getJsonData() throws IOException {
        String path = "/Users/joshuamccluskey/projects/courses/401/quotes/app/src/test/resources/recentquotes.json";
        System.out.println(randomQuote(path, true));
        System.out.println(randomQuote(path, false));
        System.out.println(randomQuote(path, false));
    }

    public static String randomQuote(String path, Boolean test) throws IOException {
        File file = new File(path); // input file path
        FileReader readFileLines = new FileReader(file); // read file
        Gson gson = new Gson(); // create a new gson object- this will be used to convert Java Object to JSON
        // representation
        Quotes[] json = gson.fromJson(readFileLines, Quotes[].class); // serialize data
        int index;
        if (test.equals(true)) { // checking input boolean: this will change our index variable
            index = 0;
        } else {
            index = (int) (Math.random() * json.length);
        } // get random number for our json array index
        String author = json[index].author + ": "; // extract author's name at randomly generated index
        String text = "\"" + json[index].text + "\"" ; // extract text at randomly generated index
        return author + text; // return author + text in String format
    }
}
