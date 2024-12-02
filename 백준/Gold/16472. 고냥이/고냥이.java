import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int left = 0;
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int right = 0; right < str.length(); right++) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);

            if (map.get(str.charAt(right)) == 1) {
                count++;
            }

            while (n < count) {
                map.put(str.charAt(left), map.get(str.charAt(left)) - 1);

                if (map.get(str.charAt(left++)) == 0) {
                    count--;
                }
            }
            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}