import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

	private static int[][] map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			String command = st.nextToken();
			if (command.equals("1")) {
				changeUpAndDown();
			} else if (command.equals("2")) {
				changeLeftAndRight();
			} else if (command.equals("3")) {
				rotateRight();
			} else if (command.equals("4")) {
				rotateLeft();
			} else if (command.equals("5")) {
				moveRight();
			} else if (command.equals("6")) {
				moveLeft();
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

	private static void changeUpAndDown() {
		Deque<Integer> d = new ArrayDeque<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}

		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void changeLeftAndRight() {
		Deque<Integer> d = new ArrayDeque<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollFirst();
			}
		}
	}

	private static void rotateRight() {
		Deque<Integer> d = new ArrayDeque<>();

		for (int j = 0; j < map[0].length; j++) {
			for (int i = map.length - 1; i >= 0; i--) {
				d.offerFirst(map[i][j]);
			}
		}

		map = new int[map[0].length][map.length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void rotateLeft() {
		rotateRight();
		rotateRight();
		rotateRight();
	}

	private static void moveRight() {
		Deque<Integer> d = new ArrayDeque<>();

		// 1
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 2
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 3
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				d.offerFirst(map[i][j]);
			}
		}
		// 4
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				d.offerFirst(map[i][j]);
			}
		}

		// 2
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 3
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = map[0].length / 2; j < map[0].length; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 4
		for (int i = map.length / 2; i < map.length; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				map[i][j] = d.pollLast();
			}
		}

		// 1
		for (int i = 0; i < map.length / 2; i++) {
			for (int j = 0; j < map[0].length / 2; j++) {
				map[i][j] = d.pollLast();
			}
		}
	}

	private static void moveLeft() {
		moveRight();
		moveRight();
		moveRight();
	}
}