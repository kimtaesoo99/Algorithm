class Solution {
    public int solution(String s) {
        int max = 1;

        boolean[][] palindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
            }
        }

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = 1; j < s.length() - i; j++) {
                if (s.charAt(j - 1) == s.charAt(j + i) && palindrome[j][j + i - 1]) {
                    palindrome[j - 1][j + i] = true;
                    max = Math.max(max, i + 2);
                }
            }
        }

        return max;
    }
}