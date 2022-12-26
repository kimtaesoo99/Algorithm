import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());
        Collections.swap(list,num1,num2);
        return String.join("", list);
    }
}