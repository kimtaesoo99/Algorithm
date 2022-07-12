import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int K =sc.nextInt();
		
		int[][] arr = new int[6][2];
		int width_index=0; 
		int height_index=0; 
		int width_max=0; 
		int height_max=0;
		
		for(int i=0;i<6;i++) {
			arr[i][0]=sc.nextInt();  
			arr[i][1]=sc.nextInt();  
		}
		for(int i=0;i<6;i++) {

			if(arr[i][0]==1 || arr[i][0]==2) {
				if(width_max<arr[i][1]) {
					width_max=arr[i][1];
					width_index=i;
				}
			}
		
			else if(arr[i][0]==3 || arr[i][0]==4) {
				if(height_max<arr[i][1]) {
					height_max=arr[i][1];
					height_index=i;
				}
			}
		}
		int W=0,H=0;

		if(width_index==0)H = Math.abs(arr[5][1]-arr[1][1]);
		else if(width_index==5)H = Math.abs(arr[4][1]-arr[0][1]);
		else H = Math.abs(arr[width_index+1][1]-arr[width_index-1][1]);
		
		if(height_index==0)W = Math.abs(arr[5][1]-arr[1][1]);
		else if(height_index==5)W= Math.abs(arr[4][1]-arr[0][1]);
		else W = Math.abs(arr[height_index+1][1]-arr[height_index-1][1]);
		
		System.out.println((width_max*height_max-W*H)*K);
				
}
}