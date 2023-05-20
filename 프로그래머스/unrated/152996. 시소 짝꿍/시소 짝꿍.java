import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    static long answer = 0;

    public long solution(int[] weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        map.entrySet().stream().sorted(Entry.comparingByKey())
                .forEach(i -> {
                    while (i.getValue() != 0) {
                        map.put(i.getKey(), map.get(i.getKey()) - 1);
                        checkPartner(i.getKey(), map);
                    }
                });
        return answer;
    }

    private void checkPartner(int standard, HashMap<Integer, Integer> map) {
        if (map.containsKey(standard)) {
            answer += map.get(standard);
        }
        if (map.containsKey(standard / 2 * 3) && standard % 2 == 0) {
            answer += map.get(standard / 2 * 3);
        }
        if (map.containsKey(standard / 3 * 4) && standard % 3 == 0) {
            answer += map.get(standard / 3 * 4);
        }
        if (map.containsKey(standard * 2)) {
            answer += map.get(standard * 2);
        }
    }
}