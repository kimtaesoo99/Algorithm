import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        findSum(0, n / 2, arr, leftList, 0);
        findSum(n / 2, n, arr, rightList, 0);

        Collections.sort(leftList);
        Collections.sort(rightList);

        findResult(leftList, rightList, s);

        if (s == 0) {
            result -= 1;
        }

        System.out.println(result);
    }

    private static void findSum(int start, int end, int[] arr, List<Integer> list, int sum) {
        if (start == end) {
            list.add(sum);
            return;
        }

        findSum(start + 1, end, arr, list, sum + arr[start]);
        findSum(start + 1, end, arr, list, sum);
    }

    private static void findResult(List<Integer> leftList, List<Integer> rightList, int s) {
        int leftPoint = 0;
        int rightPoint = rightList.size() - 1;

        while (leftPoint < leftList.size() && rightPoint >= 0) {
            int leftSum = leftList.get(leftPoint);
            int rightSum = rightList.get(rightPoint);

            if (leftSum + rightSum == s) {
                long leftCount = 0;
                long rightCount = 0;

                while (leftPoint < leftList.size() && leftList.get(leftPoint) == leftSum) {
                    leftCount++;
                    leftPoint++;
                }

                while (rightPoint >= 0 && rightList.get(rightPoint) == rightSum) {
                    rightCount++;
                    rightPoint--;
                }
                result += leftCount * rightCount;
            }
            if (leftSum + rightSum > s) {
                rightPoint--;
            }
            if (leftSum + rightSum < s) {
                leftPoint++;
            }
        }
    }
}

