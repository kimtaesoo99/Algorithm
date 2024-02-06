import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		String[][] map = new String[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = st.nextToken();
			}
		}

		int decrease = Math.min(n, m) / 2;
		decrease = Math.min(n, m) % 2 == 1 ? decrease + 1 : decrease;

		for (int i = 0; i < decrease; i++) {
			rotate(n - i, m - i, r, map, i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + (j == m - 1 ? "" : " "));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void rotate(int n, int m, int r, String[][] map, int s) {
		int total = 2 * (n - 1 - s) + 2 * (m - 1 - s);
		int rotateCount = r % total;

		Deque<String> d = new ArrayDeque<>();

		for (int i = s; i < m; i++) {
			d.offerFirst(map[s][i]);
		}

		d.pollFirst();

		for (int i = s; i < n; i++) {
			d.offerFirst(map[i][m - 1]);
		}

		d.pollFirst();

		for (int i = m - 1; i >= s; i--) {
			d.offerFirst(map[n - 1][i]);
		}

		d.pollFirst();

		for (int i = n - 1; i >= s; i--) {
			d.offerFirst(map[i][s]);
		}

		d.pollFirst();

		for (int i = 0; i < rotateCount; i++) {
			d.offerFirst(d.pollLast());
		}

		for (int i = s; i < m; i++) {
			map[s][i] = d.pollLast();
		}

		for (int i = s + 1; i < n; i++) {
			map[i][m - 1] = d.pollLast();
		}

		if (d.isEmpty()) {
			return;
		}

		for (int i = m - 2; i >= s; i--) {
			map[n - 1][i] = d.pollLast();
		}

		if (d.isEmpty()) {
			return;
		}

		for (int i = n - 2; i > s; i--) {
			map[i][s] = d.pollLast();
		}
	}
}