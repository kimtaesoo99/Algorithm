import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            while (k > 0 && !q.isEmpty() && q.peekLast() < arr[i]) {
                q.removeLast();
                k--;
            }
            q.offer(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (q.size()>k){
            sb.append(q.removeFirst());
        }
        System.out.println(sb);
    }
}
