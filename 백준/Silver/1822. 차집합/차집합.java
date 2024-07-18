import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : arr) {
            map.put(i, 0);
        }

        List<Integer> result = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value == 1) {
                result.add(key);
            }
        });

        System.out.println(result.size());
        result.stream().sorted().forEach(i -> System.out.print(i + " "));
    }
}
