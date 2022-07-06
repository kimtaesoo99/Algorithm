import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] arr = new String[N][2]; 
		for(int i =0; i<N;i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
			
		}
		Arrays.sort(arr,(e1,e2)->{
				return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);
		});
		
		for(int i =0; i<N;i++) {
			System.out.print(arr[i][0]+" ");
			System.out.println(arr[i][1]);
			
		}
	}	
}

