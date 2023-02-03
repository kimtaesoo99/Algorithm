import java.util.*;

class Main{
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int preSum = 0;
        int result = 0;

        for(int i =0; i<n; i++){
            preSum +=arr[i];
            result +=preSum;
        }

        System.out.println(result);
	}
}