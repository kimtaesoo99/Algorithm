import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	private static int r;
	private static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		back(n, 0, 0, 0);
	}

	private static void back(int size, int x, int y, int sum) {
		if (size == 1) {
			if (x == c && y == r) {
				System.out.println(sum);
				return;
			}
		}

		if (!inMap(x, y, size)) {
			return;
		}

		int nextSize = size / 2;

		back(nextSize, x, y, sum);
		back(nextSize, x + nextSize, y, sum + size * size / 4 * 1);
		back(nextSize, x, y + nextSize, sum + size * size / 4 * 2);
		back(nextSize, x + nextSize, y + nextSize, sum + size * size / 4 * 3);
	}

	private static boolean inMap(int x, int y, int size) {
		return x <= c && c < x + size && y <= r && r < y + size;
	}
}