import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node3[] arr = new Node3[N];

        long sum = 0;
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            long a = sc.nextLong();
            arr[i] = new Node3(x, a);
            cnt += a;
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sum += arr[i].a;
            if (sum >= (cnt + 1) / 2) {
                System.out.println(arr[i].x);
                break;
            }
        }
    }
}

class Node3 implements Comparable<Node3> {
    long x;
    long a;

    public Node3(long x, long a) {
        this.x = x;
        this.a = a;
    }

    @Override
    public int compareTo(Node3 o) {
        if (this.x == o.x) {
            return (int) (this.a - o.a);
        }
        return (int) (this.x - o.x);
    }
}