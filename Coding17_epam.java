package InterviewCoding;

import java.util.Arrays;

public class Coding17_epam {

    // write a java program , if the second element is higher than first element print 1 else 0 for each element
    // in array. for the first element
    public static void main(String[] args) {
        int[] values = {1, 2, 7, 7, 9};
        System.out.println(getFlagsValue(values));
        int[] flags = getFlagsValue(values);
       System.out.println(Arrays.toString(flags));
    }

    public static int[] getFlagsValue(int[] values) {
        int[] result = new int[values.length];

        if(values.length == 0) {
            return result;
        }

        result[0] = 1;
        int max = values[0]; // initial value

        for(int i =1; i< values.length; i++) {
            if(values[i] > max) {
                result[i] = 1;
                max = values[i]; // if second element is > then previous, the new max is that second element.
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
