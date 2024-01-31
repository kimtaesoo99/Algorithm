import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];

			int count = n + 1;
			int num = 1;

			int x = 0;
			int y = 0;
			map[n / 2][n / 2] = n * n;

			while (true) {
				// 오른쪽
				count -= 2;
				for (int i = 0; i < count; i++) {
					map[y][x++] = num++;
				}

				// 아래
				for (int i = 0; i < count; i++) {
					map[y++][x] = num++;
				}

				// 왼쪽
				for (int i = 0; i < count; i++) {
					map[y][x--] = num++;
				}

				// 위
				for (int i = 0; i < count; i++) {
					map[y--][x] = num++;
				}
				y++;
				x++;
				if (num >= n * n - 1) {
					break;
				}
			}
			
			sb.append("#").append(test).append("\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}