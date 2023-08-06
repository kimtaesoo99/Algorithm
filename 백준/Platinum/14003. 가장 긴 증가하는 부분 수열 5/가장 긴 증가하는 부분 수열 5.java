import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n + 1];
        int[] indexOfArr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(Integer.MIN_VALUE);

        for (int i = 1; i <= n; i++) {
            int now = arr[i];

            if (now > list.get(list.size() - 1)) {
                list.add(now);
                indexOfArr[i] = list.size() - 1;
                continue;
            }

            int left = 1;
            int right = list.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid) >= now) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            list.set(right, now);
            indexOfArr[i] = right;
        }

        sb.append(list.size() - 1).append("\n");
        Stack<Integer> stack = new Stack<>();

        int index = list.size() - 1;

        for (int i = n; i > 0; i--) {
            if (indexOfArr[i] == index) {
                stack.push(arr[i]);
                index--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}