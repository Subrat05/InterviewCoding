package InterviewCoding;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Coding3 {
    public static void main(String[] args) {
        // How do you find the frequency of each character in a string using Java 8 streams?

        String input = "epam systems";

        IntStream stream = input.chars(); // IntStream representing the ASCII values of each character, it converts stream of characters.

        /*
            You might wonder: Why does this return an IntStream instead of a CharStream?
            Java does not have a dedicated CharStream primitive stream type.
            Instead, the chars() method returns the integer Unicode/ASCII values of the characters.
            For example, 'a' becomes 97, 'e' becomes 101, and the space character becomes 32.
        * */
        Stream<Character> characterStream = stream.mapToObj(c -> (char)c); // mapToObj() converts each ASCII value back into a character.

        /*
        Stream<Character> characterStream = stream.mapToObj(c -> (char)c);
        Because we are dealing with a stream of primitive int values,
        we need to convert them back into objects so we can group them later.
        mapToObj(...) is a bridge method that converts a primitive stream (IntStream) into an object stream (Stream<T>).
        c -> (char)c takes the integer (e.g., 101), casts it back to a primitive char (e.g., 'e'), and Java automatically
        "autoboxes" it into a Character object.
        * */
        Map<Character, Long> map = characterStream.collect(Collectors.groupingBy( Function.identity(), Collectors.counting()));
        System.out.println(map); // { =1, p=1, a=1, s=3, t=1, e=2, y=1, m=2}

        /*
        Map<Character, Long> map = characterStream.collect(...)
        This line does the heavy lifting. It uses the collect terminal operation to gather the stream elements into a Map.
        It uses two specific collectors:

        Collectors.groupingBy(...): This works exactly like a GROUP BY clause in SQL.
        It splits the stream into "buckets" based on a classifier.

        Function.identity(): This is the classifier. It simply means "group the items by themselves".
        It tells the stream to use the character itself as the Map's key. You could also write this as c -> c.

        Collectors.counting(): This is the "downstream collector." Once groupingBy has grouped all identical characters together (e.g., putting both 'e's in the same bucket), counting() counts how many items are in that bucket and sets that number as the Map's value.
        * */

        Map<String, Long> frequency = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);

        //OR One-Liner Version
        Map<Character, Long> freq = input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);
    }
}
