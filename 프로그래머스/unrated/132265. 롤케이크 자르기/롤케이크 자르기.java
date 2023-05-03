import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        int leftCount = 0;
        
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        int rightCount = 0;

        for (int t : topping) {
            if (!rightMap.containsKey(t)) {
                rightCount++;
            }
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightCount--;
            }
            if (!leftMap.containsKey(t)) {
                leftCount++;
            }
            leftMap.put(t, 1);
            if (rightCount == leftCount) {
                answer++;
            }
        }
        return answer;
    }
}