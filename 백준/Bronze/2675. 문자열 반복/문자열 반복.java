import java.util.Scanner;

public class Main
{
	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		 
		int num = scanner.nextInt(); 
		for(int i = 0; i<num; i++) {
			
			int repeat =scanner.nextInt();
			String code =scanner.next();
		
		for(int k=0; k <code.length();k++){ 
			for(int j=0; j <repeat;j++) {
				System.out.print(code.charAt(k));
			}
		}
		System.out.println();
		}	
	}
}