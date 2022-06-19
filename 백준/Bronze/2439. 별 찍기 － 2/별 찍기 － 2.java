import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		for(int i=1; i<=N; i++) {   //세로줄
				for(int j=N-i;j>=1; j--) {
					System.out.print(" ");	
				}
					for(int k=1; k<=i; k++) {
				System.out.print("*");			
		}		
		System.out.println();
	}
}
}