import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {

    static char[] arr;
    static int[] check;
    static Stack<Character> s;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            set = new TreeSet<>();
            check = new int[26];
            s = new Stack<>();
            arr = br.readLine().toCharArray();

            for (char c : arr) {
                check[c - 'a']++;
            }

            back(arr.length);
            set.forEach(s -> result.append(s).append("\n"));
        }

        System.out.println(result);
    }

    static void back(int r) {
        if (r == s.size()) {
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                sb.append(c);
            }
            set.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (check[i] > 0) {
                check[i]--;
                s.push((char) (i + 'a'));
                back(r);
                s.pop();
                check[i]++;
            }
        }
    }
}