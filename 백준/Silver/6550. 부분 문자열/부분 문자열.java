import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String str;
	static int idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			idx = 0;
			
			for (int i = 0; i < s2.length(); i++) {
				if (s1.charAt(idx) == s2.charAt(i)) {
					idx++;
				}
				if (idx == s1.length())
					break;
			}
			
			if (idx == s1.length())
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}