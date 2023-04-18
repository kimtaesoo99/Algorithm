import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt() + 1;

        StringBuilder sb = new StringBuilder();

        while (k != 0) {
            sb.append(k % 2);
            k /= 2;
        }
        String result = sb.reverse()
                .toString()
                .replace('0','4')
                .replace('1','7')
                .substring(1);

        System.out.println(result);
    }
}