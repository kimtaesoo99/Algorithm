import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] info = br.readLine().split(" ");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);

		arr = new int[m];
		visited = new boolean[n + 1];

		find(0, m , -1);
		
		System.out.println(sb);
	}

	private static void find(int n, int m, int pre) {
		if (n == arr.length) {
			for (int value : arr) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && pre < i) {
				visited[i] = true;
				arr[n] = i;
				find(n + 1, m, i);
				visited[i] = false;
			}
		}
	}
}