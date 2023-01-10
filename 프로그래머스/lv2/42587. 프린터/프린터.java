import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(priorities).forEach(queue::offer);

        while (!queue.isEmpty()){
            int max = Collections.max(queue);
            int print = queue.poll();
            if (location==0){
                if (max == print){
                    return priorities.length - queue.size();
                }
                queue.offer(print);
                location = queue.size()-1;
            }else {
                location-=1;
                if (max!=print)queue.offer(print);
            }
        }
        return priorities.length;
    }
}