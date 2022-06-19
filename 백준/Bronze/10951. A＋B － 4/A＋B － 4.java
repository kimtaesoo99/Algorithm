import java.io.*;
import java.util.*;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String str = "";
		
		while((str = br.readLine()) != null)
		{
			st = new StringTokenizer(str, " ");
			
			bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
}
