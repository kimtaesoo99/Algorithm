import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static List<Integer> result;
	private static int maxDepth;
	private static boolean[] visited;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int test = 1; test <= 10; test++) {
			result = new ArrayList<>();
			maxDepth = 0;
			list = new ArrayList[101];
			visited = new boolean[101];

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			back(m);

			sb.append("#").append(test).append(" ").append(result.stream().max((o1, o2) -> o1 - o2).get()).append("\n");
		}
		System.out.println(sb);
	}

	private static void back(int now) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { now, 0 });
		visited[now] = true;

		while (!q.isEmpty()) {
			int[] value = q.poll();

			if (maxDepth < value[1]) {
				maxDepth = value[1];
				result.clear();
				result.add(value[0]);
			} else if (maxDepth == value[1]) {
				result.add(value[0]);
			}

			for (int next : list[value[0]]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[] { next, value[1] + 1 });
				}
			}
		}
	}
}