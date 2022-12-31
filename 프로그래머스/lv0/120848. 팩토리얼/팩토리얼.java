
import java.util.Arrays;

class Solution {

    public int solution(int n) {
        int[] numbers = new int[11];
        numbers[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i-1] * i;
        }
        return (int) Arrays.stream(numbers).filter(i -> i<=n).count()-1;
    }
}