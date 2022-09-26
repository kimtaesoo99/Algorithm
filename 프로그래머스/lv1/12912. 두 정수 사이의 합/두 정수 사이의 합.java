
public class Solution {
    public long solution(int a, int b) {
        long answer =0;
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        
        for (int i = y; i <= x; i++) {
                answer += i;
            }
        
        return answer;
    }
}