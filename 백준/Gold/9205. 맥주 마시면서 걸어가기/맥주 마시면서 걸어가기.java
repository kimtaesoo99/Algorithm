import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    private static int n;
    private static List<Location> locations;
    private static boolean can;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            can = false;
            locations = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                String[] line = br.readLine().split(" ");
                locations.add(new Location(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }

            visited = new boolean[n + 2];

            bfs(locations.get(0), locations.get(n + 1));

            sb.append(can ? "happy" : "sad").append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(Location start, Location end) {
        Deque<Location> q = new ArrayDeque<>();
        q.offer(start);
        visited[0] = true;

        while (!q.isEmpty()) {
            Location now = q.poll();

            if (canGo(now, end)) {
                can = true;
                return;
            }

            for (int i = 1; i <= n + 1; i++) {
                Location next = locations.get(i);
                if (canGo(now, next) && !visited[i]) {
                    q.offer(next);
                    visited[i] = true;
                }
            }
        }
    }

    private static boolean canGo(Location now, Location target) {
        return Math.abs(now.y - target.y) + Math.abs(target.x - now.x) <= 1000;
    }
}

class Location {

    int y;
    int x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }
}