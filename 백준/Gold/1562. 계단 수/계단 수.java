import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        int n = Integer.parseInt(st.nextToken());
        long mod = 1000000000;
        long[][][] arr = new long[n + 1][1 << 10][10];

        for (int i = 1; i < 10; ++i) {
            arr[1][1 << i][i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < 1 << 10; ++j) {
                for (int k = 0; k < 10; ++k) {
                    if (k - 1 >= 0) {
                        arr[i][j | (1 << k)][k] += arr[i - 1][j][k - 1];
                    }
                    if (k + 1 < 10) {
                        arr[i][j | (1 << k)][k] += arr[i - 1][j][k + 1];
                    }
                    arr[i][j | (1 << k)][k] %= mod;
                }
            }
        }

        for (int i = 0; i < 10; ++i) {
            result += arr[n][(1 << 10) - 1][i];
            result %= mod;
        }

        System.out.println(result);
    }
}
