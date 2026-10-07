package InterviewCoding;

import java.util.stream.IntStream;

public class Coding7 {
    public static void main(String[] args) {
        int number = 12345;
        IntStream stream = String.valueOf(number).chars();
        /*
        Because you cannot directly stream the digits of an int, this line uses a clever workaround:
        String.valueOf(number): Converts the number into the text string "12345".
        .chars(): Splits that string into a stream of its characters.
        However, as we saw in a previous example, Java streams characters as their primitive integer ASCII values.
        So, this creates an IntStream containing [49, 50, 51, 52, 53] (the ASCII codes for '1', '2', '3', '4', '5').
        **/
        int sum = stream.map(Character::getNumericValue).sum();
        /*
        .map(Character::getNumericValue): If we just summed the ASCII values, the answer would be 255! We need to convert ASCII 49 back into the actual number
            1. Character::getNumericValue looks at the ASCII code and maps it to its true mathematical value. The stream is now [1, 2, 3, 4, 5].
               .sum(): A built-in terminal operation for IntStream that simply adds all the numbers together, resulting in 15.
        * */
        System.out.println(sum);

        /*
        While the Stream API approach is cool and shows you know modern Java,
        interviewers will almost always ask you to solve this mathematically without converting the number to a String.
        Converting to a String takes extra memory and time.
        If an interviewer asks you to optimize it or do it without Strings, you should use the Modulo (%) and Divide (/) approach.
        Here is the classic $O(n)$ algorithmic way to do the exact same thing:
        **/
        int input = 12345;
        int sumResult = 0;
        while(input > 0) {
            sumResult += input % 10; // 12345 -> 5 | 1234 -> 4 | 123 -> 4 | 12 ->3
            input /= 10;
        }
        System.out.println(sumResult);

    }
}
