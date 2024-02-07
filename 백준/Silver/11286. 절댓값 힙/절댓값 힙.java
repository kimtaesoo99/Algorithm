import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int a1 = Math.abs(o1);
				int a2 = Math.abs(o2);
				if (a1 == a2) {
					return o1 - o2;
				}
				return a1 - a2;
			}
		});

		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			} else {
				pq.offer(value);
			}
		}

		System.out.println(sb);
	}
}