class Solution {
    int[][] map;
    int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};
    int[] dy = {1, 0, 0, -1, 1, -1, -1, 1};

    public int solution(int[][] board) {
        map = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    approachBomb(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    void approachBomb(int y, int x) {
        map[y][x] = 1;
        for (int i = 0; i < 8; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];
            if (0<= moveY && moveY < map.length && 0<= moveX&& moveX < map.length){
                map[moveY][moveX] = 1;
            }
        }
    }
}