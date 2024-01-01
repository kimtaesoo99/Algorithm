class Solution {
    public String solution(String my_string, int m, int c) {
        char[][] result = new char[my_string.length() / m][m];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = my_string.charAt(m * i + j);
            }
        }

        char[] result2 = new char[result.length];

        for (int i = 0; i < result.length; i++) {
            result2[i] = result[i][c - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (char value : result2) {
            sb.append(value);
        }

        return sb.toString();
    }
}
