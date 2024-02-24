import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] player;
    private static int[] choose;
    private static boolean[] visited;
    private static int n;
    private static int nowPlayer;
    private static int nowScore;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        player = new int[n + 1][10]; // 이닝, 선수
        choose = new int[10];
        visited = new boolean[10];

        for (int e = 1; e <= n; e++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
                player[e][i] = Integer.parseInt(st.nextToken());
            }
        }
        permutation(1);

        System.out.println(result);
    }

    private static void permutation(int count) {
        if (count == 10) {
            nowPlayer = 1;
            nowScore = 0;
            startGame();
            result = Math.max(nowScore, result);
            return;
        }

        if (count == 4) {
            choose[4] = 1;
            permutation(count + 1);
        }

        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choose[count] = i;
                permutation(count + 1);
                visited[i] = false;
            }
        }
    }

    private static void startGame() {
        for (int i = 1; i <= n; i++) {
            int out = 0;
            List<Integer> list = new ArrayList<>();
            while (true) {
                int hit = player[i][choose[nowPlayer++]];

                if (nowPlayer > 9) {
                    nowPlayer = 1;
                }
                if (hit == 0) {
                    out++;
                } else {
                    list.add(hit);
                }

                if (out == 3) {
                    int count = 0;
                    int last = list.size() - 1;
                    if (last != -1) {
                        int sum = 0;
                        for (int j = last; j >= 0; j--) {
                            sum += list.get(j);
                            if (sum >= 4) {
                                break;
                            }
                            count++;
                        }
                    }
                    nowScore += list.size() - count;
                    break;
                }
            }
        }
    }
}