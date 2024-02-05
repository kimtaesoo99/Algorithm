import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			List<Integer> list = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}

			int c = sc.nextInt();

			for (int i = 0; i < c; i++) {
				String s = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = x; j < x + y; j++) {
					list.add(j, sc.nextInt());
				}
			}
			sb.append("#").append(test_case);

			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}