import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	int Prime=0;
    	for(int i=0; i<N;i++) {
    		int count =0;
    		arr[i]=sc.nextInt();  
    		for(int j=1; j<arr[i];j++) {
    	 	if(arr[i]%j==0) count++;
        	if(count==1) {
        		Prime++;
        		count++;
        	}
        	else if(count>2) {
        		Prime--;
        		break;
        		}
    		}
}	
    	System.out.println(Prime);
    }
}
