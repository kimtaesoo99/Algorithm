import java.io.IOException;
import java.util.Scanner;

public class Main{
    static int N;
    static int S;
    static int[] arr;
    static int count;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(S==0?count-1:count);
    }
    public static void dfs(int index, int sum){
        if (index==N){
            if (sum==S)count++;
            return;
        }
        dfs(index+1,sum+arr[index]);
        dfs(index+1,sum);
    }
}
