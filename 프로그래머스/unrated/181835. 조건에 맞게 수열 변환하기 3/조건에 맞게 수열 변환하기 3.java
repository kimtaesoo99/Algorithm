import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(i -> {
            if (k % 2 == 0) {
                return i += k;
            }
            return i *= k;
        }).toArray();
    }
}