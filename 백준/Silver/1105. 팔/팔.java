import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String L = Integer.toString(sc.nextInt());
		String R = Integer.toString(sc.nextInt());

		if (L.length() != R.length()) {
			System.out.println(0);
		} else {
			int cnt = 0;
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) != R.charAt(i)) break;
				else { 
  
					if (L.charAt(i) == '8' && R.charAt(i) == '8')
						cnt++;
				}
			}
			System.out.println(cnt);

		}

	}

}