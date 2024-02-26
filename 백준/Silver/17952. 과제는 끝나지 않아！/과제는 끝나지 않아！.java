import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Deque<Task> d = new ArrayDeque<>();
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) {
				if(!d.isEmpty()) {
					d.peekLast().remain--;
					if(d.peekLast().remain == 0) {
						result += d.pollLast().value;
					} 
				}
			} else {
				int value = Integer.parseInt(st.nextToken());
				int remain = Integer.parseInt(st.nextToken());
				if(remain == 1) {
					result += value;
				} else {
					d.add(new Task(value, remain - 1));
				}
			}
		}
		
		System.out.println(result);
	}
}

class Task {
	int value;
	int remain;
	
	public Task(int value, int remain) {
		this.value = value;
		this.remain = remain;
	}
}