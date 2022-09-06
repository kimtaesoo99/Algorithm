import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //끊어진 줄의수
        int M = sc.nextInt(); //판매점의 수
        int[] zul6 = new int[M];
        int[] zul1 = new int[M];
        //입력받기
        for (int i =0;i<M; i++){
            zul6[i]= sc.nextInt();
            zul1[i]= sc.nextInt();
        }
        //정렬해서 배열의 0번만 값으로 사용
        Arrays.sort(zul6);
        Arrays.sort(zul1);

        if (6<N){
            if (zul6[0]<6*zul1[0]){
                System.out.println(zul6[0]*(N/6) + Math.min(zul6[0],zul1[0]*(N%6)));
            }
            else System.out.println(zul1[0]*N);
        }
        else
            System.out.println(Math.min(zul6[0],zul1[0]*N));
    }
}
