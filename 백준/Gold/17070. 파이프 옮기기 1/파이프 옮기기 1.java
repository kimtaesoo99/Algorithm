import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] dy = { 0, 1, 1 };
	private static int[] dx = { 1, 1, 0 };
	private static int[][] map;
	private static int n;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(count);
	}

	private static void dfs(int y, int x, int nowDir) {
		if (y == n - 1 && x == n - 1) {
			count++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int moveY = y + dy[i];
			int moveX = x + dx[i];

			if (can(y, x, i, nowDir)) {
				dfs(moveY, moveX, i);
			}
		}
	}

	private static boolean can(int y, int x, int dir, int nowDir) {
		if (Math.abs(dir - nowDir) > 1) {
			return false;
		}

		if (dir != 1) {
			return canMove(y, x, dir);
		} else {
			for (int i = 0; i < 3; i++) {
				if (!canMove(y, x, i)) {
					return false;
				}
			}
			return true;
		}
	}

	private static boolean canMove(int y, int x, int dir) {
		return inMap(y + dy[dir], x + dx[dir]) && map[y + dy[dir]][x + dx[dir]] == 0;
	}

	private static boolean inMap(int y, int x) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
}