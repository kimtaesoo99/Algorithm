import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[101];
        for (int i=1; i<101; i++){
            check[i] = false;
        }
        int N = sc.nextInt();
        int count = 0;
        for (int i=0; i<N; i++){
            int a = sc.nextInt();
            if (check[a]==false) check[a]=true;
            else count++;
        }
        System.out.println(count);
    }
}
