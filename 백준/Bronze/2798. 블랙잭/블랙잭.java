import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i <N;i++) {
		arr[i]=sc.nextInt();	
		}
		int min=100000; //값의 차이
		for(int i =0; i<=N-3;i++) {
			for(int j=i+1; j<=N-2;j++) {
				for(int k=j+1; k<=N-1; k++) {
					if(arr[i]+arr[j]+arr[k]<=M) {
						if(M-(arr[i]+arr[j]+arr[k])<=min)
							min=M-(arr[i]+arr[j]+arr[k]);

					}
				}
			}
		}
		System.out.println(M-min);
	}
}


