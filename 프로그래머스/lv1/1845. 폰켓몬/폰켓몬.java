import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> pocket = new HashMap<>();
        for (int p : nums){
            pocket.put(p,1);
        }
        return (int) Math.min((long) pocket.entrySet().size(),nums.length/2);
    }
}
