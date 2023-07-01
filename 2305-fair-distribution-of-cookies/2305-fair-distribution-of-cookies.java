class Solution {
    private static int[] people;
    private int min = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        people = new int[k];
        backtracking(0, cookies.length, cookies);
        return min;
    }

    private void backtracking(int index, int cookiesLength, int[] cookies) {
        if (index == cookiesLength) {
            checkMinResult();
            return;
        }

        for (int i = 0; i < people.length; i++) {
            people[i] += cookies[index];
            backtracking(index + 1, cookiesLength, cookies);
            people[i] -= cookies[index];
        }
    }

    private void checkMinResult() {
        int max = 0;
        for (int p : people) {
            max = Math.max(max, p);
        }
        min = Math.min(min, max);
    }
}