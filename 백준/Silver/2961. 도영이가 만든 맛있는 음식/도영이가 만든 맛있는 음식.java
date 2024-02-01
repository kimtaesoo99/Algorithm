import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] s;
	private static int[] b;
	private static int n;
	private static int result = 1_000_000_000;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		s = new int[n];
		b = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		cook(0, 1, 0, 0);

		System.out.println(result);
	}

	private static void cook(int index, int sSum, int bSum, int chooseCnt) {
		if (index == n) {
			if (chooseCnt != 0) {
				result = Math.min(result, Math.abs(sSum - bSum));
			}
			return;
		}

		cook(index + 1, sSum * s[index], bSum + b[index], chooseCnt + 1);
		cook(index + 1, sSum, bSum, chooseCnt);
	}
}