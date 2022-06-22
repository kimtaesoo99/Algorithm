import java.util.*;

public class Main
{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String s =sc.next();
		int[] num = new int[26];
		
		s=s.toUpperCase();

		for(int i =0;i<s.length(); i++) {
			num[s.charAt(i)-65]++;
		}
		int max=0,count=0,n=0;
		
		for(int i = 0;i<26; i++) {
			if(num[i]>max) {
			max=num[i];
			n=i;
			}
		}
		for(int i=0; i<26; i++) {
			if(num[i]==max)count++;
		}
		if(count>1)System.out.print("?");
		
		else System.out.print((char)(n+65));
	}
	
}