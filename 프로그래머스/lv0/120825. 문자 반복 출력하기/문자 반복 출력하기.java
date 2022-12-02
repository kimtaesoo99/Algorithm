
import java.util.Arrays;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(my_string.split(""))
                .forEach(i -> {
                    for (int j = 0; j<n;j++){
                        sb.append(i);
                    }
                });
        return sb.toString();
    }
}
