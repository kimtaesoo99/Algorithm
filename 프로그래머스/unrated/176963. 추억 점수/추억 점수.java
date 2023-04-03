import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for (String[] str : photo) {
            int sum = 0;
            for (String s : str) {
                if (map.containsKey(s)) {
                    sum += map.get(s);
                }
            }
            list.add(sum);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}