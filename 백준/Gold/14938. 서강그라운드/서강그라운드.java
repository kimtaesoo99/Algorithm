import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	private static int[] gift;
	private static int[][] distances;
	private static int result = 0;
	private static List<Integer>[] list;
	private static Set<Integer> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();

		gift = new int[n];
		distances = new int[n][n];

		for (int i = 0; i < n; i++) {
			gift[i] = sc.nextInt();
		}

		list = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int distance = sc.nextInt();
			list[from].add(to);
			list[to].add(from);
			distances[from][to] = distance;
			distances[to][from] = distance;
		}

		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			backTrack(i, m);
			result = Math.max(calcMax(), result);
		}

		System.out.println(result);
	}

	private static int calcMax() {
		return set.stream().mapToInt(i -> gift[i]).sum();
	}

	private static void backTrack(int now, int dis) {
		set.add(now);
		for (int next : list[now]) {
			if (distances[next][now] <= dis) {
				backTrack(next, dis - distances[next][now]);
			}
		}
	}
}