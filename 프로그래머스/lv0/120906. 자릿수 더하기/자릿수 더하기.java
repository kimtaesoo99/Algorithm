import java.util.Arrays;
class Solution {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}