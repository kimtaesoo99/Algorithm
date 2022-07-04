import java.util.Scanner;

 
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);	
		int A =sc.nextInt();
		int B =sc.nextInt();
		int divisor=0;
		
		for(int i=1; i<=A; i++) {
			if(A%i==0&&B%i==0)divisor=i;
		}

		System.out.println(divisor);
		System.out.println(A*B/divisor);
	}
}
