package InterviewCoding;

import java.util.Arrays;
import java.util.Comparator;

public class Coding14 {
    public static void main(String[] args) {
        // Find the longest word in a given sentence using streams
        String sentence = "Welcome to EPAM Systems interview";
        //System.out.println(sentence.length());
        String longest = Arrays.stream(sentence.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
        // Arrays.stream() gives "Welcome", "to", "EPAM", "System", "System", "interview"
        // max () will find the maximum value from the Stream of String.
        // 6,1,3,4, 8
        System.out.println(longest); // interview

        /*
        Comparator.comparingInt(String::length) is a highly concise way to tell Java exactly how to compare two objects—in this case, by looking at their integer lengths.

        Here is exactly how it breaks down, step-by-step.

        1. The Extractor: String::length
            This is a method reference. It acts as a mapping function (specifically, a ToIntFunction) that tells Java:
            "When I give you a String, call its .length() method to get an integer."

            If you pass it the word "Welcome", it extracts the integer 7.

        2. The Factory: comparingInt()
            comparingInt() is a static factory method on the Comparator interface. It takes the extractor function from Step 1 and builds a full Comparator object behind the scenes.

            When the stream needs to compare two words (like "Welcome" and "to"), the generated Comparator does this:

            Applies String::length to "Welcome" -> gets 7.

            Applies String::length to "to" -> gets 2.

Compares the two primitive integers (7 > 2).

3. The Stream Action: .max()
As .max() iterates through your array of words, it uses the Comparator to continually evaluate the "current largest" string against the "next" string. Because the Comparator is comparing their lengths, .max() ultimately holds onto the word that produced the highest integer value—which is "interview" (9 characters).

        * */
    }
}
