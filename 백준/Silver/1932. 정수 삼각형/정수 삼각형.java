import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        for (int i=1; i < n+1; i++){
            for (int j = 1; j<i+1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for (int i =1; i <n+1; i++) {
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] += Math.max(arr[i-1][j-1],arr[i-1][j]);
                if (i ==n){
                    max = Math.max(max,arr[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}