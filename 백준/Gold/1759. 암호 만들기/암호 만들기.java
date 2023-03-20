import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int c;
    static boolean[] visited;
    static char[] arr;
    static List<String> list = new ArrayList<>();
    static List<Character> vowels = List.of('a', 'u', 'i', 'o', 'e');

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(); //자리수
        c = sc.nextInt(); //경우의 수

        visited = new boolean[c];

        arr = new char[c];

        for (int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }

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
