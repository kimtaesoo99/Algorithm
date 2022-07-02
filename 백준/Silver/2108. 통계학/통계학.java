import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int[] number = new int[N];
		double sum=0;
		for(int i =0; i<N; i++) {
			number[i]=sc.nextInt();
			sum+=number[i];
		}
		Arrays.sort(number);
		
		//최빈값
		int[] arr= new int[8001];
		for(int i=0; i <N;i++) {
			if(number[i]<0)arr[number[i]*(-1)+4000]++;
			else arr[number[i]]++;
		}
		int count=0;
		for(int i=0;i<arr.length; i++) {
			if(count<arr[i])count=arr[i];
		}
		int same=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length; i++) {
			if(count==arr[i]) {
				same++;
			if(i<4001)list.add(i);
			else if(i>=4001)list.add((-1)*i+4000);
		}
		}
		Collections.sort(list);
				
		System.out.println(Math.round(sum/N));
		System.out.println(number[N/2]);
		//최빈값
		if(same==1)System.out.println(list.get(0));
		else if(same>1)System.out.println(list.get(1));
		
		System.out.println(number[N-1]-number[0]);
	}
	
}
