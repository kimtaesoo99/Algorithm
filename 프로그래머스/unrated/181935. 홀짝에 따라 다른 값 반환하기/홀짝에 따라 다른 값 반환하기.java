import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
            return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).sum();
        }
        return IntStream.rangeClosed(2, n).filter(i -> i % 2 == 0).reduce(0, (s1, s2) -> (int) (s1 + Math.pow(s2, 2)));
    }
}