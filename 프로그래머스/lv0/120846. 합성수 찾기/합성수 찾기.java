import java.util.stream.IntStream;

class Solution {
    public long solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }
            return 3 <= count;
        }).count();
    }
}