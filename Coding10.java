package InterviewCoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Coding10 {

    public static void main(String[] args) {
        // Write a Java program to print all the even numbers from the lis using Java 8 Stream

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<Integer> evenList = numbers.stream().filter(x -> x % 2 ==0).collect(Collectors.toList());
        System.out.println(evenList);

    }
}
