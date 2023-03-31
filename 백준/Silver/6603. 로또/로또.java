import java.util.Scanner;

class Main {
    static int[] arr;
    static int[] result = new int[6];
    static int limit = 6;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int k = sc.nextInt();
            if (k == 0)break;
            arr = new int[k];
            visited = new boolean[k];
            sb = new StringBuilder();
            for (int i = 0; i < k; i++){
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);
            System.out.println(sb);
        }
    }

    private static void dfs(int count, int pre){
        if (count == limit){
            for (int r : result){
                sb.append(r).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            if (!visited[i] && arr[i] > pre){
                visited[i] = true;
                result[count] = arr[i];
                dfs(count+1, arr[i]);
                visited[i] = false;
            }
        }

    }
}
