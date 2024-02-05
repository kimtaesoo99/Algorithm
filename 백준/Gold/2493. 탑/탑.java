import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<int[]> s = new Stack<>();

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());

			while (!s.isEmpty()) {
				if (s.peek()[0] > value) {
					sb.append(s.peek()[1]).append(" ");
					s.add(new int[] { value, i });
					break;
				} else {
					s.pop();
				}
			}

			if (s.isEmpty()) {
				s.add(new int[] { value, i });
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb);
	}
}