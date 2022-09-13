

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N-1];
        int dasom = sc.nextInt();
        for (int i=0;i<N-1; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        if (N==1){
            System.out.println(0);
            return;
        }
        while (true){
            Arrays.sort(arr);
            boolean check =true;
            if (dasom<=arr[N-2]){
                dasom++;
                arr[N-2]--;
                count++;
                check = false;
            }
            if (check)break;

        }

        System.out.println(count);
    }
}
