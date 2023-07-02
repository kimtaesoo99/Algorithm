import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static boolean[] visited;
    private static int[] result;
    private static String str;
    private static int number = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        if (str.length() < 10) {
            number = str.length();
        } else {
            number = (str.length() + 7) / 2 + 1;
        }

        result = new int[number];
        visited = new boolean[number + 1];

        back(0, 0);
    }

    private static void back(int index, int now) {
        if (index >= number) {
            Arrays.stream(result).forEach(i -> System.out.print(i + " "));
            System.exit(0);
        }

        int nowNum = str.charAt(now) - '0';

        if (!visited[nowNum] && nowNum != 0) {
            visited[nowNum] = true;
            result[index] = nowNum;
            back(index + 1, now + 1);
            visited[nowNum] = false;
        }

        if (now + 1 < str.length()) {
            nowNum = Integer.parseInt(str.substring(now, now + 2));
            if (nowNum <= number && !visited[nowNum]) {
                visited[nowNum] = true;
                result[index] = nowNum;
                back(index + 1, now + 2);
                visited[nowNum] = false;
            }
        }
    }
}
