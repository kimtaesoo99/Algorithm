import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    		
    	Scanner sc = new Scanner(System.in);
    	
    	String A = sc.next();
    	String B = sc.next();
    	BigInteger val1,val2;
    	val1 = new BigInteger(A);
    	val2 = new BigInteger(B);
    	System.out.println(val1.add(val2));
    }
}
