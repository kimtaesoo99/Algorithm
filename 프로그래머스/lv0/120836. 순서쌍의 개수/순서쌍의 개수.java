import java.util.stream.IntStream;

class Solution {
    public long solution(int n) {
        return IntStream.range(1, n + 1).filter(i -> n % i == 0).count();
    }
}
