import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int firstRing = in.nextInt();
		for (int i = 1; i < N; i++) {
			
			int otherRing = in.nextInt();
			int gcd = gcd(firstRing, otherRing);
			System.out.println((firstRing / gcd) + "/" + (otherRing / gcd));
		}
	}

	static int gcd(int a, int b) {
		int r;
 
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
 
}