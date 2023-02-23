import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int count = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        if(count/2 > set.size())return set.size();
        
        return count/2;
    }
}