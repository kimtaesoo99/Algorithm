import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };
	private static int can;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			can = 0;

			char[][] map = new char[100][100];

			int startY = 0;
			int startX = 0;
			int endY = 0;
			int endX = 0;

			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '2') {
						startY = i;
						startX = j;
					}
					if (map[i][j] == '3') {
						endY = i;
						endX = j;
					}
				}
			}

			bfs(startY, startX, endY, endX, map);
			sb.append("#").append(test_case).append(" ").append(can).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int startY, int startX, int endY, int endX, char[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { startY, startX });
		boolean[][] visited = new boolean[100][100];
		visited[startY][startX] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == endY && now[1] == endX) {
				can = 1;
			}

			for (int i = 0; i < 4; i++) {
				int moveY = now[0] + dy[i];
				int moveX = now[1] + dx[i];

				if (0 <= moveY && moveY < 100 && 0 <= moveX && moveX < 100) {
					if (!visited[moveY][moveX] && map[moveY][moveX] != '1') {
						q.offer(new int[] { moveY, moveX });
						visited[moveY][moveX] = true;
					}
				}
			}
		}
	}
}