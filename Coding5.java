package InterviewCoding;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coding5 {
    public static void main(String[] args) {
        //Write a Java program to remove duplicate elements from the List using Java 8 Streams
        List<Integer> elements = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8, 9, 20);
        List<Integer> uniqueElements = elements.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueElements);

        // The distinct intermediate operations filters the stream to remove duplicate elements.
        int[] arr = {1, 2, 3, 4, 5,1, 2, 4, 5, 6, 8};

        List<Integer> rs = Arrays.stream(arr)
                                    .distinct()
                                    .boxed()
                                    .toList();
        /*
        Why do you need .boxed()?
            Arrays.stream(arr) creates an IntStream (a special stream for primitive numbers).
            However, Collectors.toList() expects a standard stream of objects (Stream<Integer>).
            The .boxed() method bridges this gap by wrapping your primitive ints into Integer objects.
        * */

        System.out.println(rs);
    }
}
