
class Solution {
    int[] board;
    int count = 0;
    public int solution(int n) {
        board = new int[n];
        chess(n,0);

        return count;
    }

    void chess(int n , int row){
        if (row == n){
            count++;
            return;
        }
        for (int i = 0; i < n;i++){
            board[row] = i;
            if (canPut(row))chess(n,row+1);
        }
    }

    boolean canPut(int row){
        for (int i = 0; i < row; i++){
            if (board[i] == board[row])return false;
            if (Math.abs(row - i) == Math.abs(board[row] - board[i]))return false;
        }
        return true;
    }
}