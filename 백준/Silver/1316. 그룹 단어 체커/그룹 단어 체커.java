import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int count=0;

		for(int i = 0;i<num;i++) {
			String str = sc.next();
			loop:
			for(int k = 0;k<str.length();k++) {
				 for(int j=k; j<str.length();j++) {
					if(str.charAt(k)==str.charAt(j)) {
						if(j-k==1)break;
						else if(j-k>1) {
							count++;
							break loop;	}
					}
				}
			}	
		}
		System.out.println(num-count);
	}
}