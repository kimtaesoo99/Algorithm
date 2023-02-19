import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k==0){
            System.out.println(-1);
            return;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();

        while (n!=0){
            for (int i = 0; i <= 24; i++){
                int a = (int) Math.pow(2,i);
                if (n/a==1){
                    n = n%a;
                    q.add(a);
                    break;
                }
            }
        }

        int sum = 0;
        while (q.size()>k){
            Integer poll = q.poll();
            if (Objects.equals(q.peek(), poll)){
                q.poll();
                q.offer(2 * poll);
            }else {
                sum += poll;
                q.offer(2 * poll);
            }
        }

        System.out.println(sum);

    }
}
