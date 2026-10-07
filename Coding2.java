package InterviewCoding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Coding2 {
    public static void main(String[] args) {

        // Write a Java program to find the max and min from the List of Integers
        List<Integer> numbers = Arrays.asList(10,20,30, 50, 40, 160, 80, 70, 100);

        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max value is " + max);

        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("minimum value is " + min);

        // Write a java program to reverse each word of a string using Java 8

        String inputString = "Hello World This is Java";
        System.out.println(inputString);
        String[] words = inputString.split(" "); // ["Hello", "World", "This", "is", "Java"]
        List<String> reverseStrings = Arrays.stream(words).map((word) ->
                                                                     new StringBuilder(word).reverse().toString()).toList();
        System.out.println(reverseStrings);
    }
}
