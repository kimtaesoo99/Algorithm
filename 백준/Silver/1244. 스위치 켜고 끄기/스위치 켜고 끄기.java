import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];

		String[] str = br.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(str[i - 1]);
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String[] info = br.readLine().split(" ");
			int student = Integer.parseInt(info[0]);
			int num = Integer.parseInt(info[1]);

			if (student == 1) {
				multi(num);
			} else {
				arr[num] = arr[num] == 1 ? 0 : 1;
				symmetric(num);
			}
		}

		for(int i = 1; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void multi(int num) {
		for (int i = num; i < arr.length; i += num) {
			arr[i] = arr[i] == 1 ? 0 : 1;
		}
	}

	private static void symmetric(int num) {
		int pre = num;
		int next = num;
		while (true) {
			pre--;
			next++;

			if (!isCorrectIndex(pre) || !isCorrectIndex(next) || arr[pre] != arr[next]) {
				break;
			}

			arr[pre] = arr[pre] == 1 ? 0 : 1;
			arr[next] = arr[next] == 1 ? 0 : 1;
		}
	}

	private static boolean isCorrectIndex(int value) {
		return 1 <= value && value < arr.length;
	}
}