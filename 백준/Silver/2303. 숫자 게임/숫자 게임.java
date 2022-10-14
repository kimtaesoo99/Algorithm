
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr= new int[n][5];
        int[] score = new int[n];
        //값 넣기
        for (int i =0;i<n;i++){
            for (int j=0;j<5;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int l=0;l<n;l++) {
            int max = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (i == k || k == j || i == j) continue;
                        if ((arr[l][i] + arr[l][j] + arr[l][k])%10 > max) {
                            max = (arr[l][i] + arr[l][j] + arr[l][k])%10;
                            score[l] = max;
                        }
                    }
                }
            }
        }
        int maxindex =0;
        int index=0;
        for (int i=0;i<n;i++){
            if (score[i]>=maxindex){
                maxindex=score[i];
                index = i;
            }
        }
        System.out.println(index+1);

    }
}

