import java.util.PriorityQueue;

class Solution {
    private int result = 0;

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> times = new PriorityQueue<>();

        for (String time : timetable) {
            String[] info = time.split(":");
            times.offer(Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]));
        }

        for (int i = 0; i < n; i++) {
            int startTime = (9 * 60) + (i * t);

            int minTime = 0;
            int pollCount = 0;
            for (int j = 0; j < m; j++) {
                if (!times.isEmpty() && times.peek() <= startTime) {
                    minTime = times.poll();
                    pollCount++;
                }
            }
            if (pollCount == m) {
                result = minTime - 1;
            } else {
                result = startTime;
            }
        }

        String hour = String.valueOf(result / 60);
        String min = String.valueOf(result % 60);

        return (hour.length() == 1 ? "0" : "") + hour + ":" + (min.length() == 1 ? "0" : "") + min;
    }
}