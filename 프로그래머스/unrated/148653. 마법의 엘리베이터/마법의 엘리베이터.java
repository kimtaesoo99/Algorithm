class Solution {
    public int solution(int storey) {
        return elevator(storey);
    }

    private int elevator(int storey) {
        if (storey <= 1) {
            return storey;
        }
        int division = storey / 10;
        int left = storey % 10;
        int up = left + elevator(division);
        int down = 10 - left + elevator(division + 1);
        return Math.min(up, down);
    }
}