import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int sum=1,N=0;
		for(int i=0; i<3; i++) {
			sum*= scanner.nextInt();
			}
		int bsum=sum;
		while(sum!=0) {
			sum/=10;
			N++;
		}
		
		int[] arr = new int[N];
		int[] count = new int[10];
		for(int i=0; i<N; i++) {
			arr[i]=bsum%10;
			bsum/=10;			
		}	
		
		for(int i=0; i<N; i++) {
			count[arr[i]]++;
		}
		for(int i=0; i<10; i++) {
		System.out.println(count[i]);
		}
	}
}