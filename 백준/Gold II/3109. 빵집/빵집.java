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
			start(i, 0);
		}

		int result = 0;

		for (int i = 0; i < ySize; i++) {
			if (map[i][xSize - 1] == 'o') {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void start(int y, int x) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[1] == o1[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});

		q.offer(new int[] { y, x });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[1] == xSize - 1) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int moveY = now[0] + dy[i];
				int moveX = now[1] + 1;

				if (0 <= moveY && moveY < ySize && 0 <= moveX && moveX < xSize) {
					if (map[moveY][moveX] == '.') {
						map[moveY][moveX] = 'o';
						q.offer(new int[] { moveY, moveX });
						q.offer(new int[] { moveY, moveX });
						q.offer(new int[] { moveY, moveX });
						break;
					}
				}
			}
		}
	}
}