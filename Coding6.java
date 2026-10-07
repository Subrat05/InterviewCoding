package InterviewCoding;

import java.util.Arrays;
import java.util.List;
public class Coding6 {
    public static void main(String[] args) {

        // Write a Java program to retrieve the last element of a list strings using Java 8's Stream API
        // Create and initialize a list of strings
        List<String> listOfString = Arrays.asList("One", " Two", "Three", "Four", "Five", "Six", "Seven");

        String rs = listOfString.stream().skip(listOfString.size() - 1).findFirst().orElse("Fallback error");
        System.out.println(rs);

    }
}
