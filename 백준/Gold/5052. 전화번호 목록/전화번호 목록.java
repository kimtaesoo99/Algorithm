import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] str = new String[n];

            for (int j = 0; j < n; j++) {
                str[j] = br.readLine();
            }

            Arrays.sort(str);

            boolean can = false;

            for (int k = 1; k < n; k++) {
                if (str[k].startsWith(str[k - 1])) {
                    can = true;
                    break;
                }
            }

            if (can) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}
