import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] numArray) {
        if (numArray.length <= 1) {
            return numArray;
        }

        if (numArray[numArray.length - 1] > numArray[numArray.length - 2]) {
            int diff = numArray[numArray.length - 1] - numArray[numArray.length - 2];
            numArray = Arrays.copyOf(numArray, numArray.length + 1);
            numArray[numArray.length - 1] = diff;
        } else {
            int doubledValue = numArray[numArray.length - 1] * 2;
            numArray = Arrays.copyOf(numArray, numArray.length + 1);
            numArray[numArray.length - 1] = doubledValue;
        }

        return numArray;
    }
}