import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    private static int max;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int B = sc.nextInt();

        visited = new boolean[A.length()];

        List<String> list = Arrays.stream(A.split(""))
                .collect(Collectors.toList());

        combination(B, list, "", 0);

        System.out.println(max == 0 ? -1 : max);
    }

    private static void combination(int b, List<String> list, String s, int i) {
        if (i == list.size() && Integer.parseInt(s) < b) {
            max = Math.max(max, Integer.parseInt(s));
            return;
        }

        for (int j = 0; j < list.size(); j++) {
            if (!visited[j]) {
                if (list.get(j).equals("0") && i == 0){
                    continue;
                }
                visited[j] = true;
                combination(b, list, s + list.get(j), i + 1);
                visited[j] = false;
            }
        }
    }
}