import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int j = n; j >= 1; j--) {
            sb.append(" ".repeat(n - j)).append("*".repeat(j * 2 - 1)).append("\n");
        }
        for (int j = 2; j <= n; j++) {
            sb.append(" ".repeat(n - j)).append("*".repeat(j * 2 - 1)).append("\n");
        }
        System.out.println(sb);
    }
}