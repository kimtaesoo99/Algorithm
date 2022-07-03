import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] arr =new int[2];
			arr[0]=sc.nextInt();
			arr[1]=sc.nextInt();
			if(arr[0]==0&&arr[1]==0)break;
			
			if(arr[0]<arr[1]) {
				if(arr[1]%arr[0]==0) {
					System.out.println("factor");
					continue;
				}

			}
			
			if(arr[0]>arr[1]) {
				if(arr[0]%arr[1]==0) {
					System.out.println("multiple");
					continue;
				}
			}
			System.out.println("neither");
			
			
		}

	}
}


