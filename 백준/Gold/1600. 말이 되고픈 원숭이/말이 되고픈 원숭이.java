import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] my = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private static int[] mx = { 1, 2, 2, 1, -1, -2, -2, -1 };

	private static int[][] map;
	private static int k;
	private static int w;
	private static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Deque<int[]> d = new ArrayDeque<>();
		d.offer(new int[] { 0, 0, 0, 0 }); // y, x, k, count
		boolean[][][] visited = new boolean[h][w][k + 1];
		visited[0][0][0] = true;

		while (!d.isEmpty()) {
			int[] now = d.poll();

			if (now[0] == h - 1 && now[1] == w - 1) {
				return now[3];
			}

			if (now[2] < k) {
				for (int i = 0; i < 8; i++) {
					int moveY = now[0] + my[i];
					int moveX = now[1] + mx[i];

					if (inMap(moveY, moveX) && map[moveY][moveX] == 0 && !visited[moveY][moveX][now[2] + 1]) {
						visited[moveY][moveX][now[2] + 1] = true;
						d.offer(new int[] { moveY, moveX, now[2] + 1, now[3] + 1 });
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int moveY = now[0] + dy[i];
				int moveX = now[1] + dx[i];

				if (inMap(moveY, moveX) && map[moveY][moveX] == 0 && !visited[moveY][moveX][now[2]]) {
					visited[moveY][moveX][now[2]] = true;
					d.offer(new int[] { moveY, moveX, now[2], now[3] + 1 });
				}
			}
		}

		return -1;
	}

	private static boolean inMap(int y, int x) {
		return 0 <= y && y < h && 0 <= x && x < w;
	}
}