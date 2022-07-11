import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N =	Integer.parseInt(br.readLine());
		
		int count=0;
		int i=0;
		while(N!=count) {
			
			if(Integer.toString(i).contains("666"))count++;
			i++;
		}
		System.out.println(i-1);
	}

}