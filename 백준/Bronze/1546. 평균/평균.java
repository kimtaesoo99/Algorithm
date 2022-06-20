import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr= new int[n];
		for(int i =0;i<n; i++) {
			arr[i]=scanner.nextInt();
		}
		int max=0;
		for(int i =0; i<n;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		float sum=0;
		for(int i =0; i<n;i++) {
		sum+=arr[i]/(float)max*100.;
		
	}
		System.out.println(sum/(float)n);
	}
}