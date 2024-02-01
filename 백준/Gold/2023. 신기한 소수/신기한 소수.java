import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		findResult(0, n);
		System.out.println(sb);
	}

	private static void findResult(int num, int n) {
		if (n == 0) {
			if (isPrime(num)) {
				sb.append(num).append("\n");
				return;
			}
		}

		for (int i = 0; i < 10; i++) {
			int next = num * 10 + i;
			if (isPrime(next)) {
				findResult(next, n - 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}