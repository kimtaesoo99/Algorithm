import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int time = 0;
        for (String city : cities) {
            String lower = city.toLowerCase();
            if (queue.contains(lower)){
                time++;
                queue.remove(lower);
                queue.offer(lower);
            }
            else {
                queue.offer(lower);
                time+=5;
                if (queue.size()>cacheSize)queue.poll();
            }
        }
        return time;
    }
}