class Solution {
    static char[][] map;
    static int count;
    static boolean[][] canBreak;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i = 0; i < m; i++){
            String str = board[i];
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }
        while(hasBreak(m,n)){
            breakBlock(m,n);
            setMap(m,n);
        }

        return count;
    }

    public boolean hasBreak(int m ,int n){
        canBreak = new boolean[m][n];
        boolean moreBreak = false;
        for(int i = 0; i <m-1; i++){
            for(int j = 0; j< n-1; j++){
                if(map[i][j] == ' ')continue;
                char a = map[i][j];
                char b = map[i][j+1];
                char c = map[i+1][j];
                char d = map[i+1][j+1];
                if(a==b && b==c && c==d){
                    canBreak[i][j] = true;
                    canBreak[i][j+1] = true;
                    canBreak[i+1][j] = true;
                    canBreak[i+1][j+1] = true;
                    moreBreak = true;
                }
            }
        }
        return moreBreak;
    }

    public void breakBlock(int m , int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(canBreak[i][j]){
                    map[i][j] =' ';
                    count++;
                }
            }
        }
    }

    public void setMap(int m, int n){
        for(int i = 0; i <n; i++){
            int changeIndex = -1;
            for(int j = m-1; j>=0; j--){
                if(changeIndex!=-1 && map[j][i]!=' '){
                    map[changeIndex][i] = map[j][i];
                    map[j][i] = ' ';
                    i--;
                    break;
                }
                if(map[j][i]==' ')changeIndex = j;
            }
        }
    }
}