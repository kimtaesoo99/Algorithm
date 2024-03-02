import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Map<String, Integer> exist = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                exist.put(st.nextToken(), 1);
            }
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (exist.containsKey(st.nextToken())) {
                    result++;
                }
            }
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}