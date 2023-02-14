import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] count = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int find1 = sc.nextInt();
        int find2 = sc.nextInt();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[b] = a;
        }
        int sum = 0;

        int distance = 1;
        visited[find1] = true;
        while (true){
            int parent = arr[find1];
            if (parent==0)break;
            visited[parent] = true;
            count[parent] = distance;
            distance++;
            find1 = parent;
        }
        distance = 1;
        if (visited[find2]) {
            System.out.println(count[find2]);
            return;
        }
        while (true){
            int parent = arr[find2];
            if (parent==0){
                sum =-1;
                break;
            }
            if (visited[parent]){
                sum = count[parent] + distance;
                break;
            }
            distance++;
            find2 = parent;
        }
        System.out.println(sum);
    }
}
