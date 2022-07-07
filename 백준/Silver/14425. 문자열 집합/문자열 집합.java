import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] str = new String[N];
		
	
		for(int i =0; i <N;i++) {
			str[i] = br.readLine();
			}
		int count=0;
		for(int i =0; i<M;i++) {
			String s = br.readLine();
			for(int j=0; j<N;j++) {
				if(Arrays.asList(str[j]).contains(s)) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		
	}

}
