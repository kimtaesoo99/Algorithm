import java.util.Scanner;

public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++){
            int n = sc.nextInt();
            count = 0;
            getCount(n,0);
            System.out.println(count);
        }
    }

    static void getCount(int n , int sum){
        if (n == sum){
            count++;
            return;
        }
        for (int i = 1; i<=3; i++){
            if (sum+i > n)continue;
            getCount(n,sum+i);
        }
    }
}