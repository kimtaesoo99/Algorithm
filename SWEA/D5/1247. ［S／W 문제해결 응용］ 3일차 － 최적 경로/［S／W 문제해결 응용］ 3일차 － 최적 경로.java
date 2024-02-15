import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	private static int result;
	private static int endX;
	private static int endY;
	private static int n;
	private static boolean[] visited;
	private static Location[] locations;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			n = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			locations = new Location[n];
			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				locations[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			back(0, startX, startY, 0);

			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void back(int index, int x, int y, int sum) {
		if (index == n) {
			result = Math.min(result, sum + Math.abs(x - endX) + Math.abs(y - endY));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				back(index + 1, locations[i].x, locations[i].y,
						sum + Math.abs(x - locations[i].x) + Math.abs(y - locations[i].y));
				visited[i] = false;
			}
		}
	}
}

class Location {

	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}