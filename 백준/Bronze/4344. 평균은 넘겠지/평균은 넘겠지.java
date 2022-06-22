import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr;
		int testcase = in.nextInt();

		for(int i = 0 ; i < testcase ; i++) {
			int n = in.nextInt();
			arr = new int[n];
			double sum = 0;

			for(int i1 = 0 ; i1 < n ; i1++) {
				int grade = in.nextInt();
				arr[i1] = grade;
				sum += grade;
			}
			
			double avg = (sum / n) ;
			double count = 0;
			
			for(int i2 = 0 ; i2 < n ; i2++) {
				if(arr[i2] > avg) {
					count++;
				}
			}
			
			System.out.printf("%.3f%%\n",(count/n)*100);
		}
		
		in.close();
	}

}