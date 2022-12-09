import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(String s) {
        Map<Character, Integer> indexAlpha = new HashMap<>();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (!indexAlpha.containsKey(alpha)){
                index.add(-1);
                indexAlpha.put(alpha,i);
                continue;
            }
            index.add(i - indexAlpha.get(alpha));
            indexAlpha.put(alpha,i);
        }
        return index;
    }
}