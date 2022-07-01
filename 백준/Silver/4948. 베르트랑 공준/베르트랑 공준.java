import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		int N	= sc.nextInt();
    		int count=0;
    		if(N==0)break;
    		boolean[] arr = new boolean[2*N+1];
    		arr[0]=arr[1]=true;
    		
    		for(int i=2; i<=Math.sqrt(2*N+1);i++) {
    			for(int j=i*i; j <2*N+1;j+=i) {
    				arr[j]=true;
    			}
    		}
    		for(int i = N+1;i<(2*N+1);i++) {
    			if(arr[i]==false)count++;
    		}
    		System.out.println(count);
 
	}
    }
}