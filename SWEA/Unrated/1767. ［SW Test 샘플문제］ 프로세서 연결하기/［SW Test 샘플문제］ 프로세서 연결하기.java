import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	private static List<int[]> targets;
	private static int maxLink;
	private static int minCount = Integer.MAX_VALUE;
	private static int[][] map;

	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			maxLink = 0;
			minCount = Integer.MAX_VALUE;
			map = new int[n][n];

			targets = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					if (map[i][j] == 1) {
						targets.add(new int[] { i, j });
					}
				}
			}

			back(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(minCount).append("\n");
		}
		System.out.println(sb);
	}

	private static void back(int index, int link, int count) {
		if (index == targets.size()) {
			if (link > maxLink) {
				maxLink = link;
				minCount = count;
			} else if (link == maxLink && minCount > count) {
				minCount = count;
			}
			return;
		}

		int[] info = targets.get(index);

		if (info[0] == 0 || info[1] == 0 || info[0] == map.length - 1 || info[1] == map.length - 1) {
			back(index + 1, link + 1, count);
		} else {
			for (int i = 0; i < 4; i++) {

				int moveY = info[0] + dy[i];
				int moveX = info[1] + dx[i];

				List<int[]> change = new LinkedList<>();
				boolean can = true;

				while (0 <= moveX && moveX < map.length && 0 <= moveY && moveY < map.length) {
					if (map[moveY][moveX] == 0) {
						map[moveY][moveX] = 2;
						change.add(new int[] { moveY, moveX });
						moveY += dy[i];
						moveX += dx[i];

					} else {
						can = false;
						break;
					}
				}

				if (can) {
					back(index + 1, link + 1, count + change.size());
				}

				for (int j = 0; j < change.size(); j++) {
					int[] m = change.get(j);
					map[m[0]][m[1]] = 0;
				}
			}
		}

		if (maxLink > link + targets.size() - index) {
			return;
		}
		back(index + 1, link, count);
	}
}