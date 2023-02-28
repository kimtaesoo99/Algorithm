import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);
        int[][] student = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int small = Integer.parseInt(info[0]);
            int big = Integer.parseInt(info[1]);
            student[small][big] = 1;
            student[big][small] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (student[j][i] == 1 && student[i][k] == 1) {
                        student[j][k] = 1;
                        student[k][j] = -1;
                    }
                    if (student[j][i] == -1 && student[i][k] == -1) {
                        student[j][k] = -1;
                        student[k][j] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (student[i][j]!=0)sum++;
            }
            if (sum==n-1)count++;
        }
        System.out.println(count);
    }
}
