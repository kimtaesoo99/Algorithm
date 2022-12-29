import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .map(i -> {
                    if (i.toLowerCase().equals(i)) {
                        return i.toUpperCase();
                    }
                    return i.toLowerCase();
                }).collect(Collectors.joining());
    }
}