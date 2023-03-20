class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean pass = true;
        int first = 0;
        int second = 0;

        for (String s : goal) {

            if (first < cards1.length && s.equals(cards1[first])) {
                first++;
            } else if (second < cards2.length && s.equals(cards2[second])) {
                second++;
            } else {
                pass = false;
                break;
            }
        }

        return pass ? "Yes" : "No";
    }
}