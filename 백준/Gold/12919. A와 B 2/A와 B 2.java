import java.util.Scanner;

public class Main {

    private static int result;
    private static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        s = sc.nextLine();
        String t = sc.nextLine();
        dfs(t);

        System.out.println(result);
    }


    public static void dfs(String t) {
        int lenT = t.length();

        if (lenT == s.length()) {
            if (t.equals(s)) {
                result = 1;
            }
            return;
        }

        if (t.endsWith("A")) {
            dfs(t.substring(0, lenT - 1));
        }

        if (t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
