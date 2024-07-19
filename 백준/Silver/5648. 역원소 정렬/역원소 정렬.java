import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            StringBuilder now = new StringBuilder(sc.next()).reverse();
            arr[i] = Long.parseLong(now.toString());
        }

        Arrays.stream(arr)
                .sorted()
                .forEach(System.out::println);
    }
}
