import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<int[]> stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine()), score = 0;
		int[] curTask = {0, 0};
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			
			//Add task & Store curTask to stack if curTask exists
			if (op == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				if (curTask[1] > 0) {
					stack.addLast(curTask);
				}
				curTask = new int[] {A, T};
			}
			
			//Restart last stored task if there is no task
			if (curTask[1] == 0 && !stack.isEmpty()) {
				curTask = stack.removeLast();
			}
			
			//Work
			if (curTask[1] > 0 && --curTask[1] == 0) {
				score += curTask[0];
			}
		}
		System.out.println(score);
	}
	
}