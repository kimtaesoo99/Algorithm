
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int removeCount = tangerine.length - k;
        List<Integer> values = map.entrySet().stream().sorted(Entry.comparingByValue()).map(i -> i.getValue())
                .collect(Collectors.toList());
        int result = values.size();
        for (int v : values){
            if (removeCount<v)break;
            else if (removeCount == v) {
                removeCount = 0;
                result--;
            }else {
                removeCount = removeCount - v;
                result--;
            }
        }

        return result;
    }
}