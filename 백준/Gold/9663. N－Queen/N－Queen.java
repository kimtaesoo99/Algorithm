import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] arr;
    public static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        arr = new int[N];
        chess(0);
        System.out.println(count);
    }
    public static void chess(int depth){
        if (depth == N){
            count++;
            return;
        }
        for (int i=0;i<N; i++){
            arr[depth]=i;
            if(possible(depth)){
                chess(depth+1);
            }
        }
    }
    public static boolean possible(int col){
        for (int i=0;i<col; i++){
            if(arr[col]==arr[i])return false;
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i]))return false;
        }
        return true;
    }
}