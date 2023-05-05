import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            times[i][0] = startTime;
            String[] end = book_time[i][1].split(":");
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            times[i][1] = endTime;
        }
        Arrays.sort(times, (s1, s2) -> {
            if (s1[0] > s2[0]) {
                return 1;
            } else if (s1[0] < s2[0]) {
                return -1;
            } else {
                if (s1[1] > s2[1]) return 1;
                return -1;
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int[] time : times) {
            if (q.isEmpty()) {
                q.add(time[1]);
                continue;
            }
            if (time[0] >= q.peek()) {
                q.poll();
            }
            q.add(time[1]);
        }

        return q.size();
    }
}