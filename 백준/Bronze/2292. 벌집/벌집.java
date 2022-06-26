import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			int count=0;
			int sum=0;
			for(int i = 0; i<num; i++) {
				sum+=6*i;
				count++;
				if(sum>=num-1)break;
			}

			System.out.println(count);
	}
}
