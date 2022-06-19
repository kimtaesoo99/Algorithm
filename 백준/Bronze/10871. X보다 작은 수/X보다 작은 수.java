import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		
		for(int i=1; i<=N; i++) {   	
		int A = scanner.nextInt();
		if(A<X) {
			System.out.print(A +" ");
		}
			
			}
		}
}