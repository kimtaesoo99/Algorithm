import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int length = set.size();
        int left = 0;
        int right = 0;
        int dis = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            if (map.size() == length) {
                if (dis > right - left) {
                    dis = right - left;
                    resultLeft = left + 1;
                    resultRight = right;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
        }
        return new int[]{resultLeft, resultRight};
    }
}