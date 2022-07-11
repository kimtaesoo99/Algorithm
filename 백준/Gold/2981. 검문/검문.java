import java.util.*;
public class Main {
	
	public static int GCD(int a, int b) {
		
		if(b == 0) return a;
		else return GCD(b, a%b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		int gcd = num[1]-num[0];
		for (int i = 2; i < N; i++) {
			gcd = GCD(gcd, num[i]-num[i-1]);
		}
		
		for (int i = 2; i <= gcd/2; i++) {
			if(gcd%i==0) System.out.print(i+" ");
		}
		System.out.print(gcd+" ");
				
	}
}