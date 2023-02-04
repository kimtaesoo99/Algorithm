import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) return o1-o2;
            return abs1 - abs2;
        });
        for(int i = 0 ; i < n; i++){
            int val = sc.nextInt();
            if(val == 0){
                if (queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }else queue.add(val);
        }
        System.out.println(sb);
    }
}