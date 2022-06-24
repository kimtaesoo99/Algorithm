import java.util.*;

class Main {
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
	
		String str = sc.next();
		
		char[] arr = new char[str.length()];
		int count =0;
		for(int i=0; i<str.length(); i++) {
			
			arr[i]=str.charAt(i);
			
			if('A'<=arr[i]&&arr[i]<='C')count+=2;
			if('D'<=arr[i]&&arr[i]<='F')count+=3;
			if('G'<=arr[i]&&arr[i]<='I')count+=4;
			if('J'<=arr[i]&&arr[i]<='L')count+=5;
			if('M'<=arr[i]&&arr[i]<='O')count+=6;
			if('P'<=arr[i]&&arr[i]<='S')count+=7;
			if('T'<=arr[i]&&arr[i]<='V')count+=8;
			if('W'<=arr[i]&&arr[i]<='Z')count+=9;
			
		}
		int sum= count+str.length();
		System.out.println(sum);
	}
}