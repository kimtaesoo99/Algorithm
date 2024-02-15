import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	private static int[] dy = { -1, 0, 1 };
	private static int ySize;
	private static int xSize;
	private static char[][] map;
	private static int result;
	private static boolean link;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ySize = Integer.parseInt(st.nextToken());
		xSize = Integer.parseInt(st.nextToken());

		map = new char[ySize][xSize];

		for (int i = 0; i < ySize; i++) {
			String line = br.readLine();
			for (int j = 0; j < xSize; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < ySize; i++) {
			link = false;
			start(i, 0);
		}

		System.out.println(result);
	}

	private static void start(int y, int x) {
		if (x == xSize - 1) {
			result++;
			link = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int moveY = y + dy[i];
			int moveX = x + 1;

			if (0 <= moveY && moveY < ySize && 0 <= moveX && moveX < xSize) {
				if (map[moveY][moveX] == '.') {
					map[moveY][moveX] = 'x';
					start(moveY, moveX);
					if (link) {
						return;
					}
				}
			}
		}
	}
}