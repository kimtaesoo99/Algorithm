import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                String command = sc.next();
                int x = sc.nextInt();
                if (command.equals("I")) {
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        int s = sc.nextInt();
                        list.add(x + j, s);
                    }
                } else if (command.equals("D")) {
                    int y = sc.nextInt();
                    for (int j = 0; j < y; j++) {
                        list.remove(x);
                    }
                } else if (command.equals("A")) {
                    for (int j = 0; j < x; j++) {
                        int s = sc.nextInt();
                        list.add(s);
                    }
                }
            }
            sb.append("#").append(test_case);
            for (int j = 0; j < 10; j++) {
                sb.append(" " + list.get(j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
