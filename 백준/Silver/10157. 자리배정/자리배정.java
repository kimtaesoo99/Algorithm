import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int x = Integer.parseInt(info[0]);
        int y = Integer.parseInt(info[1]);

        int n = Integer.parseInt(br.readLine());

        if (x * y < n) {
            System.out.println(0);
            System.exit(0);
        }

        int nowX = 0;
        int nowY = 0;
        int dir = 0;

        boolean[][] visited = new boolean[y][x];
        visited[0][0] = true;
        n--;

        while (n !=  0) {
            int moveX = nowX + dx[dir];
            int moveY = nowY + dy[dir];

            if (0 <= moveX && moveX < x && 0 <= moveY && moveY < y && !visited[moveY][moveX]) {
                nowX = moveX;
                nowY = moveY;
                visited[nowY][nowX] = true;
            } else {
                dir++;
                if (dir > 3) {
                    dir = 0;
                }
                n++;
            }

            n--;
        }

        System.out.println((nowX + 1) + " " + (nowY  + 1));
    }
}
