import java.util.*;


public class Main {
	   public static void main(String[] args) {	
		   	Stack s =new Stack();
		   	Scanner sc = new Scanner(System.in);
		   	int num = sc.nextInt();
		   
		   	for(int i =0; i<num; i ++) {
		   		int n = sc.nextInt();
		   		if(n==0) {
		   			s.pop();
		   		}
		   		else {
		   			s.push(n);
		   		}
		   	}
		   	int sum=0;
		   	Iterator i = s.iterator();
		   	while(i.hasNext()) {
		   		sum+=(int)i.next();
		   	}
		   	System.out.println(sum);
	  }
}
