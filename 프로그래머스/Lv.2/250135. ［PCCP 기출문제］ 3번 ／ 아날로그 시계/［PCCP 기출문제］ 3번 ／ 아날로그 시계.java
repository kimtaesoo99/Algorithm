class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int result = calc(h2, m2, s2) - calc(h1, m1, s1);

        if (5 * (h2 % 12 + m2 / 60.0 + s2 / 3600.0) == s2 || m2 + s2 / 60.0 == s2) {
            result++;
        }

        return result;
    }

    public int calc(int h, int m, int s) {
        if (h >= 12) {
            return calc2(11, 59, 59) + calc2(h - 12, m, s);
        } else {
            return calc2(h, m, s);
        }
    }

    public int calc2(int h, int m, int s) {
        if (h == 0 && m == 0 && s == 0) {
            return 0;
        }

        int ret = h * 59 + h * 60 + m * 2 - 1;

        if (5 * (h + m / 60.0 + s / 3600.0) < s) {
            ret += 1;
        }

        if (m + s / 60.0 < s) {
            ret += 1;
        }

        return ret;
    }
}