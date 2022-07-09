import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");

		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		
		String[] arr2 = br.readLine().split(" ");
	
		for(int i=0; i<M; i++) {
			sb.append(Arrays.binarySearch(arr, arr2[i])>=0?"1 \n":"0 \n");
		}
		System.out.println(sb);
	}
}
