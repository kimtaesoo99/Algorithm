import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int t : truck_weights) {

            while (true) {
                if (q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if (sum + t > weight) {
                        time++;
                        q.offer(0);
                    } else {
                        q.offer(t);
                        sum += t;
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}