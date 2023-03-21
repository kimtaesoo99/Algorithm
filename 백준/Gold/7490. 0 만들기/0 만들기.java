import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();

            dfs(n, "1", 2);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int n, String result, int index) {
        if (index > n) {
            if (validation(result)) {
                sb.append(result).append("\n");
            }
            return;
        }
        dfs(n, result + " " + index, index + 1);
        dfs(n, result + "+" + index, index + 1);
        dfs(n, result + "-" + index, index + 1);
    }

    private static boolean validation(String value) {
        String str = value.replace(" ", "");
        String[] plus = str.split("[+]");
        int result = 0;
        for (String p : plus) {
            int sum = 0;
            String[] minus = p.split("-");

            for (int i = 0; i < minus.length; i++) {
                if (i == 0) {
                    sum += Integer.parseInt(minus[i]);
                } else {
                    sum -= Integer.parseInt(minus[i]);
                }
            }

            result += sum;
        }
        return result == 0;
    }
}
