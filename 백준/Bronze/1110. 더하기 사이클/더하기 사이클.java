import java.io.*;
import java.util.*;

public class Main
{

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int num= scanner.nextInt();
		
		int n=num;
		int sum=0;
		while(true) {
		num=((num%10)*10)+(((num/10)+num%10)%10);
		
		sum++;
		
		if(n==num)
			break;
		}
		System.out.println(sum);
	}
}