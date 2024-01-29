import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();

			int count = 0;

			char pre = '2';

			for (int i = str.length() - 1; i >= 0; i--) {
				char c = str.charAt(i);
				if (c != pre) {
					pre = c;
					count++;
				}
			}
			
			if(str.charAt(0) == '0') {
				count--;
			}
			
			System.out.println("#" + test_case + " " + count );
		}
	}
}