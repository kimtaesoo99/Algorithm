import java.util.Arrays;

class Solution {
    public long solution(int[] array) {
        return Arrays.stream(array)
                .mapToObj(i -> (Arrays.stream(String.valueOf(i).split(""))
                        .filter(s -> s.equals("7")).count())).reduce(0l, (x, y) -> x + y);
    }
}