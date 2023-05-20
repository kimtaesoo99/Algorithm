import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static ArrayList<Integer>[] list;
    static int[] result;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        list = new ArrayList[n + 1];
        result = new int[sources.length];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 0; i < sources.length; i++) {
            result[i] = bfs(sources[i], destination);
        }
        return result;
    }

    private int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }
        int[] dis = new int[list.length];
        dis[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if (next == end) {
                    return dis[now];
                }
                if (dis[next] == 0) {
                    q.offer(next);
                    dis[next] = dis[now] + 1;
                }
            }
        }
        return -1;
    }
}