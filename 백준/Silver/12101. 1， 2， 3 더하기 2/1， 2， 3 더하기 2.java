import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();

        dfs(0, "");
        Collections.sort(list);

        try {
            System.out.println(list.get(k-1).substring(1));
        }catch (IndexOutOfBoundsException e){
            System.out.println(-1);
        }
    }

    private static void dfs(int sum, String result) {
        if (sum >= n) {
            if (sum == n) {
                list.add(result);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(sum + i, result + "+" + i);
        }
    }
}
