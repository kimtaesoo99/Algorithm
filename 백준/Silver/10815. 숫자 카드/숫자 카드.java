import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		int N,M=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String[]strNum=br.readLine().split(" ");
		M = Integer.parseInt(br.readLine());
		String[]strmNum=br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		Arrays.sort(strNum);

		for(int j=0;j<M;j++){
			sb.append((Arrays.binarySearch(strNum,strmNum[j])>=0)?1+" ":0+" ");
		}
		System.out.print(sb);
	}

}

