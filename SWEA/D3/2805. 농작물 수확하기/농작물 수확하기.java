import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int result = 0;

			for (int i = 0; i < n; i++) {
				int value = Math.abs(n / 2 - i);
				result += sum(map, i, value, n - 2 * value);
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static int sum(int[][] map, int x, int index, int num) {
		int count = 0;

		for (int i = index; i < index + num; i++) {
			count += map[i][x];
		}

		return count;
	}
}