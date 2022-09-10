import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		check = new boolean[N];
		rec(M,N,0);	
		System.out.println(sb);
	}	
	public static void rec(int M, int N, int index) {
		if(M==index) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i <N;i++) {
			if(!check[i]) {
				check[i]=true;
				arr[index]=i+1;
				rec(M, N, index + 1);
				check[i]=false;
			}
		}
	}
}
