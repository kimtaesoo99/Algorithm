import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        N = Integer.parseInt(num[0]);
        M = Integer.parseInt(num[1]);
        result = new int[M];
        sb = new StringBuilder();
        getResult(0, -1);
        System.out.println(sb);
    }

    public static void getResult(int index, int pre) {
        if (index == M) {
            for (int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i >= pre) {
                result[index] = i + 1;
                getResult(index + 1, i);
            }
        }
    }
}
