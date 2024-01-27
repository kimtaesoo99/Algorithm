import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            int visited = 0;
            int total = (1 << 10) - 1;
            int count = 0;

            while (true) {
                if (visited == total) {
                    break;
                }

                for (char c : String.valueOf(n * ++count).toCharArray()) {
                    int num = c - '0';
                    visited |= (1 << num);
                }
            }

            System.out.println("#" + test_case + " " + n * count);
        }
    }
}