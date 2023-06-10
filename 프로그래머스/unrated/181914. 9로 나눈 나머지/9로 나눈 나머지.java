import java.util.Arrays;

class Solution {
    public int solution(String number) {
        return Arrays.stream(number.split("")).mapToInt(Integer::parseInt).sum() % 9;
    }
}