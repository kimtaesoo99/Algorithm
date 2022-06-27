import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    		
    	Scanner sc = new Scanner(System.in);
    	int result = factorial(sc.nextInt());
    	System.out.println(result);
    }
    
    
    static int factorial(int n) {
    	int result = 0;
    	if(n==1||n==0)result = 1;
    	else result =n*factorial(n-1);
    	
    	return result;
    }
}

