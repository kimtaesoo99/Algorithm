class Solution {
    public int solution(String[] board) {
        int oCount = checkCount(board, 'O');
        int xCount = checkCount(board, 'X');
        boolean oWin = checkBingo(board, 'O');
        boolean xWin = checkBingo(board, 'X');

        if (!(oCount - xCount == 0 || oCount - xCount == 1)) {
            return 0;
        }
        if (oWin && xWin) {
            return 0;
        }
        if (oWin && !(oCount - xCount == 1)) {
            return 0;
        }
        if (xWin && !(oCount == xCount)) {
            return 0;
        }
        return 1;
    }

    private int checkCount(String[] board, char target) {
        int count = 0;

        for (String b : board) {
            for (int i = 0; i < 3; i++) {
                char now = b.charAt(i);
                if (now == target) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkBingo(String[] board, char target) {
        for (String b : board) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if (b.charAt(i) == target) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (String b : board) {
                if (b.charAt(i) == target) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }

        if (board[0].charAt(0) == target && board[1].charAt(1) == target
                && board[2].charAt(2) == target) {
            return true;
        }
        if (board[2].charAt(0) == target && board[1].charAt(1) == target
                && board[0].charAt(2) == target) {
            return true;
        }
        return false;
    }
}
