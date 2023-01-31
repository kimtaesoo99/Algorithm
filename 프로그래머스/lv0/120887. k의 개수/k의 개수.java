import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public long solution(int i, int j, int k) {
        return IntStream.rangeClosed(i,j)
                .mapToLong(num -> Arrays.stream(String.valueOf(num).split("")).filter(n->n.equals(String.valueOf(k))).count())
                .reduce(0, Long::sum);
    }
}