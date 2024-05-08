import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arrow = new int[1000001];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(line[i]);

            if (arrow[height] > 0) {
                arrow[height]--;
            }
            arrow[height - 1]++;
        }

        int count = 0;

        for (int a : arrow) {
            count += a;
        }
        
        System.out.println(count);
    }
}