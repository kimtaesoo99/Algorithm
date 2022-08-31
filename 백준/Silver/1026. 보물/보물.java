import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        int[] B = new int[N];
        for (int i=0;i<N; i++){
            A[i]=sc.nextInt();
        }
        for (int i=0;i<N; i++){
            B[i]=sc.nextInt();
        }
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int sum=0;
        for (int i=0; i <N; i++){
            sum = sum+A[i]*B[i];
        }
        System.out.println(sum);
    }
}