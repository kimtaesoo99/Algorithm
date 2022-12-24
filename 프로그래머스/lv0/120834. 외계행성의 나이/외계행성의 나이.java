import java.util.stream.Collectors;

class Solution {
    public String solution(int age) {
        return String.valueOf(age).chars()
                .mapToObj(o -> String.valueOf((char)(49+o))).collect(Collectors.joining());
    }
}