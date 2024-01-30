import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dy = { 0, 0, -1 };
	private static int[] dx = { -1, 1, 0 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine(); // 의미없는값

			map = new int[100][100];
			visited = new boolean[100][100];

			int startY = 0;
			int startX = 0;

			for (int i = 0; i < 100; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if (map[i][j] == 2) {
						startY = i;
						startX = j;
					}
				}
			}

			int[] now = { startY, startX };

			while (true) {
				if (now[0] == 0) {
					break;
				}
				now = find(now);
			}
			sb.append("#").append(test_case).append(" ").append(now[1]).append("\n");
		}
		System.out.println(sb);
	}

	private static int[] find(int[] index) {
		for (int i = 0; i < 3; i++) {
			int moveY = index[0] + dy[i];
			int moveX = index[1] + dx[i];

			if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map.length) {
				if (map[moveY][moveX] == 1 && !visited[moveY][moveX]) {
					visited[moveY][moveX] = true;
					return new int[] { moveY, moveX };
				}
			}
		}

		return null;
	}
}