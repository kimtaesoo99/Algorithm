import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++){
            int now = sc.nextInt();
            if (now>=0)plusQ.add(now);
            else minusQ.add(now*(-1));
        }

        int maxValue = 0;
        if (plusQ.isEmpty())maxValue = minusQ.peek();
        else if (minusQ.isEmpty()) maxValue = plusQ.peek();
        else maxValue = Math.max(minusQ.peek(), plusQ.peek());

        int sum = 0;

        while (!plusQ.isEmpty()){
            sum+=2*plusQ.peek();
            for (int i = 0; i < M; i++)plusQ.poll();
        }

        while (!minusQ.isEmpty()){
            sum+=2*minusQ.peek();
            for (int i = 0; i < M; i++)minusQ.poll();
        }

        System.out.println(sum-maxValue);
    }
}
