import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static long answer = 0;

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        while (n != 0) {
            pq.offer(pq.poll() - 1);
            n--;
        }
        if (pq.peek() <= 0) {
            return 0;
        }
        pq.forEach(i -> answer += Math.pow(i, 2));
        return answer;
    }
}