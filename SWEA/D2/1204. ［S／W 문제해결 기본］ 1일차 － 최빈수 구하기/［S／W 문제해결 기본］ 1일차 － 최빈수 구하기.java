import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int testNumber = sc.nextInt();

            int[] score = new int[101];
            for (int i = 0; i < 1000; i++) {
                score[sc.nextInt()]++;
            }

            int max = 0;
            int maxValue = 0;
            for (int i = 0; i < 100; i++) {
                if (max <= score[i]) {
                    maxValue = i;
                    max = score[i];
                }
            }
            System.out.println("#" + testNumber + " " + maxValue);
        }
    }
}
