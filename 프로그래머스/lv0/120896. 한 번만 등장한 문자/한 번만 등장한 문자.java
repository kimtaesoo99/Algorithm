import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(s.split(""))
                .forEach(i -> map.put(i ,map.getOrDefault(i,0)+1));
        return map.keySet().stream()
                .filter(i -> map.get(i) == 1)
                .sorted()
                .collect(Collectors.joining());
    }
}