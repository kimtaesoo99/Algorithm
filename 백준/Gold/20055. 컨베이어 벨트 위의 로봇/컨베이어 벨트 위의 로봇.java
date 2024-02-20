import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> conver = new LinkedList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * n; i++) {
			conver.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> robots = new LinkedList<>();

		int result = 1;
		int count = 0;

		while (true) {
			conver.add(0, conver.remove(2 * n - 1)); // 마지막을 첫번째로 이동

			// 로봇 1칸씩 이동
			for (int i = 0; i < robots.size(); i++) {
				robots.set(i, robots.get(i) + 1);
			}

			// 로봇 스스로 이동
			for (int i = 0; i < robots.size(); i++) {
				if (robots.get(i) >= n - 1) {
					robots.set(i, robots.get(i) + 1); // 밸트는 내구도 감소 시키지 않음 값만 증가
					continue; // 이미 끝점
				}
				if ((i == 0 || robots.get(i - 1) > robots.get(i) + 1) && conver.get(robots.get(i) + 1) > 0) {
					robots.set(i, robots.get(i) + 1); // 로봇 이동
					conver.set(robots.get(i), conver.get(robots.get(i)) - 1); // 밸트 내구도 감소
					if (conver.get(robots.get(i)) == 0) {
						count++;
					}
				}
			}

			// 로봇 올리기
			if (conver.get(0) > 0) {
				conver.set(0, conver.get(0) - 1);
				robots.add(0);
				if (conver.get(0) == 0) {
					count++;
				}
			}

			// 로봇 제거
			for (int i = robots.size() - 1; i >= 0; i--) {
				if (robots.get(i) >= n - 1) {
					robots.remove(i);
				}
			}

			if (k <= count) {
				break;
			}
			result++;
		}

		System.out.println(result);
	}
}