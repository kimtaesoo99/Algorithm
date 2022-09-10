

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        //홀수일때
        int count = 0;
        if (N%2!=0){
            for (int i=N-1;i>=N/2; i--){
                if (i==N/2){
                    count+=arr[i];
                    break;
                }
                count+=arr[i]*2;
            }
        }
        //짝수일때
        else {
            for (int i=N-1;i>=N/2; i--){
                count+=arr[i]*2;
            }
        }
        System.out.println(count);
    }
}
