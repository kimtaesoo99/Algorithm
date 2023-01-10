import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::offer);
        int count = 0;
        while (true){
            Integer min = queue.poll();
            Integer secondMin = queue.poll();
            if (min == null)return -1;
            if (min>=K)break;
            if (secondMin == null) return -1;
            queue.offer(min + secondMin*2);
            count++;
        }
        return count;
    }
}