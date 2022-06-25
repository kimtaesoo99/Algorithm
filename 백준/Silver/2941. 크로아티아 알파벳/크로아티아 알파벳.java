import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String st =sc.nextLine();
		
		for(int i=0; i<str.length;i++) {
			if(st.contains(str[i]))
				st=st.replace(str[i],"1");
		}
		
		System.out.println(st.length());
	}
}
