import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndS = br.readLine().split(" ");
        int n = Integer.parseInt(nAndS[0]);
        int s = Integer.parseInt(nAndS[1]);

        String[] arrInfo = br.readLine().split(" ");
        int arrSum = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(arrInfo[i]);
            arrSum+=arr[i];
        }

        if(arrSum<s){
            System.out.println(0);
            return;
        }

        int sum = 0;
        int length = n;
        int j = -1;

        for (int i = 0; i < n; i++){
            sum+=arr[i];
            if (sum>=s){
                while (sum>=s){
                    length = Math.min(length,i-j);
                    j++;
                    sum-=arr[j];
                }
            }
        }
        System.out.println(length);

    }
}
