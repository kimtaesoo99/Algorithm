import java.util.*;

public class Main {
	static double N;
	static double M;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T =sc.nextInt();
    	
    	for(int c=1; c<=T;c++) {
    		 N=sc.nextDouble();
    		 M=sc.nextDouble();
    		
    		System.out.printf("%.0f\n",Combination(M,N));
    	}
    	
    }
    
    public static double Combination(double n,double m) {
    		double a=1,b=1;
    		for(double i=n;i>n-m;i--) {
    			a=a*i;
    		}
    		for(double i=m; i>0;i--) {
    			b=b*i;
    		}
    		return a/b;
    }
}