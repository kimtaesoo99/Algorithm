import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        if (num_list.length > 10) {
            return Arrays.stream(num_list).sum();
        }
        return Arrays.stream(num_list).reduce(1, (s1, s2) -> s1 * s2);
    }
}