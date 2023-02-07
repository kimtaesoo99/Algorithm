import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][][] visited = new boolean[N][M][2];

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(0, 0, 1, false));

        while (!q.isEmpty()) {

            Location poll = q.poll();

            if (poll.y == N - 1 && poll.x == M - 1) {
                System.out.println(poll.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = poll.y + dy[i];
                int moveX = poll.x + dx[i];

                if (0 <= moveY && moveY < N && 0 <= moveX && moveX < M) {
                    if (map[moveY][moveX] == '0' && !poll.breakWall && !visited[moveY][moveX][0]) {
                        q.offer(new Location(moveY, moveX, poll.count + 1, false));
                        visited[moveY][moveX][0] = true;
                    } else if (map[moveY][moveX] == '0' && poll.breakWall && !visited[moveY][moveX][1]) {
                        q.offer(new Location(moveY, moveX, poll.count + 1, true));
                        visited[moveY][moveX][1] = true;
                    } else if (map[moveY][moveX] == '1' && !poll.breakWall && !visited[moveY][moveX][1]) {
                        q.offer(new Location(moveY, moveX, poll.count + 1, true));
                        visited[moveY][moveX][1] = true;
                    }
                }

            }
        }
        System.out.println(-1);
    }
}

class Location {
    public int y;
    public int x;
    public int count;
    public boolean breakWall;

    public Location(int y, int x, int count, boolean breakWall) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.breakWall = breakWall;
    }
}
