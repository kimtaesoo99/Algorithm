import java.util.Scanner;

class Solution {
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            result = Integer.MIN_VALUE;

            int[] A = new int[a];
            for (int i = 0; i < a; i++) {
                A[i] = sc.nextInt();
            }

            int[] B = new int[b];
            for (int i = 0; i < b; i++) {
                B[i] = sc.nextInt();
            }
            if (a > b) {
                getMax(A, B);
            } else {
                getMax(B, A);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void getMax(int[] a, int[] b) {
        for (int j = 0; j <= a.length - b.length; j++) {
            int now = 0;
            for (int i = 0; i < b.length; i++) {
                now += a[j + i] * b[i];
            }
            result = Math.max(result, now);
        }
    }
}
