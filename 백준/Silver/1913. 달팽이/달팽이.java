import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int mid = n / 2;
        arr[mid][mid] = 1;

        int now = n * n;

        int y = 0;
        int x = 0;
        int move = n - 1;

        StringBuilder result = new StringBuilder();

        while (now != 1) {
            // 아래
            for (int i = 0; i < move; i++) {
                arr[y][x] = now;
                y++;
                now--;
            }

            // 오른쪽
            for (int i = 0; i < move; i++) {
                arr[y][x] = now;
                x++;
                now--;
            }

            // 위
            for (int i = 0; i < move; i++) {
                arr[y][x] = now;
                y--;
                now--;
            }

            // 왼쪽
            for (int i = 0; i < move; i++) {
                arr[y][x] = now;
                x--;
                now--;
            }
            x++;
            y++;

            move -= 2;
        }

        // 그래프
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(arr[i][j]).append(" ");
            }
            result.append("\n");
        }
        System.out.print(result);

        int find = sc.nextInt();
        result.setLength(0);

        // 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == find) {
                    result.append((i + 1)).append(" ").append((j + 1)).append("\n");
                }
            }
        }
        System.out.print(result);
    }
}
