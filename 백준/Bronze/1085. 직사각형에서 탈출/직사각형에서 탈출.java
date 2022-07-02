import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[4];
		for(int i =0;i<4;i++) {
			arr[i]=sc.nextInt();
		}
		int min = 1000;
		
		min = (arr[2]-arr[0])<arr[0] ? arr[2]-arr[0]:arr[0];
		if(min>arr[3]-arr[1])min = arr[3]-arr[1];
		if(min>arr[1])min = arr[1];
		System.out.println(min);
	}
	
}
