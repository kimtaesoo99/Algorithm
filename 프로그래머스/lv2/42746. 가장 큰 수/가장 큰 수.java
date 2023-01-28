import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<String> result = Arrays.stream(numbers).mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).collect(Collectors.toList());
        return result.get(0).equals("0")?"0": String.join("", result);
    }
}