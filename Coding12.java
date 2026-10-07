package InterviewCoding;

public class Coding12 {

    public static Boolean isPalindrom(Integer number) {
        int original = number;
        int reverse = 0;
        //Edge case 1: if the number is negative then it can't be palindrome. -121 or -123
        // Ede case 1: if the number is divisible by 10 except 0, then it can't be palindrome.
        if (number < 0 || (number % 10 == 0) && number != 0) {
            return false;
        }

        while(number > 0) {
            int digit =  number % 10;
            reverse = (reverse * 10) + digit;
            number /= 10;
        }
        return reverse == original;
    }
    public static void main(String[] args) {
        // write a java program to check , if the number is palindrome or not?
        System.out.println("121 is palindrome or not ? " + isPalindrom(121));
        System.out.println("1234 is palindrome or not ? " + isPalindrom(1234));
        System.out.println("555 is palindrome or not ? " + isPalindrom(555));
        System.out.println("100 is palindrome or not ? " + isPalindrom(100));

    }
}
