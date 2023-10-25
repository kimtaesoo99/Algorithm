import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int result;
    private static List<Integer>[] friendList;
    private static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {
            result = Integer.MAX_VALUE;
            n = sc.nextInt();
            friendList = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) {
                friendList[j] = new ArrayList<>();
            }

            for (int j = 1; j <= n; j++) {
                int friendCount = sc.nextInt();

                for (int k = 0; k < friendCount; k++) {
                    int friend = sc.nextInt();
                    friendList[j].add(friend);
                }
            }

            visited = new int[n + 1];
            backTracking(0, 0);
            System.out.println(result);
        }
    }

    private static void backTracking(int index, int count) {
        if (count >= result) return;

        if (index == n) {
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) return;
            }
            result = count;
            return;
        }

        visited[index + 1]++;
        for (int friend : friendList[index + 1]) {
            visited[friend]++;
        }
        backTracking(index + 1, count + 1);

        visited[index + 1]--;
        for (int friend : friendList[index + 1]) {
            visited[friend]--;
        }
        backTracking(index + 1, count);
    }
}
