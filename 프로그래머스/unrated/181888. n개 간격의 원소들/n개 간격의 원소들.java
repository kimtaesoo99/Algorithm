import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        return IntStream.rangeClosed(0, num_list.length - 1).filter(i -> i % n == 0).map(i -> num_list[i]).toArray();
    }
}