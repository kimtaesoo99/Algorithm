import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int temp = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1,o2) -> o2-o1);
			
			for(String s : br.readLine().split(" ")) {
				Integer value = Integer.parseInt(s);
				pq1.add(value);
				pq2.add(value);
			}
			
			for(int i = 0; i < temp; i++) {
				Integer min = pq1.poll();
				Integer max = pq2.poll();
				pq1.remove(max);
				pq2.remove(min);
				pq1.add(max - 1);
				pq1.add(min + 1);
				pq2.add(max - 1);
				pq2.add(min + 1);
			}
			
			sb.append("#").append(test_case).append(" ").append(pq2.poll() - pq1.poll()).append("\n");
		}

		System.out.println(sb);
	}
}