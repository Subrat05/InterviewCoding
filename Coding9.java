package InterviewCoding;

public class Coding9 {
    public static void main(String[] args) {
        int num = 123456;
        int palindrome = num;
        int reverse = 0;
        while(num !=0) {
            int digit = num % 10; // 6
            reverse = (reverse * 10) + digit; // when digit = 6, reverse = 0 then reverse = (0 * 10) + 6
            // reverse = 6, digit = 5, reverse = (6 * 10) + 5 = 65
            // reverse = 65, digit = 4, reverse = (65 * 10) + 4 = 654
            num = num /10;
        }

        System.out.println(reverse);
    }
}
