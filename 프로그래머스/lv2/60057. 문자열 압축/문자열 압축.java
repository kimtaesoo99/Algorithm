class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int overlap = 1;
            String now = s.substring(0, i);
            StringBuilder result = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                String next = s.substring(j, Math.min(j + i, s.length()));
                if (now.equals(next)) {
                    overlap++;
                } else {
                    result.append(overlap == 1 ? "" : overlap).append(now);
                    now = next;
                    overlap = 1;
                }
            }
            result.append(now);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}