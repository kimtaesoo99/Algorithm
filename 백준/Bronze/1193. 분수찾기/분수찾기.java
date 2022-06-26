import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main { 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		while(N > count) {
			N -= count++;
		}
		if(count % 2 == 0) {

			sb.append(N).append("/").append(count+1 - N);

		}else {

			sb.append(count+1 - N).append("/").append(N);
		}
		
		System.out.print(sb.toString());	
	}
}
