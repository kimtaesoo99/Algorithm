import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Comparator.reverseOrder());
        int zero = 0;
        int one = 0;

        for (int i = 0; i < n; i++){
            int value = sc.nextInt();
            if (value==0)zero++;
            else if (value==1) one++;
            else if (value < 0)minusQ.add(value);
            else plusQ.add(value);
        }
        int sum = 0;
        while (!minusQ.isEmpty() && minusQ.size()!=1){
            sum+=(minusQ.poll()* minusQ.poll());
        }
        while (!plusQ.isEmpty() && plusQ.size()!=1){
            sum+=(plusQ.poll()* plusQ.poll());
        }
        if (!minusQ.isEmpty() && zero==0)sum+=minusQ.poll();
        if (!plusQ.isEmpty())sum+=plusQ.poll();
        sum+=one;
        System.out.println(sum);
    }
}
