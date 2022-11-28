import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> marathon = new HashMap<>();
        for (String name : participant){
            marathon.put(name,marathon.getOrDefault(name,0)+1);
        }
        for (String name : completion){
            marathon.put(name,marathon.get(name)-1);
        }

        return marathon.entrySet().stream().map(Map.Entry::getKey).filter(i ->marathon.get(i)!=0).findAny().orElse("");
    }
}