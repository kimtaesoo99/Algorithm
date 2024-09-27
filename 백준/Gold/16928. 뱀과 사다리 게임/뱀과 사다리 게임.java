import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 1));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            // 주사위 1~6까지 던지기
            for (int i = 1; i <= 6; i++) {
                int cur = info.idx + i;

                if (cur == 100) {
                    return info.cnt + 1;
                }

                if (cur > 100 || visited[cur]) {
                    continue;
                }

                Integer num = map.getOrDefault(cur, 0);
                
                if (map.containsKey(cur)) {
                    queue.offer(new Info(info.cnt + 1, num));
                } else {
                    queue.offer(new Info(info.cnt + 1, cur));
                }
                visited[cur] = true;
            }
        }
        return -1;
    }
}

class Info {
    int cnt;
    int idx;

    public Info(int cnt, int idx) {
        this.cnt = cnt;
        this.idx = idx;
    }
}