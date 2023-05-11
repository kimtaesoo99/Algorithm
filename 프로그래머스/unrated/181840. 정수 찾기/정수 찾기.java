import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).anyMatch(i -> i == n) ? 1 : 0;
    }
}