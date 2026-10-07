package InterviewCoding;

import java.util.Arrays;
import java.util.List;

public class Coding13 {
    public static void main(String[] args) {
        //Given a list of integers, find the sum of all even numbers using Streams.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().filter((x) -> x % 2 ==0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of all the even numbers are: " + sum);

        /*
            The Problem: Objects vs. Primitives
            When you create a list of numbers in Java (List<Integer>), you are not storing primitive int values (like 5).
            You are storing Integer objects (wrappers that hold the primitive int inside them).

            When you call .stream().filter(...), you are left with a Stream<Integer>.
            Because this is a stream of generic objects, it does not have math methods like .sum(), .average(), or .max().
            As far as Java is concerned, this could be a stream of User objects or String objects!

            The Solution: mapToInt(Integer::intValue)
            This line acts as a bridge. It transforms your generic Stream<Integer> into a specialized IntStream (a primitive stream).

            Here is how the two parts of that line work:

            mapToInt(...):
            This method tells the stream, "Take every object in this stream, apply a conversion rule to it,
            and output a primitive IntStream." Because IntStream is specifically designed for numbers, it comes with built-in math methods like .sum().

            Integer::intValue:
            This is a method reference. It is the specific conversion rule passed to mapToInt.
            It tells Java to look at every Integer object and call its built-in .intValue() method to crack open the object and extract the raw, primitive int hiding inside.
        *
        * */

    }
}
