import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();

        int num = A%B;
        for (int i = 0; i < N-1; i++) {
            num *= 10;
            num %= B;
        }
        num *= 10;
        System.out.print(num/B);
    }
}