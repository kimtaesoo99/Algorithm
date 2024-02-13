import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	private static int winCount;
	private static int loseCount;
	private static int[] arr;
	private static boolean[] visited;
	private static boolean[] get;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			winCount = 0;
			loseCount = 0;
			get = new boolean[19]; // 규영이가 가지고 있는지
			arr = new int[10]; // 규영이 카드
			visited = new boolean[19]; // 한번 선택한 적이 있는지

			for (int i = 1; i < 10; i++) {
				int value = Integer.parseInt(st.nextToken());
				get[value] = true;
				arr[i] = value;
			}

			search(1, 0, 0);
			sb.append("#").append(test).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
		}
		System.out.println(sb);
	}

	private static void search(int index, int sum1, int sum2) {
		if (index == 10) {
			if (sum1 > sum2) {
				winCount++;
			} else if (sum1 < sum2) {
				loseCount++;
			}
			return;
		}

		for (int i = 1; i <= 18; i++) {
			if (!get[i] && !visited[i]) {
				visited[i] = true;
				if (arr[index] > i) {
					search(index + 1, sum1 + arr[index] + i, sum2);
				} else {
					search(index + 1, sum1, sum2 + arr[index] + i);
				}
				visited[i] = false;
			}
		}
	}
}