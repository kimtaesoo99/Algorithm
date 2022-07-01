import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	int M = sc.nextInt();
    	int N = sc.nextInt();
    	
    	int sum=0;
    	int min=N;
    	for(int i =M; i<=N;i++) {
    		
    		for(int j = 2; j<=i;j++) {
    			if(i%j==0) {
    				if(i==j) {
    					sum+=i;
    					min = (min>i)?i:min;
    				}
    				break;
    			}
    		}
    		
    	}
    	if(sum==0)System.out.println(-1);
    	else {
    		System.out.println(sum);
    		System.out.println(min);	
    	}
    }
}