class Solution {
    static String[] pattern = {"A", "B", "C", "D", "E", "F"};

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= t * m + p; i++) {
            sb.append(findBase(n, i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = p - 1; i < sb.length(); i += m) {
            result.append(sb.charAt(i));
            if (result.length() == t) {
                break;
            }
        }
        return result.toString();
    }

    private String findBase(int n, int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            return "0";
        }
        while (i != 0) {
            int now = i % n;
            if (now >= 10) {
                sb.append(pattern[now % 10]);
            } else {
                sb.append(now);
            }
            i /= n;
        }
        return sb.reverse().toString();
    }
}