import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			int remain = Integer.MAX_VALUE;

			for (int i = 0; i < 8; i++) {
				int value = Integer.parseInt(st.nextToken());
				q.add(value);
				remain = Math.min(remain, value / 15);
			}

			for (int i = 0; i < 8; i++) {
				int value = q.poll();
				q.add(value - 15 * (remain - 1));
			}

			int minus = 1;

			while (true) {
				int value = q.poll();
				if (value - minus <= 0) {
					q.add(0);
					break;
				}
				q.add(value - minus++);
				if (minus == 6) {
					minus = 1;
				}
			}

			sb.append("#").append(test_case).append(" ");
			
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}