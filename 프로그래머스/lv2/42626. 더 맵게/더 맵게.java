import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::offer);
        int count = 0;
        while (queue.size()>1 && queue.peek()<K){
            queue.offer(queue.poll() + queue.poll()*2);
            count++;
        }
        return queue.peek() >= K ?count:-1;
    }
}