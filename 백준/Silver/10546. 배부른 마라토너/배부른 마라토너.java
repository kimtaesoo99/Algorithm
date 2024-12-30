import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            String now = br.readLine();

            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        System.out.println(map.entrySet().stream().filter(i -> i.getValue() % 2 == 1).map(Entry::getKey).findFirst().get());
    }
}