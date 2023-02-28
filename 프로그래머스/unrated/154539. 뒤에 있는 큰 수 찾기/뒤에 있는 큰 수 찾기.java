import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result,-1);
        Stack<int[]> q = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            int now = numbers[i];
            while(!q.isEmpty() &&q.peek()[1] <now){
                int[] poll = q.pop();
                result[poll[0]] = now;
            }
            q.add(new int[]{i,now});
        }
        return result;
    }
}