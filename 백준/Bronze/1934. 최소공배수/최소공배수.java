import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i <T;i++){
		StringTokenizer st = new StringTokenizer(br.readLine());
		  int A = Integer.parseInt(st.nextToken());
		  int B = Integer.parseInt(st.nextToken());
		  int min = A>B?B:A;
		  
		  int divis = 1;
		  for(int j = 1;j<=min;j++) {
			  if(A%j==0&&B%j==0)divis=j;
		  }
		  
		  System.out.println(A*B/divis);
		}
		
	}
 
}