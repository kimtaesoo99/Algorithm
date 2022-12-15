
import java.util.Arrays;

class Solution {
    public long solution(int order) {
       return Arrays.stream(String.valueOf(order).split(""))
               .filter("369"::contains).count();
    }
}