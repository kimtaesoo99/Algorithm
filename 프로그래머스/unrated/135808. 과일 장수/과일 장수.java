import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        Integer[] arr = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) continue;
            if ((i+1)% m == 0) {
                sum += m * arr[i];
            }
        }
        return sum;
    }
}