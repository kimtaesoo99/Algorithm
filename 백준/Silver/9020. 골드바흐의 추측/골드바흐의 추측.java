import java.util.Scanner;

public class Main {
	public static boolean[] prime = new boolean[10001]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		getprime();
		int T = sc.nextInt();	
 
		while (T-- > 0) {
			int n = sc.nextInt();
			int first_partition = n / 2;
			int second_partition = n / 2;
 
			while (true) {
				if (!prime[first_partition] && !prime[second_partition]) {
					System.out.println(first_partition + " " + second_partition);
					break;
				}
				first_partition--;
				second_partition++;
			}
		}
 
	}
	
	public static void getprime() {
		prime[0] = prime[1] = true;
 
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
 
}
