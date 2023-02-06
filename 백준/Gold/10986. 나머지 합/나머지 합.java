import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long count = 0;
        long[] sum = new long[N + 1];
        long[] division = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] += (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (sum[i] == 0) count++;
            division[(int) sum[i]]++;

        }

        for (int i = 0; i < M; i++) {
            if (division[i] > 1) count += (division[i] * (division[i] - 1) / 2);
        }

        System.out.println(count);
    }
}
