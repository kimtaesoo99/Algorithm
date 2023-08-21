import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[][] jobs) {
        ArrayList<Node> list = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.workTime));

        for (int[] job : jobs) {
            list.add(new Node(job[0], job[1]));
        }

        list.sort(Comparator.comparingInt(o -> o.startTime));

        int time = 0;
        int count = 0;
        int answer = 0;

        while (count != jobs.length) {
            while (!list.isEmpty() && list.get(0).startTime <= time) {
                pq.add(list.remove(0));
            }

            if (!pq.isEmpty()) {
                Node a = pq.poll();
                time += a.workTime;
                answer += time - a.startTime;
                count++;
            } else {
                time++;
            }
        }

        return answer / jobs.length;
    }
}

class Node {
    int startTime;
    int workTime;

    Node(int startTime, int workTime) {
        this.startTime = startTime;
        this.workTime = workTime;
    }
}