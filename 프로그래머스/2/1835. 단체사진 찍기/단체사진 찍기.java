class Solution {

    private final String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};

    private boolean[] visited;
    private int result = 0;

    public int solution(int n, String[] data) {

        visited = new boolean[members.length];
        back(0, "", data);

        return result;
    }

    private void back(int index, String sum, String[] data) {
        if (index == members.length) {
            if (isCorrect(sum, data)) {
                result++;
            }
            return;
        }

        for (int i = 0; i < members.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(index + 1, sum + members[i], data);
                visited[i] = false;
            }
        }
    }

    private boolean isCorrect(String batch, String[] data) {
        for (String d : data) {
            char op = d.charAt(3);
            char firstTarget = d.charAt(0);
            char secondTarget = d.charAt(2);
            int gap = d.charAt(4) - '0';

            int firstIndex = batch.indexOf(firstTarget);
            int secondIndex = batch.indexOf(secondTarget);
            int realGap = Math.abs(firstIndex - secondIndex) - 1;

            if (op == '=' && realGap != gap) {
                return false;
            }
            if (op == '>' && realGap <= gap) {
                return false;
            }
            if (op == '<' && realGap >= gap) {
                return false;
            }
        }

        return true;
    }
}