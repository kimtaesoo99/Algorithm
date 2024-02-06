import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	private static final List<String> operation = Arrays.asList("/", "*", "+", "-");

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());

			Node[] nodes = new Node[n + 1];
			int check = 1;
			
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				int left = 0;
				int right = 0;
				if (st.hasMoreTokens()) {
					if(!operation.contains(value)) {
						check = 0;
					}
					left = Integer.parseInt(st.nextToken());
				} else {
					if(operation.contains(value)) {
						check = 0;
					}
				}
				if (st.hasMoreElements()) {
					right = Integer.parseInt(st.nextToken());
				}

				nodes[i] = new Node(num, value, left, right);
			}

			sb.append("#").append(test_case).append(" ").append(check).append("\n");
		}
		System.out.println(sb);
	}
}

class Node {
	int num;
	String value;
	int left;
	int right;

	public Node(int num, String value, int left, int right) {
		super();
		this.num = num;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}