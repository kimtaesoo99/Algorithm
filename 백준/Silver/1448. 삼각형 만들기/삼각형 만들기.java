import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++)arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = -1;
        for (int i = 0; i  < N-2; i++){
            if (arr[i] <arr[i+1]+arr[i+2]){
                sum = arr[i] +arr[i+1]+arr[i+2];
                break;
            }
        }
        System.out.println(sum);
    }
}
