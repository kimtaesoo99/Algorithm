import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return Math.max(numbers[numbers.length-1]*numbers[numbers.length-2]
                ,numbers[0]*numbers[1]);
    }
}