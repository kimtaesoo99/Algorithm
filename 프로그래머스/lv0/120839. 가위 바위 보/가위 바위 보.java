import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        List<String> my = List.of("0","2","5");
        List<String> win = List.of("5","0","2");
        return Arrays.stream(rsp.split("")).map(i -> win.get(my.indexOf(i))).collect(Collectors.joining());
    }
}