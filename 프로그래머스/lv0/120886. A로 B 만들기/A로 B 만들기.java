import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < before.length(); i++){
            map.put(before.charAt(i),map.getOrDefault(before.charAt(i),0)+1);
            map.put(after.charAt(i),map.getOrDefault(after.charAt(i),0)-1);
        }
        for (Integer value : map.values()) {
            if (value!=0)return 0;
        }
        return 1;
    }
}