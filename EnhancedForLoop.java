package InterviewCoding;

public class EnhancedForLoop {
    public static void main(String[] args) {
        int[] intArray = {2, 1, 0};
        for(int i :intArray) { // here is the element of the array
            System.out.print(intArray[i] + ", ");
        }
        System.out.println();
        //tricky coding question
        System.out.println("Output of j ? where j =5, j =j++");

        int j = 5; // J value is store in a temporary variable
        j = j++;
        System.out.println(j);
        //Preincremet means first increment the value then assign
        //Postincrement means first assign the value then increment happen
        //That the reason here output is 5
    }
}
