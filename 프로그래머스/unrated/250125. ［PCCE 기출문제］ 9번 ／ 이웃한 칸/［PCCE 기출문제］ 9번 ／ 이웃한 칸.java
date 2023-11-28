class Solution {

    private final int[] dy = {1, 0, -1, 0};
    private final int[] dx = {0, -1, 0, 1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            int moveY = h + dy[i];
            int moveX = w + dx[i];

            if (0 <= moveY && moveY < board.length && 0 <= moveX && moveX < board.length) {
                if (board[h][w].equals(board[moveY][moveX])){
                    answer++;
                }
            }
        }

        return answer;
    }
}