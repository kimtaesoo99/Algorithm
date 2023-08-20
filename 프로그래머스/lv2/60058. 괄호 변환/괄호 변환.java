class Solution {
    public String solution(String w) {
        if (w.isEmpty()) {
            return w;
        }

        int index = findBalancedIndex(w);
        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);

        if (isCorrect(u)) {
            return u + solution(v);
        }

        return "(" + solution(v) + ")" + reverse(u);
    }

    private int findBalancedIndex(String w) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    private boolean isCorrect(String u) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return true;
    }

    private String reverse(String u) {
        StringBuilder reversed = new StringBuilder();

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                reversed.append(')');
            } else {
                reversed.append('(');
            }
        }
        return reversed.toString();
    }
}
