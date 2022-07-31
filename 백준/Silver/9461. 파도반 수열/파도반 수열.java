import java.util.Scanner;

public class Main{
    public static Long[] arr = new Long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        arr[4] = 2L;
        for (int i = 5; i <=100; i++){
            arr[i] = -1L;
        }
        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            System.out.println(Triangle(N));
        }
    }
    public static Long Triangle(int n){
        if (arr[n]==-1){
            arr[n] = Triangle(n-1)+Triangle(n-5);
        }
        return arr[n];
    }
}
