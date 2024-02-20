import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, -1, 0, 1 };
	private static char[][] map;
	private static boolean[][] visited;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[n][n];
		int normal = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					back(i, j, false);
					normal++;
				}
			}
		}

		visited = new boolean[n][n];
		int special = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					back(i, j, true);
					special++;
				}
			}
		}

		System.out.println(normal + " " + special);
	}

	private static void back(int y, int x, boolean blindness) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x });
		boolean[][] check = new boolean[n][n];
		check[y][x] = true;

		char type = map[y][x];
		boolean isRead = isReadType(y, x);

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int moveY = now[0] + dy[i];
				int moveX = now[1] + dx[i];

				if (!inMap(moveY, moveX) || check[moveY][moveX]) {
					continue;
				}

				if (!blindness) {
					if (map[moveY][moveX] == type) {
						q.offer(new int[] { moveY, moveX });
						check[moveY][moveX] = true;
						visited[moveY][moveX] = true;
					}
				} else {
					if (isReadType(moveY, moveX) == isRead) {
						q.offer(new int[] { moveY, moveX });
						check[moveY][moveX] = true;
						visited[moveY][moveX] = true;
					}
				}
			}
		}
	}

	private static boolean inMap(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}

	private static boolean isReadType(int y, int x) {
		return map[y][x] == 'G' || map[y][x] == 'R';
	}
}