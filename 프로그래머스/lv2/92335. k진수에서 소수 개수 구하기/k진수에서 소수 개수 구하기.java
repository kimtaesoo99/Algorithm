import java.util.ArrayList;
import java.util.List;

class Solution {
    static int count = 0;

    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        division(sb.reverse().toString());
        return count;
    }

    private void division(String str) {
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '0' && sb.length() != 0) {
                list.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }
            sb.append(now);
        }
        if (sb.length() != 0) {
            list.add(Long.parseLong(sb.toString()));
        }
        findPrime(list);
    }

    private void findPrime(List<Long> list) {
        for (Long num : list) {
            if (checkPrime(num)) {
                count++;
            }
        }
    }

    private boolean checkPrime(Long num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}