import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String even = Arrays.stream(num_list)
                .filter(i -> i % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        String odd = Arrays.stream(num_list)
                .filter(i -> i % 2 != 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(even) + Integer.parseInt(odd);
    }
}