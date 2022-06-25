import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count =0;
		
		if(num<100){count=num;}
		

		int count2=99;
		if(num>=100) {
			for(int i=100; i<=num; i++) {
			int A = i%10 - i/10%10;
			int B = i/10%10 - i/100;
				if(A==B)count2++;
			}
		}
		if(num<100)System.out.println(count);
		if(num>=100)System.out.println(count2);
	}
}
