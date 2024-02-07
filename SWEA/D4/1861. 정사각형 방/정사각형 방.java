import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };
	private static boolean[][] visited;
	private static int[][] map;
	private static int result;
	private static int room;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			visited = new boolean[n][n];
			result = 0;
			room = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(i, j, n);
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(room).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int y, int x, int n) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x });
		boolean[][] check = new boolean[n][n];
		check[y][x] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int moveY = now[0] + dy[i];
				int moveX = now[1] + dx[i];
				if (isCorrectIndex(moveY, moveX, n) && !check[moveY][moveX]) {
					if (map[moveY][moveX] - map[now[0]][now[1]] == 1) {
						q.offer(new int[] { moveY, moveX });
						check[moveY][moveX] = true;
						visited[moveY][moveX] = true;
						count++;
					}
				}
			}
		}
		if(result < count ||(result == count && room > map[y][x])) {
			result = count;
			room = map[y][x];
		} 
	}

	private static boolean isCorrectIndex(int y, int x, int n) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}