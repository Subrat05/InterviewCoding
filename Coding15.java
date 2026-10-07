package InterviewCoding;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Coding15 {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps";

        // 1. Group words by their length, sorted automatically by TreeMap
        TreeMap<Integer, List<String>> wordsByLength = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,           // TreeMap keeps the keys (lengths) sorted!
                        Collectors.toList()
                ));

        // 2. Get the last entry in the TreeMap (which has the highest key)
        List<String> longestWords = wordsByLength.lastEntry().getValue();

        System.out.println(longestWords);
        // Prints: [quick, brown, jumps]
    }
}