import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<String> list = new ArrayList<>();
    private static final List<Character> vowels = Arrays.asList('a', 'u', 'i', 'o', 'e');

    private static int c;
    private static boolean[] visited;
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[c];
        arr = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(l, "", -1);

        list.stream().sorted().forEach(System.out::println);
    }

    private static void dfs(int count, String result, int pre) {
        if (count == 0) {
            if (!list.contains(result) && validation(result)) {
                list.add(result);
            }
            return;
        }

        for (int i = 0; i < c; i++) {
            if (!visited[i] && arr[i] - 'a' > pre) {
                visited[i] = true;
                dfs(count - 1, result + arr[i], arr[i] - 'a');
                visited[i] = false;
            }
        }
    }

    private static boolean validation(String str) {
        int vowel = 0;
        int consonant = 0;

        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i))) {
                vowel++;
            } else {
                consonant++;
            }
        }
        return (vowel >= 1 && consonant >= 2);
    }
}