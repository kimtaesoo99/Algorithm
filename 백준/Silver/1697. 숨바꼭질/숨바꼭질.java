import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] map;
    public static void main(String[] args) {
        map = new int[100001];
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        bfs(start, end);
        System.out.println(map[end]);
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);
        map[start] = 0;
        while (!queue.isEmpty()) {
            int move = queue.poll();
            if (move == end) return;
            int[] arr = new int[3];
            arr[0] = move - 1;
            arr[1] = move + 1;
            arr[2] = move * 2;
            for (int i = 0; i < 3; i++) {
                if (arr[i]<0 || arr[i]>100000 || map[arr[i]] != 0)continue;
                map[arr[i]] = map[move] + 1;
                queue.offer(arr[i]);
                if (arr[i] == end) return;
            }
        }
    }
}
