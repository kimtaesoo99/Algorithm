import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Stack<int[]> top = new Stack<>(); //Stack에 int형 배열 저장 가능!!
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < n) //가장 앞의 탑이 n보다 작으면, 앞으로 어떠한 신호도 수신할 수 없으므로 스택에서 제거해버린다.(가지고 있을 필요가 없음)
					top.pop();
				else { //n보다 크다면, 해당 탑의 번호를 출력한다.
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}
			
			if(top.empty()) //탑이 비었다면 0을 출력한다.
				System.out.print("0 ");
			top.push(new int[] {n, i+1}); //탑의 높이와 탑의 번호 배열을 저장
		}
			
	}

}