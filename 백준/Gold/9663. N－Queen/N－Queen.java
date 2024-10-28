import java.util.Scanner;

class Main {

    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] chess = new int[n];
        back(chess, 0);

        System.out.println(result);
    }

    private static void back(int[] chess, int depth) {
        if (depth == chess.length) {
            result++;
            return;
        }

        for (int i = 0; i < chess.length; i++) {
            chess[depth] = i;
            if (check(chess, depth, i)) {
                back(chess, depth + 1);
            }
        }
    }

    private static boolean check(int[] chess, int depth, int index) {
        for (int i = 0; i < depth; i++) {
            if (index == chess[i]) {
                return false;
            }
        }

        for (int i = 0; i < depth; i++) {
            if (Math.abs(chess[i] - index) == Math.abs(i - depth)) {
                return false;
            }
        }

        return true;
    }
}