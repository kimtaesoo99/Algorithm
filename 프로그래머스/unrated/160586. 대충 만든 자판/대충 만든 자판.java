import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> result = new ArrayList<>();

        for (String target : targets) {
            int count = 0;
            for (int i = 0; i < target.length(); i++) {
                char alpha = target.charAt(i);
                int minCost = 100000;
                for (String key : keymap) {
                    int cost = key.indexOf(alpha);
                    if (cost != -1) {
                        minCost = Math.min(minCost, cost + 1);
                    }
                }
                count += minCost;
            }
            if (count >= 100000) {
                result.add(-1);
            } else {
                result.add(count);
            }
        }
        return result;
    }
}