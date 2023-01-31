import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public long solution(int i, int j, int k) {
        return Arrays.stream(IntStream.rangeClosed(i,j)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining())
                .split(""))
                .filter(s->s.equals(String.valueOf(k)))
                .count();
    }
}