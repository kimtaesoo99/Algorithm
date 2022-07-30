import java.util.Scanner;

public class Main{
     public static  int[] arr = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<arr.length; i++){
            arr[i] = -1;
        }
        System.out.println(Tile(N));
    }
    public static int Tile(int n){
        if (arr[n] == -1){
            arr[n] = (Tile(n-1)+ Tile(n-2))%15746;
        }
        return arr[n];
    }
}
