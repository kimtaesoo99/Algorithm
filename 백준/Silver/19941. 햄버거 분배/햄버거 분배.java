import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        String line = br.readLine();

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char now = line.charAt(i);

            if (now == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (0 <= j && j < n && !visited[j] && line.charAt(j) == 'H') {
                        visited[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
