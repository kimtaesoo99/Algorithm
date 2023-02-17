import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            int value = Integer.parseInt(br.readLine());

            if (minQ.size() == maxQ.size())maxQ.offer(value);
            else minQ.offer(value);

            if (!minQ.isEmpty() && !maxQ.isEmpty()){
                if (minQ.peek() < maxQ.peek()){
                    Integer poll = minQ.poll();
                    minQ.offer(maxQ.poll());
                    maxQ.offer(poll);
                }
            }
            sb.append(maxQ.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
