import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new LinkedList[n + 1];
		int[] count = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			count[to]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (count[i] == 0) {
				q.add(i);
				sb.append(i).append(" ");
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				count[next]--;
				if (count[next] == 0) {
					q.offer(next);
					sb.append(next).append(" ");
				}
			}
		}
		
		System.out.println(sb);

	}
}