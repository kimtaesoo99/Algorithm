import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start, int end) {
            return IntStream.rangeClosed(start, end).toArray();
    }
}