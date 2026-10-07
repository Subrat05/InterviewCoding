package InterviewCoding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExactlyOnce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 4, 5, 6, 8};

        List<Integer> exactlyOnceList = Arrays.stream(arr)
                .boxed()
                // 1. Group by the number and count occurrences
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                // 2. Stream the map entries
                .entrySet().stream()
                // 3. Filter for numbers that appeared exactly 1 time
                .filter(entry -> entry.getValue() == 1L)
                // 4. Extract the number (the key)
                .map(Map.Entry::getKey)
                // 5. Collect into a List
                .collect(Collectors.toList());

        System.out.println(exactlyOnceList); // Prints: [3, 6, 8]
    }
}
