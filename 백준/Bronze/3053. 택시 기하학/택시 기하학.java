import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		double R =Double.parseDouble(br.readLine());

		
		System.out.printf("%.6f\n",Math.PI*R*R);
		System.out.printf("%.6f",2*R*R);
	
	}
}
 