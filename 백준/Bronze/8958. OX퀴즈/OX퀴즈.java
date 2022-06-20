import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args){
		
		Scanner in =new Scanner(System.in);
		int a=in.nextInt();
		for(int i=1; i<=a; i++) {
			int score=0;
			int score1=1;
			String c=in.next();
			char[] b =new char[80];
			for(int j=0; j<c.length(); j++) {
				b[j]=c.charAt(j);
			}
			for(int j=0; j<c.length(); j++) {
				if(b[j]=='O') {
					score+=score1;
					score1++;
				}
				if(b[j]=='X')
					score1=1;
			}
			System.out.println(score);
		}
		
	}
}