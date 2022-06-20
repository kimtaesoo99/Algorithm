import java.util.Scanner;

public class Main
{
	public static void main(String[] args){
		
		int[] N = new int[9];
		Scanner scanner = new Scanner(System.in);
	
		for(int i=0; i<N.length; i++) {
			N[i]=scanner.nextInt();
		}
		int max = 0;
		int count=0;
		for(int i=0; i<N.length; i++) {
			if(N[i]>max) {
				max=N[i];
				count=i+1;
			}
			
		}
		System.out.println(max);
		System.out.println(count);
	

	}
}