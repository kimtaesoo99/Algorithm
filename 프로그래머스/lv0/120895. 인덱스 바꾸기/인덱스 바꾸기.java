import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());
        String first = list.get(num1);
        String second = list.get(num2);
        list.add(num2,first);
        list.add(num1,second);
        list.remove(num1+1);
        list.remove(num2+1);
        return list.stream().collect(Collectors.joining());
    }
}