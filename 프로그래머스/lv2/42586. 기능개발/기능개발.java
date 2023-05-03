import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int left = (100 - progresses[i]);
            int day = left / speeds[i];
            if (left % speeds[i] != 0) {
                day++;
            }
            q.offer(day);
        }

        List<Integer> result = new ArrayList<>();
        int index = -1;
        int max = -1;
        while (!q.isEmpty()) {
            if (q.peek() > max) {
                int poll = q.poll();
                result.add(1);
                max = poll;
                index++;
                continue;
            }
            result.set(index, result.get(index) + 1);
            q.poll();
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}