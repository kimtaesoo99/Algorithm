import java.util.Scanner;

class Main {
    static int[] arr;
    static int[] change;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        change = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int n){
        if (n == arr.length){
            getValue();
            return;
        }

        for (int i = 0; i < arr.length; i++){
            if (!visited[i]){
                visited[i] = true;
                change[n] = arr[i];
                dfs(n+1);
                visited[i] = false;
            }
        }
    }

    private static void getValue(){
        int sum = 0;
        for (int i = 0; i < arr.length-1; i++){
            sum += Math.abs(change[i] - change[i+1]);
        }
        max = Math.max(max, sum);
    }
}
