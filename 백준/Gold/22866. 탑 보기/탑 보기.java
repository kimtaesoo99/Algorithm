import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] count = new int[n];
        int[] min = new int[n];

        Stack<Node> stack = new Stack<>();

        // 오른쪽 보기
        for (int i = arr.length - 1; i >= 0; i--) {
            int now = arr[i];
            while (!stack.isEmpty()) {
                if (stack.peek().high <= now) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty() && stack.peek().high == now) {
                count[i] += stack.size() - 1;
            } else if (!stack.isEmpty() && stack.peek().high > now) {
                count[i] += stack.size();
            }

            if (!stack.isEmpty()){
                min[i] = stack.peek().index;
            }

            stack.push(new Node(now, i));
        }
        stack.clear();

        // 왼쪽 보기
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            while (!stack.isEmpty()) {
                if (stack.peek().high <= now) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (!stack.isEmpty() && stack.peek().high == now) {
                count[i] += stack.size() - 1;
            } else if (!stack.isEmpty() && stack.peek().high > now) {
                count[i] += stack.size();
            }

            if (!stack.isEmpty()){
                if (min[i] == 0){
                    min[i] = stack.peek().index;
                } else {
                    int index = stack.peek().index;

                    if (min[i] - i >= i - index){
                        min[i] = index;
                    }
                }
            }

            stack.push(new Node(now, i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count.length; i++){
            int c = count[i];
            int m = min[i] + 1;

            if (c == 0){
                sb.append("0").append("\n");
            } else {
                sb.append(c + " " + m).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class Node {

    int high;
    int index;

    public Node(int high, int index) {
        this.high = high;
        this.index = index;
    }
}