class Solution {
    static int count;
    static int[][] answer;

    public int[][] solution(int n) {
        int size = (int) Math.pow(2, n) - 1;
        answer = new int[size][2];
        hanoi(1, 2, 3, n);
        return answer;
    }

    //start, mid, end
    private void hanoi(int s, int m, int e, int n) {
        if (n == 0) {
            return;
        }
        hanoi(s, e, m, n - 1);
        answer[count][0] = s;
        answer[count][1] = e;
        count++;
        hanoi(m, s, e, n - 1);
    }
}