import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] A =new int[2];
		int[] B =new int[2];
		int[] C =new int[2];
		int[] D =new int[2];
		for(int i=0;i<2;i++) {
			A[i]=sc.nextInt();
		}
		for(int i=0;i<2;i++) {
			B[i]=sc.nextInt();
		}
		for(int i=0;i<2;i++) {
			C[i]=sc.nextInt();
		}
		if(A[0]-B[0]==0)D[0]=C[0];
		else if(A[0]-C[0]==0)D[0]=B[0];
		else D[0]=A[0];
		if(A[1]-B[1]==0)D[1]=C[1];
		else if(A[1]-C[1]==0)D[1]=B[1];
		else D[1]=A[1];
		
		System.out.printf("%d %d",D[0],D[1]);
	}
	
}
