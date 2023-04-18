import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        StringBuilder result = new StringBuilder();

        loop:
        for (int i = 0; i < test; i++) {

            boolean isFront = true;
            Deque<String> q = new ArrayDeque<>();
            String[] control = sc.next().split("");
            int numberCount = sc.nextInt();
            String arrInfo = sc.next();
            String[] arr = arrInfo.substring(1, arrInfo.length() - 1).split(",");

            //값을 디큐에 넣음
            for (String a : arr) {
                q.offer(a);
            }

            //컨트롤 실행
            for (String c : control) {
                if (c.equals("R")) {
                    isFront = !isFront;
                    continue;
                }
                if (q.size() == 0 || numberCount == 0) {
                    result.append("error").append("\n");
                    continue loop;
                }
                if (isFront) {
                    q.pollFirst();
                    continue;
                }
                q.pollLast();
            }

            result.append("[");
            if (isFront) {
                q.forEach(v -> {
                    result.append(v).append(",");
                });
            } else {
                q.descendingIterator().forEachRemaining(v -> {
                    result.append(v).append(",");
                });
            }
            if (result.charAt(result.length() - 1) == ',') {
                result.deleteCharAt(result.length() - 1);
            }
            result.append("]").append("\n");
        }
        System.out.println(result);
    }
}