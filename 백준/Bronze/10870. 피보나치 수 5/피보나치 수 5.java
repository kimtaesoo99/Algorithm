import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		System.out.println(fivo(N));
}
	static int fivo(int n) {
		if(n==0)return n;
		else if(n==1)return 1;
		
		return fivo(n-1)+fivo(n-2);
	}
}



