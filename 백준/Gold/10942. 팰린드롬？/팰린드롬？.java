import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[][] isPalindrome = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (isPalindrome[j + 1][j + i - 1] && arr[j] == arr[j + i]) {
                    isPalindrome[j][j + i] = true;
                }
            }
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            sb.append(isPalindrome[start][end] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
