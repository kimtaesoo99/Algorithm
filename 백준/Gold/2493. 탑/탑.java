import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<int[]> s = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());

			while (!s.isEmpty()) {
				if (s.peekLast()[0] > value) {
					sb.append(s.peekLast()[1]).append(" ");
					s.add(new int[] { value, i });
					break;
				} else {
					s.pollLast();
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