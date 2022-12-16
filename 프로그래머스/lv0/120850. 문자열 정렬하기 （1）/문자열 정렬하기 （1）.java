import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[^0-9]", "").split(""))
                .sorted().map(Integer::parseInt).collect(Collectors.toList());
    }
}
