import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int[] A =new int[10];
		int[] B42 = new int[42];	
		for(int i=0; i<A.length;i++) {
			A[i]=scanner.nextInt()%42;
		}
		for(int i=0; i<A.length;i++) {
			B42[A[i]]++;
		}
		int count=0;
		for(int i =0; i<B42.length;i++) {
			if(B42[i]==0)
			count++;
		}
		System.out.println(42-count);
	}
}