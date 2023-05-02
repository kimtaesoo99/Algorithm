import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int now;
        for (int i = 0; i < enemy.length; i++) {
            now = enemy[i];
            q.add(now);
            n -= now;
            if (n < 0) {
                if (k <= 0) {
                    return i;
                }
                while (n < 0) {
                    if (k < 0) {
                        return i;
                    }
                    n += q.poll();
                    k--;
                }
            }
        }
        return enemy.length;
    }
}