import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }

        dfs(0,"",0);
        System.out.println(set.size());
    }

    private static void dfs(int now, String result, int index){
        if (index == n){
            set.add(result);
            return;
        }

        for (int i = 0; i < n; i++){
            if (!visited[i] && now - k + arr[i] >= 0){
                visited[i] = true;
                dfs( now - k + arr[i], result + i , index+1);
                visited[i] = false;
            }
        }
    }
}
