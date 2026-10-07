package InterviewCoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coding16 {
    public static void main(String[] args) {
        /*  You are given an array:
            [0, 1, 0, 4, 2, 14, 5, 1, 4]
            Some elements appear multiple times and some appear only once.
            ✅ Task:
            1. Take elements that occur more than once and sort them in ascending order with their original frequency
            2. Take elements that occur only once and sort them in ascending order
**/
        int[] arr = {0,1, 0, 4, 2, 14, 5, 1, 4};

        //Step 1: Calculate the frequency of each element

        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

        // Task 1: Elements occurring > 1 time, sorted ascending with original frequency
        List<Integer> task1Result = freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByKey()) // Sort by the number in ascending order
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream())
                .toList();

        // Task 2: Elements occurring exactly 1 time, sorted ascending
        List<Integer> task2Result = freqMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();

        System.out.println("Task 1 (Duplicates with original frequency): " + task1Result);
        System.out.println("Task 2 (Unique elements sorted): " + task2Result);



    }
}
