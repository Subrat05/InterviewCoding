package InterviewCoding;
import java.util.List;
import java.util.Arrays;

public class Coding11 {
    public static void main(String[] args) {
        // Write a Java Program, to sort the String of List elements in a alphabetical orders

        List<String> words = Arrays.asList("Zebra", "Zoo", "Lion", "Tiger", "Rabbit", "Leopard", "Jack", "Horse", "Elephant");

        words.stream().sorted().forEach(System.out::println);
    }
}
