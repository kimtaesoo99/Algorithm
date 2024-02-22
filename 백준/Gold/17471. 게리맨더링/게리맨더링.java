import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] values;
	private static boolean[] visited;
	private static int totalSum = 1001;
	private static List<Integer>[] list;
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		values = new int[n + 1];
		visited = new boolean[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		back(0, -1);
		System.out.println(totalSum == 1001 ? -1 : totalSum);
	}

	private static void back(int depth, int pre) {
		if (depth >= n / 2 + 1) {
			return;
		}

		if (depth > 0) {
			totalSum = Math.min(totalSum, getLinkCost());
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && i > pre) {
				visited[i] = true;
				back(depth + 1, i);
				visited[i] = false;
			}
		}
	}

	private static boolean[] check;

	private static int getLinkCost() {
		List<Integer> link = new ArrayList<>();
		List<Integer> unlink = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				link.add(i);
			} else {
				unlink.add(i);
			}
		}

		boolean canLink = find(link.get(0), true, link);
		boolean canUnLink = find(unlink.get(0), false, unlink);

		int a = 0;
		int b = 0;

		if (canLink && canUnLink) {
			for (int i = 1; i <= n; i++) {
				if (visited[i]) {;
					a += values[i];
				} else {
					b += values[i];
				}
			}
			return Math.abs(a - b);
		}

		return 1001;
	}

	private static boolean find(int now, boolean b, List<Integer> l) {
		check = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		q.offer(now);
		check[now] = true;
		result.add(now);

		while (!q.isEmpty()) {
			Integer nowQ = q.poll();
			for (int next : list[nowQ]) {
				if (visited[next] == b && !check[next]) {
					check[next] = true;
					q.add(next);
					result.add(next);
				}
			}
		}

		return result.containsAll(l);
	}
}