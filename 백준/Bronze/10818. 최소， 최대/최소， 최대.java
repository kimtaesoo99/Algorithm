import java.util.*;

public class Main
{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N= scanner.nextInt();
		int[] x = new int[N];
		for(int i=0; i<N; i++) {
			int A = scanner.nextInt();
			x[i]=A;
		}
		int max=x[0],min=x[0];
		
		for(int j=1; j<x.length; j++)
		if(x[j]>max) {
			max=x[j];
		}
		else if(x[j]<min) {
			min=x[j];
		}
		System.out.printf("%d %d",min,max);
		
	}
}

